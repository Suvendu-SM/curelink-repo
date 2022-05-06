package com.newsletter.consumer.service;

import com.newsletter.consumer.model.Content;
import com.newsletter.consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    public ResponseEntity<User> registerUser (User user) {
        return restTemplate.postForEntity("http://subscribe-service/user/subscribe", user, User.class);
    }

    public ResponseEntity<Content> createContent (Content Content) {
        return restTemplate.postForEntity("http://content-publish-service/content/insert", Content, Content.class);
    }

    public ResponseEntity<Content> modifyContent (Content Content) {
        return restTemplate.postForEntity("http://content-publish-service/content/update", Content, Content.class);
    }

    public ResponseEntity<String> removeContent (int serial_no, String topic) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("serial_no", serial_no);
        params.add("topic", topic);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(params, headers);

        return restTemplate.postForEntity("http://content-publish-service/content/delete", request, String.class);
    }

}
