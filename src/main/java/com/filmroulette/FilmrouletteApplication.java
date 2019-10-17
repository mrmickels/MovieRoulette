package com.filmroulette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmrouletteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmrouletteApplication.class, args);

	    FetchData upcomingMovies = new FetchData();
	    upcomingMovies.fetchData();
	    upcomingMovies.parseData(); 
    
	}
}
