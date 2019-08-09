package com.hcl.agenda;

import com.hcl.agenda.mode.po.Contact;
import com.hcl.agenda.model.dao.ContactDAO;

public class Test {

	public static void main(String[] args) {

		ContactDAO contactDAO = new ContactDAO();

		for (Contact c : contactDAO.getAll()) {
			System.out.println(c);
		}

	}

}
