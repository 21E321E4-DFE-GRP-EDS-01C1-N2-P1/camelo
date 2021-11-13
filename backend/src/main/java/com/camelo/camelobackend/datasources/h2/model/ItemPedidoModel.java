package com.camelo.camelobackend.datasources.h2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ItemPedidoModel {

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id;

    private Double desconto;

    private Integer quantidade;

    private Double preco;

}
