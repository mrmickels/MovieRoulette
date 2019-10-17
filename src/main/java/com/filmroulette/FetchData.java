/*
 * using OkHttp to make the HTTP request to API
 * using org.json to parse the JSON data 
 */
package com.filmroulette;

import okhttp3.*;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class FetchData {
	String responseBody = "";
	String json = "...";
	String resultsTitle = "...";
	
	// method to pull data from API *need to make method have a parameter to have the URL passed to it instead of the static request
    public String fetchData(){
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/octet-stream");
            RequestBody body = RequestBody.create(mediaType, "{}");
            Request request = new Request.Builder()
                    .url("https://api.themoviedb.org/3/movie/upcoming?page=1&language=en-US&api_key=f1165dd92f85c95c3898f9f66103659e")
                    .get()
                    .build();

            Response response = client.newCall(request).execute();
            responseBody = response.body().string();
            System.out.print(responseBody);
        }
        catch (IOException ie) {
            ie.printStackTrace();
        }
        json = responseBody;
		return responseBody;
    }
    
    // method to parse the data and only pull the upcoming movie titles
    public String parseData(){
    	
    	JSONObject obj = new JSONObject(json);
    	
    	JSONArray arr = obj.getJSONArray("results");
    	for (int i = 0; i < arr.length(); i++) {
    		String results_title = arr.getJSONObject(i).getString("title");
    		System.out.println(results_title);
    		resultsTitle = results_title;
    		
    	}
    	return resultsTitle;
    }
}
