package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.Produto;
import com.camelo.camelobackend.ports.ProdutoPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarProdutosEmPromocaoUseCase {

    private final ProdutoPort produto;

    public BuscarProdutosEmPromocaoUseCase(ProdutoPort port) {
        this.produto = port;
    }

    public List<Produto> executar() {
        return produto.emPromocao();
    }
}
