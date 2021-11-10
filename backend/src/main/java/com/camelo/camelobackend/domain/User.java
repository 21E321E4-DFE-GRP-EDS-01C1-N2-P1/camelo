package com.camelo.camelobackend.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    private final Long id;
    private final String name;
    private final String email;
    private String password;
    private final Set<Role> roles;
    private List<Cartao> cartoes;

    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = new HashSet<>();
        this.cartoes = new ArrayList<>();
    }

    public void encriptarSenha(String senhaEncriptada) {
        this.password = senhaEncriptada;
    }

    public void atribuirNovaSenha(String novaSenha) {
        this.password = novaSenha;
    }

    public void adicionarCartao(Cartao cartao) {
        this.cartoes.add(cartao);
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

    public List<Cartao> getCartoes() {
        return cartoes;
    }
}
