package com.camelo.camelobackend.transportlayers.mapper;

import com.camelo.camelobackend.domain.Categoria;
import com.camelo.camelobackend.domain.Produto;
import com.camelo.camelobackend.transportlayers.openapi.model.ProdutoCategorizado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoCategorizadoMapper {

    ProdutoCategorizadoMapper INSTANCE = Mappers.getMapper(ProdutoCategorizadoMapper.class);

    ProdutoCategorizado map(Produto produto);

}
