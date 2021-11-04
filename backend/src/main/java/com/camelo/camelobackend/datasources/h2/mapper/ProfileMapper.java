package com.camelo.camelobackend.datasources.h2.mapper;

import com.camelo.camelobackend.datasources.h2.model.ProfileModel;
import com.camelo.camelobackend.datasources.h2.model.RoleModel;
import com.camelo.camelobackend.domain.Profile;
import com.camelo.camelobackend.domain.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    ProfileModel map(Profile profile);
    Profile map(ProfileModel profile);

    RoleModel map(Role value);
    Role map(RoleModel value);
}
