package com.example.memoir.domain.memoir.controller.dto.request;

import com.example.memoir.domain.user.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class MemoirWriteRequest {

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "목표를 입력해주세요.")
    private String goal;

    @NotBlank(message = "배운점을 입력해주세요.")
    private String learned;

    @NotBlank(message = "느낀점을 입력해주세요.")
    private String felt;

    @NotBlank(message = "다음주 목표를 입력해주세요.")
    private String nextGoal;

}
