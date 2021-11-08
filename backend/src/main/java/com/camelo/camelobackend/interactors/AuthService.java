package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.domain.exceptions.ObjectNotFoundException;
import com.camelo.camelobackend.ports.UserPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    private final UserPort userPort;
    private final BCryptPasswordEncoder encoder;
    private final NewPasswordUseCase newPasswordUseCase;
    private final EmailService emailService;

    public AuthService(UserPort userPort, BCryptPasswordEncoder encoder, NewPasswordUseCase newPasswordUseCase) {
        this.userPort = userPort;
        this.encoder = encoder;
        this.newPasswordUseCase = newPasswordUseCase;
        this.emailService = new MockEmailService();
    }

    public void sendNewPassword(String email) {
        User usuario = userPort.buscarPor(email);

        if (Objects.isNull(usuario))
            throw new ObjectNotFoundException("Usuário não localizado");

        var novaSenha = newPasswordUseCase.newPassword();
        String novaSenhaEncodada = encoder.encode(novaSenha);
        usuario.atribuirNovaSenha(novaSenhaEncodada);
        emailService.sendNewPasswordEmail(usuario, novaSenha);
        userPort.salvar(usuario);

    }
}
