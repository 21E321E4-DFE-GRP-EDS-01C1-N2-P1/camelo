package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.Produto;
import com.camelo.camelobackend.ports.ProdutoPort;
import org.springframework.stereotype.Service;

@Service
public class CadastrarProdutoUseCase {

    private final ProdutoPort port;

    public CadastrarProdutoUseCase(ProdutoPort port) {
        this.port = port;
    }

    public Produto executar(Produto produto) {
        return port.cadastra(produto);
    }
}
