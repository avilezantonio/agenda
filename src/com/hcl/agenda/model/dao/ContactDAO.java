package com.hcl.agenda.model.dao;

import com.hcl.agenda.model.po.Contact;
import com.hcl.agenda.util.PersistenceUtil;

public class ContactDAO extends GenericDAO<Contact> {

	public ContactDAO() {
		super(PersistenceUtil.getInstance().getEntityManager());
	}

}
