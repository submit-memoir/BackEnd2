package com.example.memoir.domain.comment.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
public class WriteCommentRequest {

    @NotBlank(message = "댓글 내용을 입력해주세요.")
    @Size(max = 3000)
    private String content;
}
