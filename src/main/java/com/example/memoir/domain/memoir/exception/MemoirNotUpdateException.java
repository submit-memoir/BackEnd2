package com.example.memoir.domain.memoir.exception;

import com.example.memoir.global.error.ErrorCode;
import com.example.memoir.global.error.handler.MemoirException;

public class MemoirNotUpdateException extends MemoirException {

    public static final MemoirException EXCEPTION = new MemoirNotUpdateException();

    private MemoirNotUpdateException() {
        super(ErrorCode.MEMOIR_NOT_UPDATE);
    }
}
