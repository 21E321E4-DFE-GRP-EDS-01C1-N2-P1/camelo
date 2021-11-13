package com.camelo.camelobackend.datasources.h2.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoPK {

    @ManyToOne
    @JoinColumn(name="pedido_id")
    private PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name="produto_id")
    private ProdutoModel produtoModel;
}
