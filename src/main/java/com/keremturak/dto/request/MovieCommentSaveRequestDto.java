package com.keremturak.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieCommentSaveRequestDto {

    private String content;
    private Long userId;
    private Long movieId;
}