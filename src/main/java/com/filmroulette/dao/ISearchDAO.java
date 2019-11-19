package com.filmroulette.dao;

import com.filmroulette.dto.MovieDTO;

import java.util.List;

public interface ISearchDAO {
	List<MovieDTO> fetch(String searchTerm) throws Exception;

}
