/**
 * 
 */
package com.movie.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	@PutMapping
	public ResponseEntity<Object> createMovie(@RequestBody Movie movie){
		
		movie = movieRepository.save(movie);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(movie.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping
	public ResponseEntity<Object> getAll(){
		List<Movie> list = movieRepository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
}
