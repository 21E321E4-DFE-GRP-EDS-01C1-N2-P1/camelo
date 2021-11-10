package com.camelo.camelobackend.datasources;

import com.camelo.camelobackend.datasources.h2.data.CartaoData;
import com.camelo.camelobackend.datasources.h2.mapper.CartaoModelMapper;
import com.camelo.camelobackend.domain.Cartao;
import com.camelo.camelobackend.ports.CartaoPort;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

@Repository
public class CartaoRepository implements CartaoPort {

    private final CartaoData data;

    public CartaoRepository(CartaoData data) {
        this.data = data;
    }

    @Override
    public Cartao salvar(Cartao cartao) {
        var mapper = Mappers.getMapper(CartaoModelMapper.class);
        var cartaoModel = mapper.map(cartao);
        var cartaoSalvo = data.save(cartaoModel);
        return mapper.map(cartaoSalvo);
    }
}
