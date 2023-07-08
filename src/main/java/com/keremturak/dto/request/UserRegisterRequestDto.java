package com.keremturak.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRegisterRequestDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String rePassword;
}