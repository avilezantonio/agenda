package com.hcl.agenda.model.dao;

import com.hcl.agenda.model.po.Phone;
import com.hcl.agenda.util.PersistenceUtil;

public class PhoneDAO extends GenericDAO<Phone> {

	public PhoneDAO() {
		super(PersistenceUtil.getInstance().getEntityManager());
	}

}
