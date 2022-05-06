package com.newsletter.content.dao;

import com.newsletter.content.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ContentRepoClass implements ContentRepoInterface {

    @Autowired
    @Lazy
    private JdbcTemplate jdbcTemplate;


    @Override
    public int save (Content content) {
        int rowAffected = 0;
        try {
            int size = jdbcTemplate.queryForObject("select count(*) from " + content.getTopic(), Integer.class);
            rowAffected = jdbcTemplate.update("insert into " + content.getTopic() + " (serial_no,text,publish_date,delivered) values(?,?,?,?) ",
                    size + 1, content.getText(), content.getDate(), content.isDelivered());
        } catch (DataAccessException | NullPointerException dataEx) {
            // Exception handle and log error into log file
        }
        return rowAffected;
    }

    @Override
    public int update (Content content) {
        int rowAffected = 0;
        try {
            rowAffected = jdbcTemplate.update("update " + content.getTopic() + " set text = ?, publish_date = ?,delivered = ? where serial_no = ? ",
                    content.getText(), content.getDate(), content.isDelivered(), content.getSerial_no());
        } catch (DataAccessException | NullPointerException dataEx) {
            // Exception handle and log error into log file
        }
        return rowAffected;
    }

    @Override
    public int delete (int serial_no, String topic) {
        int rowAffected = 0;
        try {
            rowAffected = jdbcTemplate.update("delete from " + topic + " where serial_no =? ", serial_no);
        } catch (DataAccessException | NullPointerException dataEx) {
            // Exception handle and log error into log file
        }
        return rowAffected;
    }
}
