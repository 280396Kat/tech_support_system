package com.example.tech_support_system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class ApplicationConfig {

    @Value("${spring.mail.username}")
    private String mailUsername;

    @Value("${spring.mail.host}")
    private String mailHost;

    @Value("${spring.mail.port}")
    private Integer mailPort;

    @Value("${spring.mail.password}")
    private String mailPassword;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(mailHost);
        javaMailSender.setPort(mailPort);
        javaMailSender.setUsername(mailUsername);
        javaMailSender.setPassword(mailPassword);
        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", "true"); // для шифрования пароля
        return javaMailSender;
    }

}
