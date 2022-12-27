package com.example.memoir.entity.user;

import com.example.memoir.GetUser;
import com.example.memoir.domain.user.domain.user.User;
import com.example.memoir.domain.user.domain.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class UserTest {

    @Autowired
    private UserRepository userRepository;

    private static final User user = GetUser.user;


}