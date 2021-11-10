package com.camelo.camelobackend.domain;

public class Cartao {

    private final Long id;
    private final String numero;
    private final String nome;
    private final String vencimento;
    private final Integer cvv;
    private User user;

    public Cartao(Long id, String numero, String nome, String vencimento, Integer cvv) {
        this.id = id;
        this.numero = numero;
        this.nome = nome;
        this.vencimento = vencimento;
        this.cvv = cvv;
    }

    public void adicionar(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getVencimento() {
        return vencimento;
    }

    public Integer getCvv() {
        return cvv;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", nome='" + nome + '\'' +
                ", vencimento='" + vencimento + '\'' +
                ", cvv=" + cvv +
                ", user=" + user +
                '}';
    }
}
