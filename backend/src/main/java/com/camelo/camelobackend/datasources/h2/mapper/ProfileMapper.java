package com.camelo.camelobackend.datasources.h2.mapper;

import com.camelo.camelobackend.datasources.h2.model.ProfileModel;
import com.camelo.camelobackend.datasources.h2.model.RoleModel;
import com.camelo.camelobackend.domain.Funcao;
import com.camelo.camelobackend.domain.Perfil;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    ProfileModel map(Perfil profile);
    Perfil map(ProfileModel profile);

    RoleModel map(Funcao value);
    Funcao map(RoleModel value);
}
