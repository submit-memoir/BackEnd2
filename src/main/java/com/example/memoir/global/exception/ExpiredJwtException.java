package com.example.memoir.global.exception;

import com.example.memoir.global.error.ErrorCode;
import com.example.memoir.global.error.handler.MemoirException;

public class ExpiredJwtException extends MemoirException {

    public static final MemoirException EXCEPTION = new ExpiredJwtException();

    private ExpiredJwtException() {
        super(ErrorCode.EXPIRED_JWT);
    }
}
