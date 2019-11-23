package com.filmroulette.dao;

import com.filmroulette.dto.MovieDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class AllUpcomingMoviesDAO implements IAllUpcomingMoviesDAO {

    @Autowired
    private NetworkDAO networkDAO;


    @Override
    public List<MovieDTO> fetch() throws Exception{

        List<MovieDTO> allUpcomingMovies = new ArrayList<>();
        String rawJson = networkDAO.request("https://api.themoviedb.org/3/movie/upcoming?page=1&language=en-US&api_key=f1165dd92f85c95c3898f9f66103659e");
        return getUpcomingMovieDTOS(allUpcomingMovies, rawJson);
    }
    /**
     * Return JSON for allUpcomingMoveis
     * @param takes filepath
     * @return DTO for UpcomingMove
     * @throws Exception if filepath cannot be read
     */

    public List<MovieDTO> fetch(String filepath) throws Exception{
        List<MovieDTO> allUpcomingMovies = new ArrayList<>();

        String rawJson = "";
        try{
            rawJson = new String ( Files.readAllBytes( Paths.get(filepath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return getUpcomingMovieDTOS(allUpcomingMovies, rawJson);
    }

    private List<MovieDTO> getUpcomingMovieDTOS(List<MovieDTO> allUpcomingMovies, String rawJson) {
        JSONObject obj = new JSONObject(rawJson);
        JSONArray movies = obj.getJSONArray("results");

        for (int i = 0; i < movies.length(); i++) {

            // JSON Data
            JSONObject jsonMovie = movies.getJSONObject(i);
            // Movie object that will be populated from JSON data
            MovieDTO upcomingMovieDTO = new MovieDTO();

            String overview = jsonMovie.getString("overview");
            String released = jsonMovie.getString("release_date");
            String title = jsonMovie.getString("title");
            String posterPath = jsonMovie.getString("poster_path");

            // populate the DTO with this information
            upcomingMovieDTO.setMovieId(i);
            upcomingMovieDTO.setDescription(overview);
            upcomingMovieDTO.setReleaseDate(released);
            upcomingMovieDTO.setTitle(title);
            upcomingMovieDTO.setPosterPath(posterPath);

            // add the populated movie to our collection
            allUpcomingMovies.add(upcomingMovieDTO);
        }

        return allUpcomingMovies;
    }

}
