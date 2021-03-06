package com.filmroulette.dao;

import okhttp3.*;
import org.springframework.stereotype.Component;
import java.net.URL;

@Component
public class NetworkDAO {
    /**
     * Return the data found at the given endpoint
     * @param endpoint a URL or other location where we can find data.
     * @return All of the data returned as one string.
     * @throws Exception
     */
    public String request(String endpoint) throws Exception  {
        String responseBody = "";

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/octet-stream");
        RequestBody body = RequestBody.create(mediaType, "{}");
        Request request = new Request.Builder()
                .url(endpoint)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()){

            responseBody = response.body().string();
            // System.out.print(responseBody);

        }
        return responseBody;
    }

    public URL requestImage(String endpoint) throws Exception  {
        // Image sizes available: w92, w154, w185, w342, w500, w780, original
        URL url = new URL("http://image.tmdb.org/t/p/w185/" + endpoint);
        return url;
    }
}
