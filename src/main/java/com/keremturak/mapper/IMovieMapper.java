package com.keremturak.mapper;


import com.keremturak.dto.response.MovieAdminPageResponseDto;
import com.keremturak.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMovieMapper {

    IMovieMapper INSTANCE = Mappers.getMapper(IMovieMapper.class);

    List<MovieAdminPageResponseDto> toMovieAdminPageResponseDto(List<Movie> movies);
}