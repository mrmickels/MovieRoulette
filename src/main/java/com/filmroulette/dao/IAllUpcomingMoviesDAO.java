package com.filmroulette.dao;

import com.filmroulette.dto.UpcomingMovieDTO;

import java.util.List;

public interface IAllUpcomingMoviesDAO {
    List<UpcomingMovieDTO> fetch() throws Exception;
}
