package com.example.memoir.domain.comment.facade;

import com.example.memoir.domain.comment.domain.Comment;
import com.example.memoir.domain.comment.domain.repository.CommentRepository;
import com.example.memoir.domain.comment.exception.CommentNotUpdateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment getCommentId(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(()-> CommentNotUpdateException.EXCEPTION);
    }
}
