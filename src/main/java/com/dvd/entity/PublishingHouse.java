package com.dvd.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="publishing_houses")
public class PublishingHouse {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="doc")
	private Date doc;

	public PublishingHouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PublishingHouse(int id, String name, Date doc) {
		super();
		this.id = id;
		this.name = name;
		this.doc = doc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDoc() {
		return doc;
	}

	public void setDoc(Date doc) {
		this.doc = doc;
	}
}
