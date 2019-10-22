package com.filmroulette.service;
import com.filmroulette.dto.*;


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
	UpcomingMovieDTO fetchById(int id);
	
	/**
	 *
	 *@param upcomingMovieDTO
	 */

	void save(UpcomingMovieDTO upcomingMovieDTO);

}
