package com.camelo.camelobackend.datasources;

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
    public Produto cadastra(Produto produto) {
        var produtoModel = mapper.map(produto);
        return mapper.map(data.save(produtoModel));
    }

    @Override
    public List<Produto> emPromocao() {
        var produtos = data.findByDescontoNotNull();

        return produtos.stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public List<Produto> produtos() {
        var produtosModel = (List<ProdutoModel>) data.findAll();
        return produtosModel.stream().map(mapper::map).collect(Collectors.toList());
    }

    @Override
    public Produto obterPor(Long id) {
        var produtoLocalizado = data.findById(id).orElseThrow();
        return mapper.map(produtoLocalizado);
    }
}
