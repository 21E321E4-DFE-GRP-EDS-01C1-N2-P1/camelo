package com.camelo.camelobackend.transportlayers.mapper;

import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.transportlayers.dto.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserResponseDTOMapper {

    UserResponseDTOMapper INSTANCE = Mappers.getMapper(UserResponseDTOMapper.class);

    UserResponseDTO map(User user);
}
