package com.filmroulette.dao;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.filmroulette.dto.NowPlayingMovieDTO;

public class SearchDAO implements ISearchDAO {
	
	@Autowired
    private NetworkDAO networkDAO;

	//may have to encode if user enters a special character
	@Override
	public List<NowPlayingMovieDTO> fetch(String searchTerm) throws Exception {
		List<NowPlayingMovieDTO> searchResults = new ArrayList<>();
		String endpoint = "https://api.themoviedb.org/3/search/movie?query=";
		String api = "&api_key=f1165dd92f85c95c3898f9f66103659e";
		String rawJson = networkDAO.request(endpoint + searchTerm + api);
		return parseSearchResults(searchResults, rawJson);
	}
	
	private List<NowPlayingMovieDTO> parseSearchResults(List<NowPlayingMovieDTO> searchResults, String rawJson) {
        JSONObject obj = new JSONObject(rawJson);
        JSONArray movies = obj.getJSONArray("results");

        for (int i = 0; i < movies.length(); i++) {

            // JSON Data
            JSONObject jsonMovie = movies.getJSONObject(i);
            // Movie object that will be populated from JSON data
            NowPlayingMovieDTO nowPlayingMovieDTO = new NowPlayingMovieDTO();

            String overview = jsonMovie.getString("overview");
            String released = jsonMovie.getString("release_date");
            String title = jsonMovie.getString("title");
            double voteAverage = jsonMovie.getDouble("vote_average");

            // populate the DTO with this information
            nowPlayingMovieDTO.setMovieId(i);
            nowPlayingMovieDTO.setDescription(overview);
            nowPlayingMovieDTO.setReleaseDate(released);
            nowPlayingMovieDTO.setTitle(title);
            nowPlayingMovieDTO.setVoteAverage(voteAverage);

            // add the populated movie to our collection
            searchResults.add(nowPlayingMovieDTO);
        }

        return searchResults;
    }

}
