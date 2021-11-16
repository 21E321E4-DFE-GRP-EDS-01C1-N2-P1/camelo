package com.camelo.camelobackend.interactors.builders;

import com.camelo.camelobackend.domain.Mail;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailMessageBuilder {

    private Mail mail;

    public EmailMessageBuilder htmlMailBuilder() {
        mail = new Mail();
        return this;
    }

    public EmailMessageBuilder from(String from) {
        this.mail.setFrom(from);
        return this;
    }

    public EmailMessageBuilder mailTo(String mailTo) {
        this.mail.setMailTo(mailTo);
        return this;
    }

    public EmailMessageBuilder subject(String subject) {
        this.mail.setSubject(subject);
        return this;
    }

    public EmailMessageBuilder props(Map<String, Object> props) {
        this.mail.setProps(props);
        return this;
    }

    public EmailMessageBuilder templatePath(String templatePath) {
        this.mail.setTemplatePath(templatePath);
        return this;
    }

    public Mail build() {
        return mail;
    }
}
