package com.example.UserServiceV1.services;


import com.example.UserServiceV1.entities.UserInfoDTO;
import com.example.UserServiceV1.entities.Userinfo;
import com.example.UserServiceV1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;


@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserInfoDTO createOrUpdateUser(UserInfoDTO userInfoDto) {
        UnaryOperator<Userinfo> updatingUser = existingUser -> {
            Userinfo updatedUser = userInfoDto.transformToUserInfo();
            updatedUser.setUserId(existingUser.getUserId()); // Retain the ID of the existing user
            return userRepository.save(updatedUser);
        };

        Supplier<Userinfo> createUser = () -> userRepository.save(userInfoDto.transformToUserInfo());

        Userinfo userInfo = userRepository.findByUserId(userInfoDto.getUserId())
                .map(updatingUser) // Update if user exists
                .orElseGet(createUser); // Create if user does not exist

        return new UserInfoDTO(
                userInfo.getUserId(),
                userInfo.getFirstName(),
                userInfo.getLastName(),
                userInfo.getPhoneNumber(),
                userInfo.getEmail(),
                userInfo.getProfilePic()
        );
    }


}

