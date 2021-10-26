package com.camelo.camelobackend.datasources.h2.mapper;

import com.camelo.camelobackend.datasources.h2.model.CategoriaModel;
import com.camelo.camelobackend.domain.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoriaModelMapper {

    CategoriaModelMapper INSTANCE = Mappers.getMapper(CategoriaModelMapper.class);

    Categoria map(CategoriaModel model);
    CategoriaModel map(Categoria model);
}
