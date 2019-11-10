package com.filmroulette.service;


import com.filmroulette.dao.IAllUpcomingMoviesDAO;
import com.filmroulette.dto.UpcomingMovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public UpcomingMovieDTO fetchById(int id) {
        return null;
    }

    @Override
    public void save(UpcomingMovieDTO upcomingMovieDTO) {

    }


    @Override
    public List<UpcomingMovieDTO> fetchUpcomingMovies() throws Exception{

        List<UpcomingMovieDTO> allUpcomingMovies;

        // This is because I am unable to make Network requests at work, uncomment line 41 and comment line 40 to switch to the actual network requests
        allUpcomingMovies = allUpcomingMoviesDAO.fetch("src\\test\\resources\\upcomingmovieresults.json");
        // allUpcomingMovies = allUpcomingMoviesDAO.fetch();

        try{

            System.out.print(allUpcomingMovies);
            if (allUpcomingMovies != null) {
                return allUpcomingMovies;
            }
        } catch (NullPointerException  e) {
            e.printStackTrace();
            System.out.print("NullPointerException Caught for allUpcomingMoviesDAO.fetch()");
        }

        return null;
    }
}

