package com.filmroulette.service;

import com.filmroulette.dto.MovieDTO;

import java.util.List;


/**
 * CRUD operations for specimens
 * @author Administrator
 *
 */

public interface IUpcomingMovieService {
	
	/**
	 * Get movies
	 *@param id a unique lookup
	 *@return a movie with matching movie
	 */
	MovieDTO fetchById(int id);

	void save(MovieDTO movieDTO);
	List<MovieDTO> fetchUpcomingMovies() throws Exception;

}
