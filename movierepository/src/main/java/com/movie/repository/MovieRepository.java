/**
 * 
 */
package com.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.bean.Movie;

/**
 * @author Karan Bhatia
 *
 */

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
