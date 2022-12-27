package com.example.memoir.domain.comment.controller.dto.response;

import com.example.memoir.domain.comment.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CommentResponse {
    private Long id;
    private final String nickname;

    private final String content;

    public CommentResponse(Comment comment) {
        id = comment.getId();
        content = comment.getContent();
        nickname = comment.getNickName();
    }
}
