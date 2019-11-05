package com.filmroulette.dao;

import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UpcomingMovieDAO implements IUpcomingMovieDAO {

    /**
     * Get a list of upcoming movies in theatres.
     * @return HTTP Stream from MovieDB API
     * @throws IOException
     */
    public String fetchUpcomingMovieData() throws IOException{
            String responseBody = "";

            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/octet-stream");
            RequestBody body = RequestBody.create(mediaType, "{}");
            Request request = new Request.Builder()
                    .url("https://api.themoviedb.org/3/movie/upcoming?page=1&language=en-US&api_key=f1165dd92f85c95c3898f9f66103659e")
                    .get()
                    .build();

            try (Response response = client.newCall(request).execute()){

            responseBody = response.body().string();
            System.out.print(responseBody);
            return responseBody;
        }
    }
}
