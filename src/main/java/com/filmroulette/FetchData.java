/*
 * using OkHttp to make the HTTP request to API
 * using org.json to parse the JSON data 
 */
package com.filmroulette;

import okhttp3.*;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class FetchData {
	String responseBody = "";
	String json = "...";
	//String resultsTitle = "...";
	String resultsQueried = "...";
	//String releaseDate = "...";
    ArrayList<String> upcomingArray = new ArrayList<String>(); 
    

	
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
            responseBody = response.body().toString();
            System.out.print(responseBody);
        }
        catch (IOException ie) {
            ie.printStackTrace();
        }
        json = responseBody;
		return responseBody;
    }
    
    // method to parse the data and only pull the upcoming movie titles
    public ArrayList<String> parseData(String resultQuery){
    	
    	//resultQuery = "\"" + resultQuery + "\"";
    	JSONObject obj = new JSONObject(json);
    	
    	JSONArray arr = obj.getJSONArray("results");
    	for (int i = 0; i < arr.length(); i++) {
    		String results = arr.getJSONObject(i).getString(resultQuery);
    		System.out.println(results);
    		resultsQueried = results;
    		upcomingArray.add(resultsQueried);
    		
    	}
    	return upcomingArray;
    }
}
