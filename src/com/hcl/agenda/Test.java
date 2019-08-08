package com.hcl.agenda;

import java.util.Optional;

import com.hcl.agenda.mode.dao.ContactDAO;
import com.hcl.agenda.mode.po.Contact;

public class Test {

	public static void main(String[] args) {

		ContactDAO contactDAO = new ContactDAO();

		Contact contact = new Contact();
		contact.setName("my contact");
		contact.setLastName("jpa rules");
		contact.setNick("lalals");

		contactDAO.save(contact);

		contact = new Contact();
		contact.setName("other contact");
		contact.setLastName("jpa rules");
		contact.setNick("the trainer sucks");

		contactDAO.save(contact);

		Optional.ofNullable(contactDAO.getAll()).ifPresent(l -> l.forEach(c -> System.out.println(c)));

	}

}
