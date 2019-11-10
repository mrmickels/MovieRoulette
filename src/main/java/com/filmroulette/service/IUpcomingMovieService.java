package com.filmroulette.service;

import com.filmroulette.dto.UpcomingMovieDTO;

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
	UpcomingMovieDTO fetchById(int id);

	void save(UpcomingMovieDTO upcomingMovieDTO);
	List<UpcomingMovieDTO> fetchUpcomingMovies() throws Exception;

}
