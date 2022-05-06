package com.newsletter.content.service;

import com.newsletter.content.dao.ContentRepoClass;
import com.newsletter.content.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {

    @Autowired
    ContentRepoClass contentRepoClass;

    public int addContentIntoDb (Content content) {
        return contentRepoClass.save(content);
    }

    public int deleteContentFromDb (int serial_no, String topic) {
        return contentRepoClass.delete(serial_no, topic);
    }

    public int updateContentIntoDb (Content content) {
        return contentRepoClass.update(content);
    }
}
