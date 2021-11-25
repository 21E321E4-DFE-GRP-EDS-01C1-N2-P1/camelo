package com.camelo.camelobackend.transportlayers.dto;

import java.util.List;

public class Carrinho {

    private List<Selecao> produtos;
    private Pagamento pagamento;

    public List<Selecao> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Selecao> produtos) {
        this.produtos = produtos;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
