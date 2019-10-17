package com.filmroulette;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/start")
public class FilmRouletteController {

    @GetMapping
    String getView(Model model){
    	FetchData upcomingMovies = new FetchData();
    	upcomingMovies.fetchData();
        model.addAttribute("msg", upcomingMovies.parseData());
        return "start";
    }
	
}
