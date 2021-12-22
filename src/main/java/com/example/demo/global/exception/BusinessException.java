package com.example.demo.global.exception;

import com.example.demo.global.code.ErrorCode;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ErrorCode errorCode;

    public BusinessException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
