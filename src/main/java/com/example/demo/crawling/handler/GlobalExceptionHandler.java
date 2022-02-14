package com.example.demo.crawling.handler;

import javax.validation.ConstraintViolationException;

import com.example.demo.crawling.code.ErrorCode;
import com.example.demo.crawling.dto.ErrorResponse;
import com.example.demo.crawling.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		log.error("handleMethodArgumentNotValidException", e);
		ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
		ResponseEntity<ErrorResponse> response = new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		return response;
	}
	
	@ExceptionHandler(BindException.class)
	public ResponseEntity<ErrorResponse> handleBindException(BindException e) {
		log.error("handleBindExceptionException", e);
		ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INVALID_INPUT_VALUE, e.getBindingResult());
		ResponseEntity<ErrorResponse> response = new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		return response;
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> constraintViolationException(ConstraintViolationException e) {
		log.error("constraintViolationException", e);
		ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INVALID_INPUT_VALUE, e);
		ResponseEntity<ErrorResponse> response = new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		return response;
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
		log.error("handleMethodArgumentTypeMismatchException", e);
		ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INVALID_TYPE_VALUE, e);
		ResponseEntity<ErrorResponse> response = new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
		return response;
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
		log.error("handleBusinessException", e);
		ErrorCode errorCode = e.getErrorCode();
		ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode());
		ResponseEntity<ErrorResponse> response = new ResponseEntity<>(errorResponse, HttpStatus.valueOf(errorCode.getStatus()));
		return response;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception e) {
		log.error("handleException", e);
		ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR);
		ResponseEntity<ErrorResponse> response = new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}
	
}
