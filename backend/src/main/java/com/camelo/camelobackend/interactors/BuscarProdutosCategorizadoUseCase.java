package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.ports.ProdutoPort;
import com.camelo.camelobackend.transportlayers.mapper.ProdutoCategorizadoMapper;
import com.camelo.camelobackend.transportlayers.openapi.model.ProdutoCategorizado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscarProdutosCategorizadoUseCase {

    private final ProdutoPort port;
    private final ProdutoCategorizadoMapper mapper;

    public BuscarProdutosCategorizadoUseCase(ProdutoPort port) {
        this.port = port;
        this.mapper = ProdutoCategorizadoMapper.INSTANCE;
    }

    public List<ProdutoCategorizado> executar() {
        var produtos = port.produtos();

        return produtos.stream().map(mapper::map).collect(Collectors.toList());
    }
}
