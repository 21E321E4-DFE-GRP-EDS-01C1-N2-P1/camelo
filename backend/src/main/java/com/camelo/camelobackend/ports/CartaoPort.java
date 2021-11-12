package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.Cartao;

import java.util.List;

public interface CartaoPort {

    Cartao salvar(Cartao cartao);

    List<Cartao> buscarPor(Long id);
}
