package com.newsletter.subscribe.controller;

import com.newsletter.subscribe.model.User;
import com.newsletter.subscribe.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/user")
public class SubscribeSystemController {

    @Autowired
    @Lazy
    private SubscribeService subscribeService;

    @PostMapping(value = "/subscribe")
    public ResponseEntity<User> addUserToMailingListHandler (@RequestBody User user) {
        User userToDb = subscribeService.addUserToDb(user);

        if (userToDb == null)
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(userToDb, HttpStatus.OK);
    }
}
