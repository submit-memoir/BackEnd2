package com.example.memoir.domain.memoir.exception;

import com.example.memoir.global.error.ErrorCode;
import com.example.memoir.global.error.handler.MemoirException;

public class MemoirNotDeleteException extends MemoirException {

    public static final MemoirException EXCEPTION = new MemoirNotDeleteException();

    private MemoirNotDeleteException() {
        super(ErrorCode.MEMOIR_NOT_DELETE);
    }
}
