package com.example.demo.global.service;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.stereotype.Service;

import com.example.demo.global.dto.ApiRequest;
import com.example.demo.global.exception.ParamNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidServiceImpl implements ValidService {
	
	private final Validator validator;
	
	/**
	 * 유효성 체크
	 * 
	 * @param request
	 */
	public void valid(ApiRequest request) {
		if (request == null) {
			throw new ParamNotFoundException();
		}
		
		Set<ConstraintViolation<ApiRequest>> violations = validator.validate(request);
		
		if (!violations.isEmpty()) {
			log.error("violations : {}", violations);
			String message = violations.stream()
				.map(ConstraintViolation::getMessage)
				.collect(Collectors.joining(", "));
			throw new ConstraintViolationException(message, violations);
		}
	}
	
}
