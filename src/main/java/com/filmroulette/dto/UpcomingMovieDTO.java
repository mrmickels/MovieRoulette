package com.filmroulette.dto;

public class UpcomingMovieDTO {
	private int movieId;
	private String title;
	private String releaseDate;
	private String description;
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	@Override
	public String toString() {
		return movieId + " " + title + " " + releaseDate + " " + description + " " + releaseDate;
		
	}

}
