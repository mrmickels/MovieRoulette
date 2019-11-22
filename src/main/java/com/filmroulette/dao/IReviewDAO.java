package com.filmroulette.dao;

import com.filmroulette.dto.ReviewDTO;

import java.util.List;

public interface IReviewDAO {
    List<ReviewDTO> fetch(String MovieTitle) throws Exception;

    List<ReviewDTO> fetchFilePath(String filepath) throws Exception;
}
