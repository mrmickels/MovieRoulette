package com.filmroulette.dao;

import com.filmroulette.dto.ReviewDTO;
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
public class ReviewDAO implements IReviewDAO {
    @Autowired
    private NetworkDAO networkDAO;

    @Override
    public List<ReviewDTO> fetch(String MovieTitle) throws Exception{
        List<ReviewDTO> review = new ArrayList<>();
        String rawJson = networkDAO.request("https://api.nytimes.com/svc/movies/v2/reviews/search.json?query=" + MovieTitle + "&api-key=9m1sNAVBZ46aeDV2WpNwp1t50zHSg2K1");
        return getReviewDTO(review, rawJson);
    }

    @Override
    public List<ReviewDTO> fetchFilePath(String filepath) throws Exception{
        List<ReviewDTO> review = new ArrayList<>();

        String rawJson = "";
        try{
            rawJson = new String ( Files.readAllBytes( Paths.get(filepath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return getReviewDTO(review, rawJson);

    }

    private List<ReviewDTO> getReviewDTO(List<ReviewDTO> review, String rawJson) {
        JSONObject obj = new JSONObject(rawJson);
        JSONArray movieReviews = obj.getJSONArray("results");

        for (int i = 0; i < movieReviews.length(); i++) {

            JSONObject jsonReview = movieReviews.getJSONObject(i);
            ReviewDTO reviewDTO = new ReviewDTO();

            String displayTitle = jsonReview.getString("display_title");
            String mpaaRating = jsonReview.getString("mpaa_rating");
            String byline = jsonReview.getString("byline");
            String summaryShort = jsonReview.getString("summary_short");

            reviewDTO.setDisplayTitle(displayTitle);
            reviewDTO.setMpaaRating(mpaaRating);
            reviewDTO.setByline(byline);
            reviewDTO.setSummaryShort(summaryShort);

            review.add(reviewDTO);

        }
        return review;
    }
}
