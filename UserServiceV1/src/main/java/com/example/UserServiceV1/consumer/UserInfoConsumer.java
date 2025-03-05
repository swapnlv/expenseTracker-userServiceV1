package com.example.UserServiceV1.consumer;

import com.example.UserServiceV1.entities.UserInfoDTO;
import com.example.UserServiceV1.repositories.UserRepository;
import com.example.UserServiceV1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class UserInfoConsumer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(UserInfoDTO eventdata) {
        try {
            System.out.println("Received message: " + eventdata);
            userService.createOrUpdateUser(eventdata);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
