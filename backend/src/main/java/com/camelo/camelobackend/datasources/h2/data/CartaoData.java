package com.camelo.camelobackend.datasources.h2.data;

import com.camelo.camelobackend.datasources.h2.model.CartaoModel;
import com.camelo.camelobackend.datasources.h2.model.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartaoData extends CrudRepository<CartaoModel, Long> {

    List<CartaoModel> findCartaoModelByUser(UserModel userModel);
}
