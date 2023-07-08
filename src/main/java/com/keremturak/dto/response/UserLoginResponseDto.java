package com.keremturak.dto.response;


import com.keremturak.entity.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserLoginResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private UserType userType;
}