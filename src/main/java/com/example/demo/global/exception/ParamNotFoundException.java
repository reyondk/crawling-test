package com.example.demo.global.exception;

import com.example.demo.global.code.ErrorCode;

public class ParamNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public ParamNotFoundException() {
        super(ErrorCode.PARAM_NOT_FOUND);
    }
	
}
