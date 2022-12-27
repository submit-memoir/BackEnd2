package com.example.memoir.domain.user.service;

import com.example.memoir.domain.user.controller.dto.request.UpdatePasswordRequest;
import com.example.memoir.domain.user.controller.dto.request.UserLoginRequest;
import com.example.memoir.domain.user.controller.dto.request.UserSignUpRequest;
import com.example.memoir.domain.user.controller.dto.request.UserUpdateRequest;
import com.example.memoir.domain.user.controller.dto.response.TokenResponse;
import com.example.memoir.domain.user.controller.dto.response.UserInfoResponse;
import com.example.memoir.domain.user.domain.user.User;
import com.example.memoir.domain.user.domain.user.repository.UserRepository;
import com.example.memoir.domain.user.exception.AlreadyUserExistException;
import com.example.memoir.domain.user.exception.UserNotFoundException;
import com.example.memoir.domain.user.facade.UserFacade;
import com.example.memoir.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional
    public void signup(UserSignUpRequest request) {

        if(userRepository.findByUserId(request.getUserId()).isPresent()) {
            throw AlreadyUserExistException.EXCEPTION;
        }

        User user = User.builder()
                .nickName(request.getNickName())
                .userId(request.getUserId())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(user);
    }

    @Transactional
    public TokenResponse login(UserLoginRequest request) {
        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);

        userFacade.checkPassword(user, request.getPassword());

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(request.getUserId()))
                .build();
    }

    @Transactional
    public UserInfoResponse userInfo() {
         User user = userFacade.getCurrentUser();

         return UserInfoResponse.builder()
                 .userId(user.getUserId())
                 .nickName(user.getNickName())
                 .introduce(user.getIntroduce())
                 .build();
    }

    @Transactional
    public void updateUser(UserUpdateRequest request) {
        User user = userFacade.getCurrentUser();

        user.updateUser(
                request.getNickName(),
                request.getIntroduce()
        );
    }

    @Transactional
    public void updatePassword(UpdatePasswordRequest request) {
        User user = userFacade.getCurrentUser();

        userFacade.checkPassword(user, request.getPassword());

        user.updatePassword(passwordEncoder.encode(request.getChangePassword()));
    }
}
