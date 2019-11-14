package com.filmroulette;


import com.filmroulette.dto.UpcomingMovieDTO;
import com.filmroulette.dao.ISearchDAO;
import com.filmroulette.dto.NowPlayingMovieDTO;
import com.filmroulette.service.IUpcomingMovieService;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FilmRouletteController {

	@Autowired
	private IUpcomingMovieService upcomingMovieService;
	
	@Autowired
	private ISearchDAO searchDAO;


	@GetMapping(value="/start")
		public ModelAndView start() throws Exception {
			ModelAndView modelAndView = new ModelAndView();

			try{
				Iterable<UpcomingMovieDTO> allUpcomingMovies = upcomingMovieService.fetchUpcomingMovies();
				modelAndView.setViewName("start");
				modelAndView.addObject("allUpcomingMovies", allUpcomingMovies);

			}
			catch (Exception e){
				e.printStackTrace();

			}
			return modelAndView;

		}


	
	@PostMapping("/start")
	public String create() {
		
		return "start";
	}
	
    // search for movies
	@RequestMapping("/searchMovies")
	public ModelAndView searchMovies(@RequestParam(value="searchTerm", required=false, defaultValue="") String searchTerm) {
		ModelAndView modelAndView = new ModelAndView();
		List<NowPlayingMovieDTO> searchResults = new ArrayList<>();
		
		try {
			searchResults =  searchDAO.fetch(searchTerm);
			modelAndView.setViewName("movieResults");
			// set off and error if movies = 0
		} catch (Exception  e) {
			e.printStackTrace();
			modelAndView.setViewName("error");
		}
		
		modelAndView.addObject("searchResults", searchResults);
		return modelAndView;
	}
}
