package com.hcl.agenda.model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class GenericDAO<T> {

	private final EntityManager entityManager;
	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public GenericDAO(final EntityManager entityManager) {
		this.entityManager = entityManager;
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void save(T entity) {

		Optional.ofNullable(entity).ifPresent(e -> {
			entityManager.getTransaction().begin();
			entityManager.persist(e);
			entityManager.getTransaction().commit();
		});

	}

	public List<T> getAll() {
		final StringBuilder queryBuilder = new StringBuilder("select e from ")
				.append(this.persistentClass.getSimpleName()).append(" e");
		final TypedQuery<T> query = this.entityManager.createQuery(queryBuilder.toString(), this.persistentClass);
		return query.getResultList();
	}

}
