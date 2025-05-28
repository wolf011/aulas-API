package org.serratec.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

    @Autowired
    private JavaMailSender mailSender;

    public void enviar(String para, String assunto, String texto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hhuggo277@gmail.com");
        message.setTo(para);
        message.setText("Confirmação de Cadastro \n" + texto + "\n\n\n" + "Serratec - 2025");
        mailSender.send(message);

    }

}
