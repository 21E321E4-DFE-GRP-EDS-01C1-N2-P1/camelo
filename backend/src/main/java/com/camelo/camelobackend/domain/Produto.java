package com.camelo.camelobackend.domain;

import java.math.BigDecimal;
import java.util.Set;

public class Produto {

    private final Long id;
    private final String nome;
    private final String url;
    private final BigDecimal preco;
    private final Long desconto;
    private final Set<Categoria> categorias;

    public Produto(Long id, String nome, String url, BigDecimal preco, Long desconto, Set<Categoria> categorias) {
        this.id = id;
        this.nome = nome;
        this.url = url;
        this.preco = preco;
        this.desconto = desconto;
        this.categorias = categorias;
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

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", url='" + url + '\'' +
                ", preco=" + preco +
                ", desconto=" + desconto +
                ", categorias=" + categorias +
                '}';
    }
}
