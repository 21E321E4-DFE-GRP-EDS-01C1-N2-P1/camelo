package com.camelo.camelobackend.domain.objectvalues;

import java.util.Objects;

public enum Situacao {
    EM_PROCESSAMENTO(2, "PROCESSAMENTO"),
    PROCESSADO(3, "PROCESSADO"),
    EM_TRANSPORTE(4, "EM_TRANSPORTE"),
    CANCELADO(5, "CANCELADO");

    private int codigo;
    private String descricao;

    Situacao(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Situacao toEnum(Integer codigo) {
        if (Objects.isNull(codigo)) {
            return Situacao.CANCELADO;
        }

        for (Situacao situacao : Situacao.values()) {
            if (codigo.compareTo(situacao.codigo) == 0) {
                return situacao;
            }
        }
        throw new IllegalArgumentException("SITUACAO INVÁLIDA");
    }
}
