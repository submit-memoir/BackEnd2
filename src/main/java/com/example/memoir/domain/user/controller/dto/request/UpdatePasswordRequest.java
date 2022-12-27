package com.example.memoir.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UpdatePasswordRequest {

    @NotBlank(message = "현재 비밀번호를 입력해주세요.")
    private String password;

    @NotBlank(message = "바꿀 비밀번호를 입력해주세요.")
    private String changePassword;
}
