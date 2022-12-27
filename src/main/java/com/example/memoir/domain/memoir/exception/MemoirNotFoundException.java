package com.example.memoir.domain.memoir.exception;

import com.example.memoir.global.error.ErrorCode;
import com.example.memoir.global.error.handler.MemoirException;

public class MemoirNotFoundException extends MemoirException {

    public static final MemoirException EXCEPTION = new MemoirNotFoundException();

    private MemoirNotFoundException() {
        super(ErrorCode.MEMOIR_NOT_FOUND);
    }
}
