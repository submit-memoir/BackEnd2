package com.example.memoir.domain.comment.exception;

import com.example.memoir.global.error.ErrorCode;
import com.example.memoir.global.error.handler.MemoirException;

public class CommentNotDeleteException extends MemoirException {

    public final static MemoirException EXCEPTION = new CommentNotDeleteException();

    private CommentNotDeleteException() {
        super(ErrorCode.COMMENT_NOT_DELETE);
    }
}
