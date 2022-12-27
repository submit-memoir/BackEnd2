package com.example.memoir.global.security.auth;

import com.example.memoir.domain.user.domain.user.repository.UserRepository;
import com.example.memoir.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public AuthDetails loadUserByUsername(String userId) throws UserNotFoundException {
        return new AuthDetails(
                userRepository.findByUserId(userId)
                        .orElseThrow(()-> UserNotFoundException.EXCEPTION)
        );
    }
}
