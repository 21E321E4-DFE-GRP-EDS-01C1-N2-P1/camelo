package com.camelo.camelobackend.datasources.h2.data;

import com.camelo.camelobackend.datasources.h2.model.ProdutoModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoData extends CrudRepository<ProdutoModel, Long> {
    List<ProdutoModel> findByDescontoNotNull();
}
