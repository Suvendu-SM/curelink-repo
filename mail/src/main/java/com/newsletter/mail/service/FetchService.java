package com.newsletter.mail.service;

import com.newsletter.mail.model.Content;
import com.newsletter.mail.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchService {

    @Autowired
    @Lazy
    JdbcTemplate jdbcTemplate;


    public List<User> fetchUsers (String topic) {
        String sql = "select email from users where topic = " + topic;
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(User.class)
        );
    }

    public String fetchContent (String topic) {
        String sql = "select text from " + topic + " where delivered = 0";
        Content content = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Content.class));
        return content != null ? content.getText() : null;
    }
}
