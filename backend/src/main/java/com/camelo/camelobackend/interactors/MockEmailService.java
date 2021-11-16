package com.camelo.camelobackend.interactors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MockEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

    public void sendEmail(SimpleMailMessage msg) {
        LOG.info("Simulando envio de Email...");
        LOG.info(msg.toString());
        LOG.info("Email enviado");
    }

    public void sendEmailHtml(MimeMessage msg) {
        LOG.info("Simulando envio de Email HTML ...");
        LOG.info(msg.toString());
        LOG.info("Email enviado");
    }
}
