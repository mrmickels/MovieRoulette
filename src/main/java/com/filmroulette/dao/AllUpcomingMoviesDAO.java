package com.filmroulette.dao;

import com.filmroulette.dto.UpcomingMovieDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AllUpcomingMoviesDAO implements IAllUpcomingMoviesDAO {

    public List<UpcomingMovieDTO> fetch() throws Exception{

        List<UpcomingMovieDTO> allUpcomingMovies = new ArrayList<>();
        IUpcomingMovieDAO upcomingMovieDAO = new UpcomingMovieDAO();
        JSONObject obj = new JSONObject(upcomingMovieDAO.fetchUpcomingMovieData());
        JSONArray movies = obj.getJSONArray("results");

        for (int i = 0; i < movies.length(); i++) {

            // JSON Data
            JSONObject jsonMovie = movies.getJSONObject(i);
            // Movie object that will be populated from JSON data
            UpcomingMovieDTO upcomingMovieDTO = new UpcomingMovieDTO();

            String overview = jsonMovie.getString("overview");
            String release_date = jsonMovie.getString("release_date");
            String title = jsonMovie.getString("title");

            // populate the DTO with this information
            upcomingMovieDTO.setMovieId(i);
            upcomingMovieDTO.setDescription(overview);
            upcomingMovieDTO.setReleaseDate(release_date);
            upcomingMovieDTO.setTitle(title);

            // add the populated movie to our collection
            allUpcomingMovies.add(upcomingMovieDTO);
        }

        return allUpcomingMovies;
    }

}
