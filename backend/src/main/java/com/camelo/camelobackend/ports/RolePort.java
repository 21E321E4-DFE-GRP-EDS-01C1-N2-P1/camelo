package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.Role;

public interface RolePort {

    Role buscarPor(String name);
}
