package com.camelo.camelobackend.domain;

import java.util.HashSet;
import java.util.Set;

public class User {

    private final Long id;
    private final String name;
    private final String email;
    private String password;
    private final Set<Role> roles;

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = new HashSet<>();
    }

    public void encriptarSenha(String senhaEncriptada) {
        this.password = senhaEncriptada;
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

    public Set<Role> getRoles() {
        return roles;
    }
}
