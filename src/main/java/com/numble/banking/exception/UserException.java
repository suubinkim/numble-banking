package com.numble.banking.exception;

public class UserException extends RuntimeException{

    private final ErrorCode errorCode;

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public ErrorCode getCode() {
        return this.errorCode;
    }

    public UserException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public UserException(ErrorCode errorCode, String message) {
        super(errorCode.getMessage() + ": " + message);
        this.errorCode = errorCode;
    }
}
