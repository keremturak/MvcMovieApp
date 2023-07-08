package com.keremturak.mapper;


import com.keremturak.dto.request.UserRegisterRequestDto;
import com.keremturak.dto.response.UserLoginResponseDto;
import com.keremturak.dto.response.UserRegisterResponseDto;
import com.keremturak.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE= Mappers.getMapper(IUserMapper.class);
    User toUser(UserRegisterRequestDto dto);

    UserRegisterResponseDto toRegisterResponseDto(final User user);

    UserLoginResponseDto toLoginResponseDto(User user);
}