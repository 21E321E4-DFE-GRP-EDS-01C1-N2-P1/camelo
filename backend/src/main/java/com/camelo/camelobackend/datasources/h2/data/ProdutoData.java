package com.camelo.camelobackend.datasources.h2.data;

import com.camelo.camelobackend.datasources.h2.model.ProdutoModel;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoData extends CrudRepository<ProdutoModel, Long> {
}
