package com.camelo.camelobackend.transportlayers.mapper;

import com.camelo.camelobackend.transportlayers.dto.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoResponseMapper {

    ProdutoResponseMapper INSTANCE = Mappers.getMapper(ProdutoResponseMapper.class);

    com.camelo.camelobackend.domain.Produto map(Produto produto);
    Produto map(com.camelo.camelobackend.domain.Produto produto);

}
