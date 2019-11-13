package com.filmroulette.dao;

import com.filmroulette.dto.NowPlayingMovieDTO;

import java.util.List;

public interface ISearchDAO {
	List<NowPlayingMovieDTO> fetch(String searchTerm) throws Exception;

}
