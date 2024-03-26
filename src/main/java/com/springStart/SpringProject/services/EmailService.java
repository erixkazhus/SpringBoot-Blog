package com.springStart.SpringProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.springStart.SpringProject.util.email.EmailDetails;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.beans.factory.annotation.Value;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public Boolean sendSimpleEmail(EmailDetails emailDetails) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setText(emailDetails.getMsgBody());
            mailMessage.setSubject(emailDetails.getSubject());

            javaMailSender.send(mailMessage);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

}