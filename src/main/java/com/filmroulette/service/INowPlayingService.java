package com.filmroulette.service;

import com.filmroulette.dto.NowPlayingMovieDTO;

import java.util.List;

public interface INowPlayingService {
    List<NowPlayingMovieDTO> fetchNowPlayingMovies() throws Exception;
}
