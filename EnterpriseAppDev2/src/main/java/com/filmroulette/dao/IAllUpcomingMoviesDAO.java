package com.filmroulette.dao;

import com.filmroulette.dto.MovieDTO;

import java.util.List;

public interface IAllUpcomingMoviesDAO {
    List<MovieDTO> fetch() throws Exception;
    List<MovieDTO> fetch(String filepath) throws Exception;
}
