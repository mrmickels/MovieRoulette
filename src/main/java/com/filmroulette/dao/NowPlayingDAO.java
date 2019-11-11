package com.filmroulette.dao;

import com.filmroulette.dto.NowPlayingMovieDTO;
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
public class NowPlayingDAO implements INowPlayingDAO {

    @Autowired
    private NetworkDAO networkDAO;

    @Override
    public List<NowPlayingMovieDTO> fetch() throws Exception{
        List<NowPlayingMovieDTO> nowPlayingMovies = new ArrayList<>();
        String rawJson = networkDAO.request("https://api.themoviedb.org/3/movie/now_playing?page=1&language=en-US&api_key=f1165dd92f85c95c3898f9f66103659e");
        return getNowPlayingMovieDTOS(nowPlayingMovies, rawJson);

    }

    @Override
    public List<NowPlayingMovieDTO> fetch(String filepath) throws Exception{
        List<NowPlayingMovieDTO> nowPlayingMovies = new ArrayList<>();

        String rawJson = "";
        try{
            rawJson = new String ( Files.readAllBytes( Paths.get(filepath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return getNowPlayingMovieDTOS(nowPlayingMovies, rawJson);
    }


    private List<NowPlayingMovieDTO> getNowPlayingMovieDTOS(List<NowPlayingMovieDTO> nowPlayingMovies, String rawJson) {
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
            nowPlayingMovies.add(nowPlayingMovieDTO);
        }

        return nowPlayingMovies;
    }


}
