package com.newsletter.consumer.model;

public class User {
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
