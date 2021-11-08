package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.User;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendEmail(SimpleMailMessage msg);
    void sendNewPasswordEmail(User user, String newPass);
}
