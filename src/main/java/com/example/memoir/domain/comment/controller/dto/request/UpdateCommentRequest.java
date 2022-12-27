package com.example.memoir.domain.comment.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateCommentRequest {

    @NotBlank
    @Size(max = 3000)
    private String comment;
}
