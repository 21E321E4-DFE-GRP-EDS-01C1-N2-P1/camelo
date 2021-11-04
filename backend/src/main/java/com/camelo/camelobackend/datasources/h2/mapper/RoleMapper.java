package com.camelo.camelobackend.datasources.h2.mapper;

import com.camelo.camelobackend.datasources.h2.model.RoleModel;
import com.camelo.camelobackend.domain.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleModel map(Role role);
    Role map(RoleModel role);
}
