package com.camelo.camelobackend.ports;

import com.camelo.camelobackend.domain.Profile;

public interface ProfilePort {

    Profile buscarPor(String email);
}
