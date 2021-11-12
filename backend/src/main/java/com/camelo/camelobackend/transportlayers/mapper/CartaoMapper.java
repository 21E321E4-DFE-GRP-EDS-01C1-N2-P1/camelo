package com.camelo.camelobackend.transportlayers.mapper;

import com.camelo.camelobackend.transportlayers.openapi.model.Cartao;
import org.mapstruct.Mapper;

@Mapper
public interface CartaoMapper {

     com.camelo.camelobackend.domain.Cartao map(Cartao cartao);
     Cartao map(com.camelo.camelobackend.domain.Cartao cartao);

}
