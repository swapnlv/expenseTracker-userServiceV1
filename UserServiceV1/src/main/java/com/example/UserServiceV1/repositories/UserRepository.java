package com.example.UserServiceV1.repositories;

import com.example.UserServiceV1.entities.Userinfo;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends CrudRepository<Userinfo, String> {

    Optional<Userinfo> findByUserId(String userId);
}

