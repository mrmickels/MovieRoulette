package com.filmroulette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.filmroulette.dto.MovieDTO;
import com.filmroulette.service.IMovieService;


@Controller
public class FilmRouletteController {

	@Autowired
	private IMovieService MovieServiceStub;

	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String read(Model model) {
		MovieDTO MovieDTO = MovieServiceStub.fetchMovieById(1);
		model.addAttribute("MovieDTO", MovieDTO);
		
		return "start";
	}
	
	@PostMapping("/start")
	public String create() {
		
		return "start";
	}	
	/*
	 * Handle the / end points
	 * @return
	 */
	
	@RequestMapping("/")
	public String index() {
		
		return "start";
	}
}
