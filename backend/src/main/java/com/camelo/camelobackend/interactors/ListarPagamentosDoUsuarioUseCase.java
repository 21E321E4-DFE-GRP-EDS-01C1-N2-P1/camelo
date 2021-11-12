package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.ports.UserPort;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class ListarPagamentosDoUsuarioUseCase {

    private final UserPort userPort;

    public ListarPagamentosDoUsuarioUseCase(UserPort userPort) {
        this.userPort = userPort;
    }

    public void executar() {

        var userSS = UserService.authenticated();

        if (nonNull(userSS)) {
            var user = userPort.buscarPor(userSS.getUsername());

            System.out.println(user);
        }
    }
}
