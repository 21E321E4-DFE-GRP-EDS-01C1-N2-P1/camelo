package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.Produto;

import java.util.List;

public interface ProdutoPort {

    List<Produto> emPromocao();
}
