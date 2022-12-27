package com.example.memoir;

import com.example.memoir.domain.user.domain.user.User;

public class GetUser {

    public static final User user = User.builder()
            .userId("test01")
            .password("test01!")
            .nickName("회고록")
            .build();
}
