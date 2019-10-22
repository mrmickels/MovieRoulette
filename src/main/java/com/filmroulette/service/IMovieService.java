package com.filmroulette.service;
import com.filmroulette.dto.*;


/**
 * CRUD operations for specimens
 * @author Administrator
 *
 */

public interface IMovieService {
	
	/**
	 * Get movies
	 *@param id a unique lookup
	 *@return a movie with matching movie
	 */
	MovieDTO fetchMovieById(int id);
	
	/**
	 *
	 *@param MovieDTO
	 */

	void save(MovieDTO MovieDTO);

}
