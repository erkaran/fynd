package com.movie.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "genre")
@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String genre;
	

	public Genre(int id, String genre) {
	super();
	this.id = id;
	this.genre = genre;
}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Genre(String genre) {
		super();
		this.genre = genre;
	}

	
	public Genre() {
		super();
	}
    
}
