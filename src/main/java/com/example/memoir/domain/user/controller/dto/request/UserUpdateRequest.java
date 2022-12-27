package com.example.memoir.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@NoArgsConstructor
public class UserUpdateRequest {

    @NotBlank(message = "이름을 입력해주세요")
    private String nickName;

    @NotBlank(message = "자기소개를 입력해주세요.")
    private String introduce;
}
