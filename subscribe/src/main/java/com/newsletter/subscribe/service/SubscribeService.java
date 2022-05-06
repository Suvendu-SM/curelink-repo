package com.newsletter.subscribe.service;

import com.newsletter.subscribe.dao.SubscriberRepo;
import com.newsletter.subscribe.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


@Service
public class SubscribeService {

    @Autowired
    @Lazy
    private SubscriberRepo subscriberRepo;

    public User addUserToDb (User user) {
        User userToDb = null;
        try {
            userToDb = subscriberRepo.save(user); // persist into db
        } catch (DataAccessException ex) {
            /*handle fallback*/
            //insert the user into another database so that in future we will persist it into master db
        }
        return userToDb;
    }
}
