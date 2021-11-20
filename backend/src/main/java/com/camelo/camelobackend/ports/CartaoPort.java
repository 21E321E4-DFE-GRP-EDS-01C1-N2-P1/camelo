package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CartaoPort {

    Cartao salvar(Cartao cartao);

    List<Cartao> buscarPor(Long id);

    Page<Cartao> findAll(PageRequest pageRequest);
}
