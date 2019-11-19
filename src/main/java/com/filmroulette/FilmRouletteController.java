package com.filmroulette;

import com.filmroulette.dto.MovieDTO;
import com.filmroulette.service.IImageService;
import com.filmroulette.dao.ISearchDAO;
import com.filmroulette.dto.NowPlayingMovieDTO;
import com.filmroulette.service.INowPlayingService;
import com.filmroulette.service.IUpcomingMovieService;
import org.apache.tomcat.util.codec.binary.Base64;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	private IImageService imageService;
	@Autowired
	private ISearchDAO searchDAO;
	@Autowired
    private INowPlayingService nowPlayingService;



	@GetMapping(value="/start")
		public ModelAndView start() throws Exception {
			ModelAndView modelAndView = new ModelAndView();

			try{
				Iterable<MovieDTO> allUpcomingMovies = upcomingMovieService.fetchUpcomingMovies();
				modelAndView.setViewName("start");
				modelAndView.addObject("allUpcomingMovies", allUpcomingMovies);

				Iterable<MovieDTO> nowPlayingMovie = nowPlayingService.fetchNowPlayingMovies();
				modelAndView.addObject("nowPlayingMovie", nowPlayingMovie);

			}
			catch (Exception e){
				e.printStackTrace();

			}
			return modelAndView;

		}

	// Test endpoint for displaying images
	@GetMapping(value="/imagetest", produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage() throws Exception {


		byte[] bytes = Base64.decodeBase64(imageService.fetchImage());
		return ResponseEntity
				.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.body(bytes);
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
