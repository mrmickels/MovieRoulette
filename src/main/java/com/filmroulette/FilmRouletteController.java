package com.filmroulette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.filmroulette.dto.UpcomingMovieDTO;
import com.filmroulette.service.IUpcomingMovieService;


@Controller
public class FilmRouletteController {

	@Autowired
	private IUpcomingMovieService upcomingMovieServiceStub;
    /*
     * Initial page for the application
     * @return String
     */
	@RequestMapping(value="/start", method=RequestMethod.GET)
	public String read(Model model) {
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
