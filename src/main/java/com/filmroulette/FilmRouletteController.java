package com.filmroulette;


import com.filmroulette.dto.UpcomingMovieDTO;
import com.filmroulette.service.IUpcomingMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FilmRouletteController {

	@Autowired
	private IUpcomingMovieService upcomingMovieService;


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
}
