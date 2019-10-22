package com.filmroulette.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.filmroulette.FetchData;
import com.filmroulette.dto.UpcomingMovieDTO;


@Component
public class UpcomingMovieServiceStub implements IUpcomingMovieService {


	@Override
	public UpcomingMovieDTO fetchById(int id) {
		
		ArrayList<String> upcomingMovieArrayTitle = new ArrayList<String>();
		ArrayList<String> upcomingMovieArrayDescription = new ArrayList<String>();
		ArrayList<String> upcomingMovieArrayReleaseDate = new ArrayList<String>();
		UpcomingMovieDTO upcomingMovieDTO = new UpcomingMovieDTO();
		
		FetchData upcomingMovies = new FetchData();
	    upcomingMovies.fetchData();
	    
	    upcomingMovieArrayTitle = upcomingMovies.parseData("title");
	    upcomingMovieArrayDescription = upcomingMovies.parseData("overview");
	    upcomingMovieArrayReleaseDate = upcomingMovies.parseData("release_date");
	    
		
		
		for(int i=0; i < upcomingMovieArrayTitle.size(); i++) {
			upcomingMovieDTO.setMovieId(i);
			upcomingMovieDTO.setTitle(upcomingMovieArrayTitle.get(i));
			upcomingMovieDTO.setReleaseDate(upcomingMovieArrayReleaseDate.get(i));
			upcomingMovieDTO.setDescription(upcomingMovieArrayDescription.get(i));
		}
		return upcomingMovieDTO;

	}

	@Override
	public void save(UpcomingMovieDTO upcomingMovieDTO) {
		
	}

}
