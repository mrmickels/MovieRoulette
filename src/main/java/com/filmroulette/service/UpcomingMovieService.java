package com.filmroulette.service;


import com.filmroulette.dao.IAllUpcomingMoviesDAO;
import com.filmroulette.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 *  Takes data from the DAO and returns the parsed through data.
 *  @return Parsed data from the UpcomingMovieDAO
 */
@Component
public class UpcomingMovieService implements IUpcomingMovieService{

    @Autowired
    IAllUpcomingMoviesDAO allUpcomingMoviesDAO;

    @Override
    public MovieDTO fetchById(int id) {
        return null;
    }

    @Override
    public void save(MovieDTO movieDTO) {

    }


    @Override
    public List<MovieDTO> fetchUpcomingMovies() throws Exception{

        List<MovieDTO> allUpcomingMovies;

        // This is because I am unable to make Network requests at work, uncomment line 41 and comment line 40 to switch to the actual network requests
        allUpcomingMovies = allUpcomingMoviesDAO.fetch("src\\test\\resources\\upcomingmovieresults.json");
        //allUpcomingMovies = allUpcomingMoviesDAO.fetch();

        try{
            if (allUpcomingMovies != null) {
                return allUpcomingMovies;
            }
        } catch (NullPointerException  e) {
            System.out.print("NullPointerException Caught for allUpcomingMoviesDAO.fetch()");
        }

        return Collections.emptyList();
    }
}

