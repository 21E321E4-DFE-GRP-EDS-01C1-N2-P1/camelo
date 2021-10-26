package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.Produto;
import com.camelo.camelobackend.ports.ProdutoPort;
import org.springframework.stereotype.Service;

@Service
public class BuscarProdutoPorIdUseCase {

    private final ProdutoPort port;

    public BuscarProdutoPorIdUseCase(ProdutoPort port) {
        this.port = port;
    }

    public Produto executar(Long id) {
        return port.obterPor(id);
    }
}
