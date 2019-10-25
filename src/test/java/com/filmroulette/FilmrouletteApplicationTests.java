package com.filmroulette;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmRouletteApplicationTests {

	@Test
	public void contextLoads() {
	}

	public void invalidSearch() {
		System.out.println("Test for invalid searches so that special characters will not break the application.");
	}
	
	public void validSearch() {
		System.out.println("Test for valid searches");
	}
	
	public void genreSearch() {
		System.out.println ("Test how the app sorts genres for movies. ");
	}
	
	public void artistSearch() {
		System.out.println ("Test searching for artists ie creator of the movie such as Steven Speilberg.");
	}
	
	public void arragatedSearch() {
		System.out.println ("Test search for 2 genres such as action and comedy.");
	}
	
	public void testclickedMovie() {
		System.out.println ("Test what app does when you click on a movie.  ");
	}
}
