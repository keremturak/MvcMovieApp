package com.keremturak.repository;

import com.keremturak.entity.Genre;
import com.keremturak.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findAllByGenres_NameIn(String[] genre);

}
