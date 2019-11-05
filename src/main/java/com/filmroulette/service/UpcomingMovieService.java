package com.filmroulette.service;

import com.filmroulette.dao.IUpcomingMovieDAO;
import com.filmroulette.dto.UpcomingMovieDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;



/**
 *  Takes data from the DAO and returns the parsed through data.
 *  @return Parsed data from the UpcomingMovieDAO
 */

public class UpcomingMovieService {

    private IUpcomingMovieDAO upcomingMovieDAO;

    public void parseData() throws IOException {
        JSONObject obj = new JSONObject(upcomingMovieDAO.fetchUpcomingMovieData());

        JSONArray arr = obj.getJSONArray("results");
        for (int i = 0; i < arr.length(); i++) {
            String overview = arr.getJSONObject(i).getString("overview");
            String release_date = arr.getJSONObject(i).getString("release_date");
            String title = arr.getJSONObject(i).getString("title");
            UpcomingMovieDTO upcomingMovieDTO = new UpcomingMovieDTO();
            upcomingMovieDTO.setMovieId(i);
            upcomingMovieDTO.setDescription(overview);
            upcomingMovieDTO.setReleaseDate(release_date);
            upcomingMovieDTO.setTitle(title);

        }
    }
}
