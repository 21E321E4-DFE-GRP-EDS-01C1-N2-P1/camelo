package com.camelo.camelobackend.datasources.h2.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "CATEGORIA")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String descricao;

    @ManyToMany(mappedBy = "categorias")
    private Set<ProdutoModel> produtoModels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<ProdutoModel> getProdutoModels() {
        return produtoModels;
    }

    public void setProdutoModels(Set<ProdutoModel> produtoModels) {
        this.produtoModels = produtoModels;
    }
}
