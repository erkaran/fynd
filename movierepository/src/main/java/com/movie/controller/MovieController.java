/**
 * 
 */
package com.movie.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.movie.bean.Movie;
import com.movie.repository.MovieRepository;

/**
 * @author karbhati1
 *
 */

@RestController
@RequestMapping("/v1/movie")
public class MovieController {

	@Autowired
	MovieRepository movieRepository;

	@PutMapping(produces = "application/json")
	public ResponseEntity<Object> createMovie(@RequestBody Movie movie) {

		movie = movieRepository.save(movie);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movie.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(value= "/multiple" ,produces = "application/json")
	public ResponseEntity<Object> createMovies(@RequestBody List<Movie> movie) {

		movie = movieRepository.saveAll(movie);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").build().toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(produces = "application/json")
	public ResponseEntity<Object> getAll() {
		List<Movie> list = movieRepository.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Object> getById(@PathVariable int id) {
		Optional<Movie> list = movieRepository.findById(id);
		return ResponseEntity.ok().body(list.get());
	}
	
	@GetMapping(value = "/name={name}", produces = "application/json")
	public ResponseEntity<Object> getByName(@PathVariable String name) {
		List<Movie> list = movieRepository.findByName(name);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping(produces = "application/json")
	public ResponseEntity<Object> updateMovie(@RequestBody Movie movie) {

		movie = movieRepository.save(movie);
		return ResponseEntity.ok(movie);
	}
	
	
	@DeleteMapping(produces = "application/json")
	public BodyBuilder deleteMovie(@RequestBody Movie movie) {

		movieRepository.delete(movie);
		return ResponseEntity.ok();
	}
	
	@DeleteMapping(value = "/{id}" , produces = "application/json")
	public BodyBuilder deleteMovieByID(@PathVariable int id) {

		movieRepository.deleteById(id);
		return ResponseEntity.ok();
	}
}
