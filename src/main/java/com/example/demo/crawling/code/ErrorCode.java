package com.example.demo.crawling.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	INTERNAL_SERVER_ERROR(500, "CO001", "시스템 오류입니다."),
    INVALID_INPUT_VALUE(400, "CO002", "유효하지 않은 파라미터 값입니다."),
    INVALID_TYPE_VALUE(400, "CO003", "유효하지 않은 파라미터 타입입니다."),
    PARAM_NOT_FOUND(400, "CO004", "파라미터를 찾을 수 없습니다."),
    URL_NOT_FOUND(400, "CO005", "URL을 찾을 수 없습니다."),
	;
	
	private int status;
	private String code;
	private String message;
	
}
