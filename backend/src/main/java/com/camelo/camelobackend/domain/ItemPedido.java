package com.camelo.camelobackend.domain;

public class ItemPedido {

    private final Long produto;
    private final Integer quantidade;

    public ItemPedido(Long produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Long getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
