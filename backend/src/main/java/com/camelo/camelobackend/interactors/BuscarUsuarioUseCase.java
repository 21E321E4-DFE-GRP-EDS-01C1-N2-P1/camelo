package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.ports.UserPort;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioUseCase {

    private final UserPort userPort;

    public BuscarUsuarioUseCase(UserPort userPort) {
        this.userPort = userPort;
    }

    public User porId(Long id) {
        return userPort.buscarPor(id);
    }
}
