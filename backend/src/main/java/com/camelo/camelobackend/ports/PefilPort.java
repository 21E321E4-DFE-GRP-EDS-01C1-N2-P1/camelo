package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.Perfil;

public interface PefilPort {

    Perfil buscarPor(String email);
}
