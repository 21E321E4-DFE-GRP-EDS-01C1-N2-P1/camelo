package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.Mail;
import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.domain.exceptions.ObjectNotFoundException;
import com.camelo.camelobackend.ports.UserPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class AuthService {

    @Value("${spring.mail.username}")
    private String from;
    private final UserPort userPort;
    private final BCryptPasswordEncoder encoder;
    private final NewPasswordUseCase newPasswordUseCase;
    private final SmtpEmailService smtpEmailService;

    public AuthService(UserPort userPort, BCryptPasswordEncoder encoder, NewPasswordUseCase newPasswordUseCase, SmtpEmailService smtpEmailService) {
        this.userPort = userPort;
        this.encoder = encoder;
        this.newPasswordUseCase = newPasswordUseCase;
        this.smtpEmailService = smtpEmailService;
    }

    public void sendNewPassword(String email) {
        User usuario = userPort.buscarPor(email);

        if (Objects.isNull(usuario))
            throw new ObjectNotFoundException("Usuário não localizado");

        var novaSenha = newPasswordUseCase.newPassword();
        String novaSenhaEncodada = encoder.encode(novaSenha);
        usuario.atribuirNovaSenha(novaSenhaEncodada);

        try {
            smtpEmailService.sendEmail(novaSenha, usuario);
            userPort.salvar(usuario);

        } catch (Exception e) {
            throw new RuntimeException("ERRO AO ENVIAR E-MAIL PARA O USUARIO");

        }
    }

}
