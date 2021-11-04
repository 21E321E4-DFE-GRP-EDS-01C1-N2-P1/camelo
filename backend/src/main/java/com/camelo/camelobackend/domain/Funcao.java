package com.camelo.camelobackend.domain;

public class Funcao {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Funcao(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
