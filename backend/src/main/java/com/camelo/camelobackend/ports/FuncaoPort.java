package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.Role;

public interface FuncaoPort {

    Role buscarPor(String name);
}
