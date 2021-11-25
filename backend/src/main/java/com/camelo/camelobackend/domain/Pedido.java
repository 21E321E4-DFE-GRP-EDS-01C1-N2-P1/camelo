package com.camelo.camelobackend.domain;

import java.util.List;

public class Pedido {

    private Long id;
    private final List<ItemPedido> itens;
    private final Long usuario;
    private final String nrCartao;


    public Pedido(List<ItemPedido> itens, Long usuario, String nrCartao) {
        this.itens = itens;
        this.usuario = usuario;
        this.nrCartao = nrCartao;
    }

    public Long getId() {
        return id;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public Long getUsuario() {
        return usuario;
    }

    public String getNrCartao() {
        return nrCartao;
    }
}
