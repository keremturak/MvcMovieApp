package com.keremturak.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieAdminPageResponseDto {

    private Long id;
    private String language;
    private String name;
    private LocalDate premiered;
}