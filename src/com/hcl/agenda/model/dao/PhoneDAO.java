package com.hcl.agenda.model.dao;

import com.hcl.agenda.PersistenceUtil;
import com.hcl.agenda.mode.po.Phone;

public class PhoneDAO extends GenericDAO<Phone> {

	public PhoneDAO() {
		super(PersistenceUtil.getInstance().getEntityManager());
	}

}
