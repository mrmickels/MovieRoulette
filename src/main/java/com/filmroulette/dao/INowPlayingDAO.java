package com.filmroulette.dao;

import com.filmroulette.dto.NowPlayingMovieDTO;

import java.util.List;

public interface INowPlayingDAO {
    List<NowPlayingMovieDTO> fetch() throws Exception;

    List<NowPlayingMovieDTO> fetch(String filepath) throws Exception;
}
