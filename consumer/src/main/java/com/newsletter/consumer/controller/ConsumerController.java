package com.newsletter.consumer.controller;

import com.newsletter.consumer.model.Content;
import com.newsletter.consumer.model.User;
import com.newsletter.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/v3/api")
public class ConsumerController {

    @Autowired
    @Lazy
    private ConsumerService consumerService;

    @PostMapping(value = "/consume/register")
    public ResponseEntity<User> consumerHandler (@RequestBody User user) {
        return consumerService.registerUser(user);
    }

    @PostMapping(value = "/consume/create")
    public ResponseEntity<Content> consumerContentCreateHandler (@RequestBody Content content) {
        System.out.println("con 8390");
        return consumerService.createContent(content);
    }


    @PostMapping(value = "/consume/modify")
    public ResponseEntity<Content> consumerContentModifyHandler (@RequestBody Content content) {
        return consumerService.modifyContent(content);
    }

    @PostMapping(value = "/consume/delete")
    public ResponseEntity<String> consumerContentRemoveHandler (@RequestParam("serial_no") int serial_no, String topic) {
        return consumerService.removeContent(serial_no, topic);
    }

}
