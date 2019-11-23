package com.filmroulette.dao;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.filmroulette.dto.MovieDTO;

@Component
public class SearchDAO implements ISearchDAO {
	
	@Autowired
    private NetworkDAO networkDAO;

	//may have to encode if user enters a special character
	@Override
	public List<MovieDTO> fetch(String searchTerm) throws Exception {
		List<MovieDTO> searchResults = new ArrayList<>();
		String endpoint = "https://api.themoviedb.org/3/search/movie?query=";
		String api = "&api_key=f1165dd92f85c95c3898f9f66103659e";
		String rawJson = networkDAO.request(endpoint + searchTerm.toLowerCase() + api);
		return getSearchResultMovieDTOS(searchResults, rawJson);
	}
	
	private List<MovieDTO> getSearchResultMovieDTOS(List<MovieDTO> searchResults, String rawJson) {
		JSONObject obj = new JSONObject(rawJson);
        JSONArray movies = obj.getJSONArray("results");

        for (int i = 0; i < movies.length(); i++) {

            // JSON Data
            JSONObject jsonMovie = movies.getJSONObject(i);
            
            //skip over results that don't have a poster_path
            if(!(jsonMovie.get("poster_path") instanceof String)) {
            	continue;
            }
            
            // Movie object that will be populated from JSON data
            MovieDTO movieDTO = new MovieDTO();

            String overview = jsonMovie.getString("overview");
            String released = jsonMovie.getString("release_date");
            String title = jsonMovie.getString("title");
            double voteAverage = jsonMovie.getDouble("vote_average");
            String posterPath = jsonMovie.getString("poster_path");
           
            
            // populate the DTO with this information
            movieDTO.setMovieId(i);
            movieDTO.setDescription(overview);
            movieDTO.setReleaseDate(released);
            movieDTO.setTitle(title);
            movieDTO.setVoteAverage(voteAverage);
            movieDTO.setPosterPath(posterPath);

            // add the populated movie to our collection
            searchResults.add(movieDTO);
        }

        return searchResults;
    }

}
