package com.example.memoir.domain.user.exception;

import com.example.memoir.global.error.ErrorCode;
import com.example.memoir.global.error.handler.MemoirException;

public class AlreadyUserExistException extends MemoirException {

    public static final MemoirException EXCEPTION = new AlreadyUserExistException();

    private AlreadyUserExistException() {
        super(ErrorCode.ALREADY_USER_EXIST);
    }
}
