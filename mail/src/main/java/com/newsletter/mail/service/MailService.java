package com.newsletter.mail.service;

import com.newsletter.mail.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {


    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    FetchService fetchService;

    @Scheduled(cron = "0 0 12 * * ?")  //Scheduled topic like yoga,fitness
    public void Fitness ( ) {
        List<User> users = fetchService.fetchUsers("fitness");
        String content = fetchService.fetchContent("fitness");
        if (content != null && users != null)
            users.forEach((user) -> {
                sendEmail(user.getEmail(), content);
            });
    }

    public void sendEmail (String email, String content) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);

        msg.setSubject("Tips from Curelink");
        msg.setText(content);

        javaMailSender.send(msg);
    }
}
