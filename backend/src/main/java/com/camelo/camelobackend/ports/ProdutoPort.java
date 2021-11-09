package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.Produto;

import java.util.List;

public interface ProdutoPort {

    Produto cadastra(Produto produto);
    List<Produto> emPromocao();
    List<Produto> produtos();
    Produto obterPor(Long id);
}
