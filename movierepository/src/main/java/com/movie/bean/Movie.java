/**
 * 
 */
package com.movie.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Karan Bhatia
 *
 */

@Table(name = "movie")
@Entity
public class Movie {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String popularity;
	@Column
	private String director;
	@Column
	private String imdb_score;
	@Column
	private String name;
    
    @OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
  name = "movie_genre", 
  joinColumns = @JoinColumn(name = "movie_id"), 
  inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private   Set<Genre> genresin;


	public Movie(int id, String popularity, String director, String imdb_score, String name, Set<Genre> genre) {
	super();
	this.id = id;
	this.popularity = popularity;
	this.director = director;
	this.imdb_score = imdb_score;
	this.name = name;
	this.genresin = genre;
}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPopularity() {
		return popularity;
	}


	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getImdb_score() {
		return imdb_score;
	}


	public void setImdb_score(String imdb_score) {
		this.imdb_score = imdb_score;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Genre> getGenre() {
		return genresin;
	}


	public void setGenre(Set<Genre> genre) {
		this.genresin = genre;
	}


	public Movie() {
		super();
	}
 	
}
