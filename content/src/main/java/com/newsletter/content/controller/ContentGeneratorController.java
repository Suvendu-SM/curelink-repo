package com.newsletter.content.controller;

import com.newsletter.content.model.Content;
import com.newsletter.content.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping("/content")
public class ContentGeneratorController {

    @Autowired
    @Lazy
    ContentService contentService;

    @PostMapping(value = "/insert")
    public ResponseEntity<Content> addContentHandler (@RequestBody Content content) {
        System.out.println("port 8389");
        int affectedRow = contentService.addContentIntoDb(content);
        return affectedRow > 0 ? new ResponseEntity<>(content, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<String> deleteContentHandler (@RequestParam("serial_no") int serial_no, @RequestParam("topic") String topic) {
        int affectedRow = contentService.deleteContentFromDb(serial_no, topic);
        return new ResponseEntity<>(affectedRow + "row deleted", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Content> updateContentHandler (@RequestBody Content content) {
        int affectedRow = contentService.updateContentIntoDb(content);

        return affectedRow > 0 ? new ResponseEntity<>(content, HttpStatus.OK) :
                new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
