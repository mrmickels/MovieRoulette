package com.filmroulette.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.filmroulette.FetchData;
import com.filmroulette.dto.MovieDTO;


@Component
public class MovieServiceStub implements IMovieService {


	@Override
	public MovieDTO fetchMovieById(int id) {
		
		ArrayList<String> MovieArrayTitle = new ArrayList<String>();
		ArrayList<String> MovieArrayDescription = new ArrayList<String>();
		ArrayList<String> MovieArrayReleaseDate = new ArrayList<String>();
		MovieDTO MovieDTO = new MovieDTO();
		
		FetchData Movies = new FetchData();
	    Movies.fetchData();
	    
	    MovieArrayTitle = Movies.parseData("title");
	    MovieArrayDescription = Movies.parseData("overview");
	    MovieArrayReleaseDate = Movies.parseData("release_date");
	    
		
		
		for(int i=0; i < MovieArrayTitle.size(); i++) {
			MovieDTO.setMovieId(i);
			MovieDTO.setTitle(MovieArrayTitle.get(i));
			MovieDTO.setReleaseDate(MovieArrayReleaseDate.get(i));
			MovieDTO.setDescription(MovieArrayDescription.get(i));
		}
		return MovieDTO;

	}

	@Override
	public void save(MovieDTO MovieDTO) {
		
	}

}
