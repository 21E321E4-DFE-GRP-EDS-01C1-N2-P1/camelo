package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.Pedido;

public interface PedidoPort {

    Pedido salvar(Pedido pedido);
}
