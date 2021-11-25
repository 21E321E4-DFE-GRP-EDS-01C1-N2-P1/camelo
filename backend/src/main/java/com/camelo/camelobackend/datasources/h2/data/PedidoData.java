package com.camelo.camelobackend.datasources.h2.data;

import com.camelo.camelobackend.datasources.h2.model.PedidoModel;
import org.springframework.data.repository.CrudRepository;

public interface PedidoData extends CrudRepository<PedidoModel, Long> {
}
