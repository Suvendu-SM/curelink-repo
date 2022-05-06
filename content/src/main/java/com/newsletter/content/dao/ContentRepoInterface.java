package com.newsletter.content.dao;

import com.newsletter.content.model.Content;

public interface ContentRepoInterface {
    int save (Content content);

    int update (Content content);

    int delete (int serial_no, String topic);
}
