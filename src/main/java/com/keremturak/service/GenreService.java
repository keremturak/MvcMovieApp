package com.keremturak.service;

import com.keremturak.entity.Genre;
import com.keremturak.repository.IGenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final IGenreRepository genreRepository;

    public List<Genre> createGenresWithNames(List<String> genres) {
        List<Genre> genresList=new ArrayList<>();
        for (String name:genres){
            Optional<Genre> genre=genreRepository.findOptionalByName(name);
            if(genre.isPresent()){
                genresList.add(genre.get());
            }else{
                Genre genre1= Genre.builder().name(name).build();
                genreRepository.save(genre1);
                genresList.add(genre1);
            }
        }
        return  genresList;
    }

    public List<Genre> findAll() {
        return genreRepository.findAll();
    }
}