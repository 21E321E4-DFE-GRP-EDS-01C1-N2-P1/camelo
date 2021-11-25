package com.camelo.camelobackend.datasources.h2.model;

import javax.persistence.*;

@Entity(name = "ITEM_PEDIDO")
public class ItemPedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long produto;
    private Integer quantidade;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoModel pedidoModel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public PedidoModel getPedidoModel() {
        return pedidoModel;
    }

    public void setPedidoModel(PedidoModel pedidoModel) {
        this.pedidoModel = pedidoModel;
    }
}
