package com.filmroulette;

import com.filmroulette.service.UpcomingMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.filmroulette.dto.UpcomingMovieDTO;
import com.filmroulette.service.IUpcomingMovieService;

import java.io.IOException;


@Controller
public class FilmRouletteController {

	@Autowired
	private IUpcomingMovieService upcomingMovieServiceStub;

	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String read(Model model) throws IOException {
		UpcomingMovieService upcomingMovieService = new UpcomingMovieService();
		upcomingMovieService.parseData();
		UpcomingMovieDTO upcomingMovieDTO = upcomingMovieServiceStub.fetchById(1);
		model.addAttribute("upcomingMovieDTO", upcomingMovieDTO);
		
		return "start";
	}
	
	@PostMapping("/start")
	public String create() {
		
		return "start";
	}	
	/*
	 * Handle the / endpoints
	 * @return
	 */
	
	@RequestMapping("/")
	public String index() {
		
		return "start";
	}
}
