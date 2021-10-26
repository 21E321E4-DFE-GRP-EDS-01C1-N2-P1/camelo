package com.camelo.camelobackend.datasources.h2.data;

import com.camelo.camelobackend.datasources.h2.model.CategoriaModel;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaData extends CrudRepository<CategoriaModel, Long> {
}
