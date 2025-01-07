package br.com.fernandoschimidt.filmeservice.controller;

import br.com.fernandoschimidt.filmeservice.domain.Movie;
import br.com.fernandoschimidt.filmeservice.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@Slf4j
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> findAll() {
        //log.info("findAll");
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable Long id) {
        //log.info("findById");
        return movieRepository.findById(id);
    }

    @GetMapping("/stream/{steamId}")
    public List<Movie> findByStreamId(@PathVariable Long streamId) {
        //log.info("findByStreamId");
        return movieRepository.findByStreamId(streamId);
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        //log.info("save");
        movieRepository.save(movie);
        return movie;
    }
}
