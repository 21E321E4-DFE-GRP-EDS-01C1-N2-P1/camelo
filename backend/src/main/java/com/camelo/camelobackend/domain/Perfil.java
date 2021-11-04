package com.camelo.camelobackend.domain;

import java.util.List;

public class Perfil {

    private final Long id;
    private final String name;
    private final String email;
    private final String password;
    private final List<Funcao> roles;

    public Perfil(Long id, String name, String email, String password, List<Funcao> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Funcao> getRoles() {
        return roles;
    }
}
