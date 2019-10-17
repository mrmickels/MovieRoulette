package com.filmroulette.service;
import com.filmroulette.dto.*;


/**
 * CRUD operations for specimens
 * @author Administrator
 *
 */

public interface IUpcomingMovieService {
	
	/**
	 * Get specimens from persistence layer
	 *@param id a unique lookup
	 *@return a specimen with a matching ID
	 */
	UpcomingMovieDTO fetchById(int id);
	
	/**
	 *Persist the given DTO
	 *@param specimenDTO
	 */

	void save(UpcomingMovieDTO upcomingMovieDTO);

}
