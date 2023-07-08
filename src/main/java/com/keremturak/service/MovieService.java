package com.keremturak.service;



import com.keremturak.entity.Movie;
import com.keremturak.repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final IMovieRepository movieRepository;

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> findAllByIds(List<Long> ids) {
        return ids.stream().map(x -> movieRepository.findById(x).get()).collect(Collectors.toList());
    }

    public Movie findbyId(long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return movie.get();
        } else {
            throw new RuntimeException("Film bulunamadı");
        }
    }
    public List<Movie> findAllByGenres(String[] genre){
        return movieRepository.findAllByGenres_NameIn(genre);
    }

}