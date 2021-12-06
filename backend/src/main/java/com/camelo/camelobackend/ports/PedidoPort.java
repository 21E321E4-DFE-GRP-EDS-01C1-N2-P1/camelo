package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.Pedido;

import java.util.List;

public interface PedidoPort {

    Pedido salvar(Pedido pedido);
    List<Pedido> pesquisarPedidos(String situacao);
}
