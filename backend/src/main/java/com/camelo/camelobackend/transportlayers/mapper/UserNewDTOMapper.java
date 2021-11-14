package com.camelo.camelobackend.transportlayers.mapper;

import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.transportlayers.dto.EditUserDTO;
import com.camelo.camelobackend.transportlayers.dto.UserNewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserNewDTOMapper {

    UserNewDTOMapper INSTANCE = Mappers.getMapper(UserNewDTOMapper.class);

    User map(UserNewDTO userNewDTO);
}
