package com.camelo.camelobackend.datasources.h2.data;

import com.camelo.camelobackend.datasources.h2.model.ItemPedidoModel;
import org.springframework.data.repository.CrudRepository;

public interface ItemPedidoData extends CrudRepository<ItemPedidoModel, Long> {
}