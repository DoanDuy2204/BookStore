package com.dvd.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="authors")
public class Author {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="doc")
	private Date doc;
	
	@Column(name="address")
	private String address;
	
	@ManyToMany
	@JoinTable(name="authors_products",
				joinColumns=@JoinColumn(name="author_id"),
				inverseJoinColumns=@JoinColumn(name="product_id"))
	private List<Author> authors;
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Author(String name, Date doc, String address) {
		super();
		this.name = name;
		this.doc = doc;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
