package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.User;

public interface RolePort {

    User buscarPor(String email);
}
