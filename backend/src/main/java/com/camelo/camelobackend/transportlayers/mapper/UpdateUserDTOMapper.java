package com.camelo.camelobackend.transportlayers.mapper;

import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.transportlayers.dto.EditUserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UpdateUserDTOMapper {

    User map(EditUserDTO mapper);
}
