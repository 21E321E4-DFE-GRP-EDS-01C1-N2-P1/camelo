package com.camelo.camelobackend.datasources.h2.mapper;

import com.camelo.camelobackend.datasources.h2.model.ProdutoModel;
import com.camelo.camelobackend.domain.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoModelMapper {

    ProdutoModelMapper INSTANCE = Mappers.getMapper(ProdutoModelMapper.class);

    ProdutoModel map(Produto produto);
    Produto map(ProdutoModel model);
}
