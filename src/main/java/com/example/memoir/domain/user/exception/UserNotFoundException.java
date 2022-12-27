package com.example.memoir.domain.user.exception;

import com.example.memoir.global.error.ErrorCode;
import com.example.memoir.global.error.handler.MemoirException;

public class UserNotFoundException extends MemoirException {

    public static final MemoirException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USERNAME_NOT_FOUND);
    }
}
