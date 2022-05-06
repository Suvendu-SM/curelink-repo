package com.newsletter.consumer.model;

import java.util.Date;

public class Content {

    private int serial_no;
    private String text;
    private Date publish_date;
    private int delivered;
    private String topic;

    public String getTopic ( ) {
        return topic;
    }

    public void setTopic (String topic) {
        this.topic = topic;
    }

    public int getSerial_no ( ) {
        return serial_no;
    }

    public void SetSerial_no (int serial_no) {
        this.serial_no = serial_no;
    }

    public String getText ( ) {
        return text;
    }

    public void setText (String text) {
        this.text = text;
    }

    public Date getDate ( ) {
        return publish_date;
    }

    public void setDate (Date date) {
        this.publish_date = date;
    }

    public int getDelivered ( ) {
        return delivered;
    }

    public void setDelivered (int delivered) {
        this.delivered = delivered;
    }

}
