package com.GoToTheMovies.GoToTheMovies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Admin on 8/2/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {


    // instantiate variables
    private String title;

    @JsonProperty("poster_path")
    private String posterPath;
    private String overview;
    private double popularity;





    // constructor
    public Movie() {
    }





    // getters
    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public double getPopularity() {
        return popularity;
    }





    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }
}
