package com.camelo.camelobackend.datasources.h2.data;

import com.camelo.camelobackend.datasources.h2.model.CartaoModel;
import org.springframework.data.repository.CrudRepository;

public interface CartaoData extends CrudRepository<CartaoModel, Long> {
}
