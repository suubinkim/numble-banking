package com.numble.banking.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // User
    DUPLICATE_LOGIN_ID("0001","이미 존재하는 아이디입니다.")


    ;

    private final String code;
    private final String message;
}
