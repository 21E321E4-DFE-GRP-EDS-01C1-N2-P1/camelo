package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.User;

public interface UserPort {
    User buscarPor(String email);
    User buscarPor(Long id);

    User criar(User user);
}
