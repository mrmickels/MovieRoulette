package com.filmroulette.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UpcomingMovieList {
    @SerializedName("movies")
    @Expose
    private List<UpcomingMovieDTO> movies = null;

    public List<UpcomingMovieDTO> getMovies(){
        return movies;
    }

    public void setMovies(List<UpcomingMovieDTO> movies) {
        this.movies = movies;
    }
}
