package com.example.demo.crawling.service;

import com.example.demo.crawling.dto.request.PrintRequest;
import com.example.demo.crawling.dto.response.PrintResponse;

public interface CrawlingService {
	
	/**
	 * 출력
	 * 
	 * @param printRequest
	 * @return
	 */
	PrintResponse print(PrintRequest printRequest);

}
