package com.filmroulette.service;


import com.filmroulette.dao.IAllUpcomingMoviesDAO;
import com.filmroulette.dto.UpcomingMovieDTO;

import java.util.List;

/**
 *  Takes data from the DAO and returns the parsed through data.
 *  @return Parsed data from the UpcomingMovieDAO
 */

public class UpcomingMovieService implements IUpcomingMovieService{


    IAllUpcomingMoviesDAO allUpcomingMoviesDAO;

    @Override
    public UpcomingMovieDTO fetchById(int id) {
        return null;
    }

    @Override
    public void save(UpcomingMovieDTO upcomingMovieDTO) {

    }



    public List<UpcomingMovieDTO> fetchUpcomingMovies() throws Exception{
        return allUpcomingMoviesDAO.fetch();
    }
}

