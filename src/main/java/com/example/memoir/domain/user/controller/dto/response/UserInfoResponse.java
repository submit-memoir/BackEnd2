package com.example.memoir.domain.user.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResponse {

    private String userId;
    private String nickName;
    private String introduce;

}
