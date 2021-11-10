package com.camelo.camelobackend.datasources.h2.mapper;

import com.camelo.camelobackend.datasources.h2.model.CartaoModel;
import com.camelo.camelobackend.datasources.h2.model.UserModel;
import com.camelo.camelobackend.domain.Cartao;
import com.camelo.camelobackend.domain.User;
import org.mapstruct.Mapper;

@Mapper
public interface CartaoModelMapper {

    CartaoModel map(Cartao cartao);
    Cartao map(CartaoModel cartao);

    UserModel map(User cartao);
    User map(UserModel cartao);
}
