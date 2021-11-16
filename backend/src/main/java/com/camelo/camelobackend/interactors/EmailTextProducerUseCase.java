package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.Mail;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailTextProducerUseCase {

    private final TemplateEngine template;

    public EmailTextProducerUseCase(TemplateEngine template) {
        this.template = template;
    }

    public String executar(Mail mail) throws Exception {
        Context context = new Context();
        context.setVariables(mail.getProps());
        return template.process(mail.getTemplatePath(), context);
    }
}
