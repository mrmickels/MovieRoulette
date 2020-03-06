package com.filmroulette.service;

import com.filmroulette.dao.INowPlayingDAO;
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
public class NowPlayingService implements INowPlayingService {

    @Autowired
    INowPlayingDAO nowPlayingDAO;

    @Override
    public List<MovieDTO> fetchNowPlayingMovies() throws Exception{
        List<MovieDTO> nowPlayingMovies;

        // This is because I am unable to make Network requests at work, uncomment line 27 and comment line 26 to switch to the actual network requests
         nowPlayingMovies = nowPlayingDAO.fetch("src\\test\\resources\\nowplayingmovieresults.json");
        //nowPlayingMovies = nowPlayingDAO.fetch();

        try{
            if (nowPlayingMovies != null) {
                return nowPlayingMovies;
            }
        } catch (NullPointerException  e) {
            System.out.print("NullPointerException Caught for nowPlayingMovies.fetch()");
        }

        return Collections.emptyList();
    }
}

