package com.camelo.camelobackend.domain;

public class Role {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
