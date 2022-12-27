package com.example.memoir.domain.user.facade;

import com.example.memoir.domain.user.domain.user.User;
import com.example.memoir.domain.user.domain.user.repository.UserRepository;
import com.example.memoir.domain.user.exception.PasswordMismatchException;
import com.example.memoir.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getCurrentUser() {
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByUserId(userId)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

    public void checkPassword(User user, String password) {
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }
    }
}
