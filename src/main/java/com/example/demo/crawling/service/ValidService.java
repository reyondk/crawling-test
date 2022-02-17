package com.example.demo.crawling.service;

import com.example.demo.crawling.dto.CrawlingRequest;
import com.example.demo.crawling.exception.ParamNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidService {
	
	private final Validator validator;

	/**
	 * 유효성 체크
	 * @param request
	 */
	public void valid(CrawlingRequest request) {
		if (request == null) {
			throw new ParamNotFoundException();
		}
		
		Set<ConstraintViolation<CrawlingRequest>> violations = validator.validate(request);
		
		if (!violations.isEmpty()) {
			log.error("violations : {}", violations);
			String message = violations.stream()
				.map(ConstraintViolation::getMessage)
				.collect(Collectors.joining(", "));
			throw new ConstraintViolationException(message, violations);
		}
	}
	
}
