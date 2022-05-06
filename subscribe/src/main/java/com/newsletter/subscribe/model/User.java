package com.newsletter.subscribe.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String email;
    private String topic;

    public String getEmail ( ) {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getTopic ( ) {
        return topic;
    }

    public void setTopic (String topic) {
        this.topic = topic;
    }
}
