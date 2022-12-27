package com.example.memoir.domain.comment.exception;

import com.example.memoir.global.error.ErrorCode;
import com.example.memoir.global.error.handler.MemoirException;

public class CommentNotUpdateException extends MemoirException {

    public static final MemoirException EXCEPTION = new CommentNotUpdateException();

    private CommentNotUpdateException() {
        super(ErrorCode.COMMENT_NOT_UPDATE);
    }
}
