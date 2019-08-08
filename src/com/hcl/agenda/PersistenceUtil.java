package com.hcl.agenda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	private static PersistenceUtil instance = null;

	private PersistenceUtil() {
		this.initManager();
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public static PersistenceUtil getInstance() {
		if (null == instance) {
			instance = new PersistenceUtil();
		}

		return instance;
	}

	private void initManager() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("agenda");
		this.entityManager = entityManagerFactory.createEntityManager();
	}

}
