package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.Role;
import com.camelo.camelobackend.domain.RoleType;
import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.ports.UserPort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CadastrarUsuarioUseCase {

    private final UserPort userPort;
    private final BCryptPasswordEncoder enconder;

    public CadastrarUsuarioUseCase(UserPort userPort, BCryptPasswordEncoder enconder) {
        this.userPort = userPort;
        this.enconder = enconder;
    }

    public User executar(User user) {
        addRole(RoleType.CLIENTE, user);
        codificarSenha(user);

        return userPort.salvar(user);
    }

    private void addRole(RoleType role, User user) {
        user.getRoles().add(new Role(role.getCodigo(), role.getName()));
    }

    private void codificarSenha(User user) {
        var novaSenha = enconder.encode(user.getPassword());
        user.encriptarSenha(novaSenha);
    }
}
