package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.Mail;
import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.interactors.builders.EmailMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

@Component
public class SmtpEmailService {

    private final Logger logger = LoggerFactory.getLogger(SmtpEmailService.class);

    @Value("${spring.mail.username}")
    private String from;
    private final static String SUBJECT = "RECUPERAÇÃO DE SENHA";
    private final static String TEMPLATE_PATH = "email/recuperacao-de-senha";

    private final JavaMailSender emailSender;
    private final EmailTextProducerUseCase emailTextProducerUseCase;

    public SmtpEmailService(JavaMailSender emailSender, EmailTextProducerUseCase emailTextProducerUseCase) {
        this.emailSender = emailSender;
        this.emailTextProducerUseCase = emailTextProducerUseCase;
    }

    public void sendEmail(String senha, User user) throws Exception {
        var mail = getMail(senha, user);
        var html = getHtml(mail);
        mail.setHtml(html);

        var mimeMessage = getMimeMessage(mail);
        emailSender.send(mimeMessage);
    }

    private String getHtml(Mail mail) throws Exception {
        return emailTextProducerUseCase.executar(mail);
    }

    private Mail getMail(String senha, User user) {
        var props = new HashMap<String, Object>();
        props.put("senha", senha);
        props.put("usuario", user.getName());

        return new EmailMessageBuilder()
                .htmlMailBuilder()
                .from(from)
                .templatePath(TEMPLATE_PATH)
                .mailTo(user.getEmail())
                .subject(SUBJECT)
                .props(props)
                .build();
    }

    private MimeMessage getMimeMessage(Mail mail) throws MessagingException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
        mmh.setTo(mail.getMailTo());
        mmh.setFrom(mail.getFrom());
        mmh.setSubject(mail.getSubject());
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(mail.getHtml(), true);
        return mimeMessage;
    }
}