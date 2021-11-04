package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.Funcao;

public interface FuncaoPort {

    Funcao buscarPor(String name);
}
