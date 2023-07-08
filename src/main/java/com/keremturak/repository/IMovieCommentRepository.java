package com.keremturak.repository;

import com.keremturak.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMovieCommentRepository extends JpaRepository<MovieComment,Long> {



}
