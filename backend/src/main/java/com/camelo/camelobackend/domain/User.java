package com.camelo.camelobackend.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String endereco;
    private String cep;
    private String bairro;
    private String cidade;
    private Set<Role> roles;
    private List<Cartao> cartoes;


    public User(Long id, String name, String email, String password, String endereco, String cep, String bairro, String cidade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.endereco = endereco;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
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
        if (Objects.isNull(cartoes))
            cartoes = new ArrayList<>();

        this.cartoes.add(cartao);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(List<Cartao> cartoes) {
        this.cartoes = cartoes;
    }
}
