package com.camelo.camelobackend.datasources.h2;

import com.camelo.camelobackend.datasources.h2.data.ProdutoData;
import com.camelo.camelobackend.datasources.h2.mapper.ProdutoModelMapper;
import com.camelo.camelobackend.datasources.h2.model.ProdutoModel;
import com.camelo.camelobackend.domain.Produto;
import com.camelo.camelobackend.ports.ProdutoPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoRepository implements ProdutoPort {

    private final ProdutoData data;
    private final ProdutoModelMapper mapper;

    public ProdutoRepository(ProdutoData data) {
        this.data = data;
        this.mapper = ProdutoModelMapper.INSTANCE;
    }

    @Override
    public List<Produto> emPromocao() {
        var produtos = (List<ProdutoModel>) data.findAll();

        return produtos.stream().map(mapper::map).collect(Collectors.toList());
    }
}
