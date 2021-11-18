package com.camelo.camelobackend.transportlayers.mapper;

import com.camelo.camelobackend.transportlayers.openapi.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaReponseMapper {
    CategoriaReponseMapper INSTANCE = Mappers.getMapper(CategoriaReponseMapper.class);

    Categoria map(com.camelo.camelobackend.domain.Categoria categoria);
}
