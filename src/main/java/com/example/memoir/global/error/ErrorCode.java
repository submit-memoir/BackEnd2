package com.example.memoir.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    ALREADY_USER_EXIST(409, "이미 존재하는 유저 입니다."),
    INTERNAL_SERVER_ERROR(500, "서버 오류입니다."),
    USERNAME_NOT_FOUND(404, "유저 이름을 찾을 수 없습니다."),
    EXPIRED_JWT(401, "토큰이 만료되었습니다."),
    INVALID_JWT(401,"유효하지 않은 토큰입니다"),
    PASSWORD_MISMATCH(401, "비밀번호가 일치하지 않습니다."),

    MEMOIR_NOT_FOUND(404,"회고록을 찾을 수 없습니다."),
    MEMOIR_NOT_DELETE(401, "회고록을 삭제 할 수 없습니다."),
    COMMENT_NOT_UPDATE(401, "댓글을 수정할 수 없습니다."),
    COMMENT_NOT_DELETE(401, "댓글을 삭제할 수 없습니다."),
    MEMOIR_NOT_UPDATE(401, "회고록을 수정할 수 없습니다.");

    private final int status;
    private final String message;
}
