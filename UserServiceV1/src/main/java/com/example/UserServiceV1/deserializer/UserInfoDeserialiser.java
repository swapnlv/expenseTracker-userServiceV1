package com.example.UserServiceV1.deserializer;

import com.example.UserServiceV1.entities.UserInfoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class UserInfoDeserialiser implements Deserializer<UserInfoDTO> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public UserInfoDTO deserialize(String topic, byte[] data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println("Deserializing message: " + new String(data));
            return objectMapper.readValue(data, UserInfoDTO.class);
        } catch (Exception e) {
            System.out.println("Failed to deserialize message: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
