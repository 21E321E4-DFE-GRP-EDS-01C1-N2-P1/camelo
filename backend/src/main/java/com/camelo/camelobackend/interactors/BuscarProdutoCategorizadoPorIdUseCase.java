package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.ports.ProdutoPort;
import com.camelo.camelobackend.transportlayers.mapper.ProdutoCategorizadoMapper;
import com.camelo.camelobackend.transportlayers.openapi.model.ProdutoCategorizado;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BuscarProdutoCategorizadoPorIdUseCase {

    private final ProdutoPort port;
    private final ProdutoCategorizadoMapper mapper;

    public BuscarProdutoCategorizadoPorIdUseCase(ProdutoPort port) {
        this.port = port;
        this.mapper = Mappers.getMapper(ProdutoCategorizadoMapper.class);
    }

    public ProdutoCategorizado executar(BigDecimal id) {
        var produto = port.obterPor(id.longValue());
        return mapper.map(produto);
    }
}
