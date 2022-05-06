package com.newsletter.subscribe.dao;

import com.newsletter.subscribe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepo extends JpaRepository<User, Long> {
}
