package com.example.memoir.global.exception;

import com.example.memoir.global.error.ErrorCode;
import com.example.memoir.global.error.handler.MemoirException;

public class InvalidJwtException extends MemoirException {

    public static final MemoirException EXCEPTION = new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}
