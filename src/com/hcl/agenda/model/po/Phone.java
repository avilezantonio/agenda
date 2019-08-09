package com.hcl.agenda.model.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude= {"contact"})
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String phone;
	private int type;
	
	@ManyToOne
    @JoinColumn(name="contact_id", nullable=false)
	private Contact contact;

}
