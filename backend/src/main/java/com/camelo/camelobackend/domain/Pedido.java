package com.camelo.camelobackend.domain;

import com.camelo.camelobackend.domain.objectvalues.Situacao;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Pedido {

    private Long id;
    private List<ItemPedido> itens;
    private Long usuario;
    @JsonIgnore
    private  String nrCartao;
    private String situacao;

    public Pedido() {
        this.situacao = Situacao.EM_PROCESSAMENTO.getDescricao();
    }

    public Pedido(List<ItemPedido> itens, Long usuario, String nrCartao) {
        this.itens = itens;
        this.usuario = usuario;
        this.nrCartao = nrCartao;
        this.situacao = Situacao.EM_PROCESSAMENTO.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public String getNrCartao() {
        return nrCartao;
    }

    public void setNrCartao(String nrCartao) {
        this.nrCartao = nrCartao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
