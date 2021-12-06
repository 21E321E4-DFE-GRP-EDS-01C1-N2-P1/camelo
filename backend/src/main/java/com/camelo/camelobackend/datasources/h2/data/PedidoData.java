package com.camelo.camelobackend.datasources.h2.data;

import com.camelo.camelobackend.datasources.h2.model.PedidoModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoData extends CrudRepository<PedidoModel, Long> {

    List<PedidoModel> findAllBySituacao(String situacao);
}
