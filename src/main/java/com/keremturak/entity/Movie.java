package com.keremturak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY)
    private   List<Genre> genres;
    private  String language;
    private  String image;
    private  String name;
    private  String country;
    private  double rating;
    @Column(length = 2048)
    private  String summary;
    private LocalDate premiered;
    private String url;
    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<MovieComment> comments;
}