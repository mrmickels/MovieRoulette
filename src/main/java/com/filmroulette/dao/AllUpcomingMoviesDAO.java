package com.filmroulette.dao;

import com.filmroulette.dto.UpcomingMovieDTO;
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
    NetworkDAO networkDAO;


    @Override
    public List<UpcomingMovieDTO> fetch() throws Exception{

        List<UpcomingMovieDTO> allUpcomingMovies = new ArrayList<>();
        String rawJson = networkDAO.request("https://api.themoviedb.org/3/movie/upcoming?page=1&language=en-US&api_key=f1165dd92f85c95c3898f9f66103659e");
        JSONObject obj = new JSONObject(rawJson);
        System.out.print(obj);
        JSONArray movies = obj.getJSONArray("results");
        System.out.print(movies);

        for (int i = 0; i < movies.length(); i++) {

            // JSON Data
            JSONObject jsonMovie = movies.getJSONObject(i);
            // Movie object that will be populated from JSON data
            UpcomingMovieDTO upcomingMovieDTO = new UpcomingMovieDTO();

            String overview = jsonMovie.getString("overview");
            String released = jsonMovie.getString("release_date");
            String title = jsonMovie.getString("title");

            // populate the DTO with this information
            upcomingMovieDTO.setMovieId(i);
            upcomingMovieDTO.setDescription(overview);
            upcomingMovieDTO.setReleaseDate(released);
            upcomingMovieDTO.setTitle(title);

            // add the populated movie to our collection
            allUpcomingMovies.add(upcomingMovieDTO);
        }

        return allUpcomingMovies;
    }

    public List<UpcomingMovieDTO> fetch(String filepath) throws Exception{
        List<UpcomingMovieDTO> allUpcomingMovies = new ArrayList<>();

        String rawJson = "";
        try{
            rawJson = new String ( Files.readAllBytes( Paths.get(filepath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        JSONObject obj = new JSONObject(rawJson);
        System.out.print(obj);
        JSONArray movies = obj.getJSONArray("results");
        System.out.print(movies);

        for (int i = 0; i < movies.length(); i++) {

            // JSON Data
            JSONObject jsonMovie = movies.getJSONObject(i);
            // Movie object that will be populated from JSON data
            UpcomingMovieDTO upcomingMovieDTO = new UpcomingMovieDTO();

            String overview = jsonMovie.getString("overview");
            String released = jsonMovie.getString("release_date");
            String title = jsonMovie.getString("title");

            // populate the DTO with this information
            upcomingMovieDTO.setMovieId(i);
            upcomingMovieDTO.setDescription(overview);
            upcomingMovieDTO.setReleaseDate(released);
            upcomingMovieDTO.setTitle(title);

            // add the populated movie to our collection
            allUpcomingMovies.add(upcomingMovieDTO);
        }

        return allUpcomingMovies;


    }

}
