package com.example.tech_support_system.service.mail;

import com.example.tech_support_system.service.MessageSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailMessageSenderServiceImpl implements MessageSenderService {

    private final JavaMailSender javaMailSender;

    @Override
    public boolean sendMessage(String mail) {
        if (mail == null || mail.equals("")) {
            return false;
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail);
        message.setSubject("Добро пожаловать!");
        message.setText("Спасибо за обращение. Вскоре вернемся к Вам с обратной связью.");
        javaMailSender.send(message);
        return true;
    }
}
