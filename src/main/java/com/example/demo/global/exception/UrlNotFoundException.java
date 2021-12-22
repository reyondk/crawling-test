package com.example.demo.global.exception;

import com.example.demo.global.code.ErrorCode;

public class UrlNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public UrlNotFoundException() {
        super(ErrorCode.URL_NOT_FOUND);
    }
	
}
