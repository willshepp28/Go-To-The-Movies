package com.GoToTheMovies.GoToTheMovies;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Admin on 8/2/17.
 */


@Controller
public class MovieController {


    String API_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=be2a38521a7859c95e2d73c48786e4bb";

    @RequestMapping("/")
    public String home() {
        return "home";
    }


    @RequestMapping("/now-playing")
    public String nowPlaying(Model model){

        ResultsPage allresults = new ResultsPage();

        // Change your /now-playing endpoint to call the method and add the resulting list of movies to the Model
         List movies = getMovies(API_URL);
        model.addAttribute("movies", movies);


        return "now-playing";
    }


    @RequestMapping("/medium-popular-long-name")
    public String mediumPopular(Model model){

        List<Movie> movies = getMovies(API_URL);

        List<Movie> filterMovies = movies.stream()
                .filter(e -> e.getPopularity() > 30 && e.getPopularity() <= 80)
                .filter(e -> e.getTitle().length() > 10)
                .collect(Collectors.toList());

        model.addAttribute("movies", filterMovies);

        return "medium-popular-long-name";
    }


  // Write a public static List<Movie> getMovies(String route) method in your controller.
    public static List<Movie> getMovies(String route){
        // Create new ArrayList.


        RestTemplate restTemplate = new RestTemplate();
        ResultsPage newresults = restTemplate.getForObject(route, ResultsPage.class);

        return newresults.results;

    }


}
