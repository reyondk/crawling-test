package com.example.demo.crawling.controller;

import com.example.demo.crawling.dto.ErrorResponse;
import com.example.demo.crawling.dto.request.PrintRequest;
import com.example.demo.crawling.dto.response.PrintResponse;
import com.example.demo.crawling.service.CrawlingService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CrawlingController {

	private final CrawlingService crawlingService;
	
	@ApiOperation(tags = "크롤링", value = "출력", notes = "출력")
	@ApiResponses({
		@ApiResponse(code = 200, message = "성공", response = PrintResponse.class),
		@ApiResponse(code = 400, message = "실패", response = ErrorResponse.class),
		@ApiResponse(code = 500, message = "서버 오류", response = ErrorResponse.class) })
	@PostMapping(value = "/api/v1/crawling/print", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> print(@Valid @RequestBody PrintRequest printRequest) {
		PrintResponse response = crawlingService.print(printRequest);
		return ResponseEntity.ok(response);
	}

}