package com.example.memoir.domain.comment.service;

import com.example.memoir.domain.comment.controller.dto.request.UpdateCommentRequest;
import com.example.memoir.domain.comment.controller.dto.request.WriteCommentRequest;
import com.example.memoir.domain.comment.controller.dto.response.CommentResponse;
import com.example.memoir.domain.comment.domain.Comment;
import com.example.memoir.domain.comment.domain.repository.CommentRepository;
import com.example.memoir.domain.comment.exception.CommentNotDeleteException;
import com.example.memoir.domain.comment.exception.CommentNotUpdateException;
import com.example.memoir.domain.comment.facade.CommentFacade;
import com.example.memoir.domain.memoir.controller.dto.response.MemoirResponse;
import com.example.memoir.domain.memoir.domain.Memoir;
import com.example.memoir.domain.memoir.facade.MemoirFacade;
import com.example.memoir.domain.user.domain.user.User;
import com.example.memoir.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserFacade userFacade;
    private final MemoirFacade memoirFacade;
    private final CommentFacade commentFacade;

    @Transactional
    public void commentWrite(WriteCommentRequest request, Long id) {
        
        User user = userFacade.getCurrentUser();
        Memoir memoir = memoirFacade.getMemoirId(id);
        commentRepository.save(
                Comment.builder()
                        .content(request.getContent())
                        .user(user)
                        .memoir(memoir)
                        .build()
        );
    }

    @Transactional
    public void commentUpdate(UpdateCommentRequest request, Long commentId) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.getCommentId(commentId);

        if(!user.equals(comment.getUser())) {
            throw CommentNotUpdateException.EXCEPTION;
        }

        comment.commentUpdate(request.getComment());
    }

    @Transactional
    public void commentDelete(Long commentId) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.getCommentId(commentId);

        if(!user.equals(comment.getUser())) {
            throw CommentNotDeleteException.EXCEPTION;
        }

        commentRepository.delete(comment);
    }

    @Transactional(readOnly = true)
    public List<CommentResponse> commentList(Long memoirId) {

        Memoir memoir = memoirFacade.getMemoirId(memoirId);

        return commentRepository.findAllByMemoirId(memoir.getId())
                .stream().map(comment -> CommentResponse.builder()
                        .id(comment.getId())
                        .content(comment.getContent())
                        .nickname(comment.getNickName())
                        .build())
                .collect(Collectors.toList());

    }
}
