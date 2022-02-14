package com.example.demo.crawling.service;

import com.example.demo.crawling.service.ValidService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.crawling.dto.request.PrintRequest;
import com.example.demo.crawling.code.CrawlingType;

@SpringBootTest
class ValidServiceImplTest {
	
	@Autowired
	private ValidService validService;

	@Test
	void 크롤링_출력_유효성_체크_테스트() {
		PrintRequest request = new PrintRequest(null, CrawlingType.HTML_IGNORE, 100);
		validService.valid(request);
	}

}
