package com.hcl.agenda.model.dao;

import com.hcl.agenda.PersistenceUtil;
import com.hcl.agenda.mode.po.Contact;

public class ContactDAO extends GenericDAO<Contact> {

	public ContactDAO() {
		super(PersistenceUtil.getInstance().getEntityManager());
	}

}
