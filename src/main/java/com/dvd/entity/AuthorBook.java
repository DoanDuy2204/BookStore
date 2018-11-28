package com.dvd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authors_books")
public class AuthorBook {

	@Id
	@Column(name="id")
	private int id;
	
	
}
