package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.Mail;
import com.camelo.camelobackend.domain.Pedido;
import com.camelo.camelobackend.interactors.builders.EmailMessageBuilder;
import com.camelo.camelobackend.ports.UserPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.HashMap;

@Service
public class NotificarSituacaoPedidoUseCase {

    private final Logger logger = LoggerFactory.getLogger(SmtpEmailService.class);

    @Value("${spring.mail.username}")
    private String from;
    private final static String SUBJECT = "PEDIDO ";
    private final static String TEMPLATE_PATH = "email/situacao-pedido.html";
    private final UserPort userPort;
    private final JavaMailSender emailSender;
    private final EmailTextProducerUseCase emailTextProducerUseCase;

    public NotificarSituacaoPedidoUseCase(UserPort userPort, JavaMailSender emailSender, EmailTextProducerUseCase emailTextProducerUseCase) {
        this.userPort = userPort;
        this.emailSender = emailSender;
        this.emailTextProducerUseCase = emailTextProducerUseCase;
    }

    public void executar(Pedido pedido) {
        var mail = getMail(pedido);
        try {
            var hmtl = getHtml(mail);
            assert mail != null;
            mail.setHtml(hmtl);
            emailSender.send(getMimeMessage(mail));
        } catch (Exception e) {
            logger.info("ERRO AO NOTIFICAR SITUACAO DO E-MAIL");
        }
    }

    private String getHtml(Mail mail) throws Exception {
        return emailTextProducerUseCase.executar(mail);
    }

    private Mail getMail(Pedido pedido) {
        var props = new HashMap<String, Object>();
        var usuario = userPort.buscarPor(pedido.getId());

        props.put("situacao", pedido.getSituacao());
        props.put("usuario", usuario.getName());

        return new EmailMessageBuilder()
                .htmlMailBuilder()
                .from(from)
                .templatePath(TEMPLATE_PATH)
                .mailTo(usuario.getEmail())
                .subject(SUBJECT.concat(pedido.getId().toString()))
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
