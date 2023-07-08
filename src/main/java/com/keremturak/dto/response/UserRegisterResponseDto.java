package com.keremturak.dto.response;

import com.keremturak.entity.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserRegisterResponseDto {
    private  Long id;
    private  String name;
    private  String surname;
    private  String email;
    private UserType userType;
}
