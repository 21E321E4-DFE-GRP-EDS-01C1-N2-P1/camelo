package com.camelo.camelobackend.datasources.h2.mapper;

import com.camelo.camelobackend.datasources.h2.model.PedidoModel;
import com.camelo.camelobackend.domain.Pedido;
import org.mapstruct.Mapper;

@Mapper
public interface PedidoModelMapper {

    Pedido map(PedidoModel pedido);

    PedidoModel map(Pedido pedido);
}
