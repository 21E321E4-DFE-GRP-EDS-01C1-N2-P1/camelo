package com.camelo.camelobackend.domain;

import java.math.BigDecimal;

public class Produto {
    private final Long id;
    private final String nome;
    private final String url;
    private final BigDecimal preco;
    private final Long desconto;

    public Produto(Long id, String nome, String url, BigDecimal preco, Long desconto) {
        this.id = id;
        this.nome = nome;
        this.url = url;
        this.preco = preco;
        this.desconto = desconto;
    }

    public String getNome() {
        return nome;
    }

    public String getUrl() {
        return url;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Long getDesconto() {
        return desconto;
    }

    public Long getId() {
        return id;
    }
}
