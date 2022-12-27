package com.example.memoir.global.error.handler;

import com.example.memoir.global.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemoirException extends RuntimeException{

    private final ErrorCode errorCode;
}
