package br.com.fernandoschimidt.filmeservice.repository;

import br.com.fernandoschimidt.filmeservice.domain.Movie;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    private final Map<Long, Movie> movies = new HashMap<>();

    public Movie save(Movie movie) {
        movies.put(movie.id(), movie);
        return movie;
    }

    public Movie findById(Long id) {
        return movies.computeIfAbsent(id, key -> {
            throw new RuntimeException("Movie not found, id= " + id);
        });
    }

    public List<Movie> findAll() {
        return List.copyOf(movies.values());
    }

    public List<Movie> findByStreamId(Long streamId) {
        return movies.values().stream().filter(m ->
                m.streamId().equals(streamId)).toList();
    }
}
