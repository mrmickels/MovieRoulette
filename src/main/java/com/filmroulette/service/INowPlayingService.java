package com.filmroulette.service;

import com.filmroulette.dto.MovieDTO;

import java.util.List;

public interface INowPlayingService {
    List<MovieDTO> fetchNowPlayingMovies() throws Exception;
}
