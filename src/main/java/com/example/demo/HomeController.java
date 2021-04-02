package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    DirectorRepository directorRepository;

    @RequestMapping("/")
    public String index(Model model){
        Director director = new Director();
        director.setName("AAshish paudel");
        director.setGenre("Pizza");

        Movie movie = new Movie();
        movie.setTitle("star Title");
        movie.setYear(2020);
        movie.setDescription("about stars in the sky");

        Set<Movie> movies = new HashSet<>();
        movies.add(movie);

        movie = new Movie();
        movie.setTitle("Ancient fight");
        movie.setYear(2021);
        movie.setDescription("about fight in history");
        movies.add(movie);

        director.setMovies(movies);
        directorRepository.save(director);
        model.addAttribute("directors",directorRepository.findAll());
        return "index";

    }

}
