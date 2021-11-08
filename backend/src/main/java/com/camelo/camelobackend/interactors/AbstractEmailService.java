package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendNewPasswordEmail(User user, String newPass) {
        SimpleMailMessage smm = prepareNewPasswordEmail(user, newPass);
        sendEmail(smm);
    }

    private SimpleMailMessage prepareNewPasswordEmail(User user, String newPass) {
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(user.getEmail());
        smm.setFrom(sender);
        smm.setSubject("Solicitação de nova senha");
        smm.setSentDate(new Date(System.currentTimeMillis()));
        smm.setText("Nova senha: " + newPass);
        return smm;
    }

}
