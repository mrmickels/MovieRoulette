package com.filmroulette.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpcomingMovieDTO {
	@SerializedName("id")
	@Expose
	private int movieId;
	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("released")
	@Expose
	private String releaseDate;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("posterPath")
	@Expose
	private String posterPath;

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

	public String getPosterPath() { return posterPath; }

	public void setPosterPath(String posterPath) { this.posterPath = posterPath; }
	
	@Override
	public String toString() {
		return movieId + " " + title + " " + releaseDate + " " + description + " " + releaseDate;
		
	}

}
