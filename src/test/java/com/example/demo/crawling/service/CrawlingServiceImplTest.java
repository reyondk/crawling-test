package com.example.demo.crawling.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.crawling.dto.request.PrintRequest;
import com.example.demo.crawling.dto.response.PrintResponse;
import com.example.demo.global.code.CrawlingType;

@SpringBootTest
class CrawlingServiceImplTest {
	
	@Autowired
	private CrawlingService crawlingService;
	
	@Test
	void 출력_테스트() {
		PrintRequest request = new PrintRequest(null, CrawlingType.HTML_IGNORE, 100);
		PrintResponse response = crawlingService.print(request);
		assertThat(response).isNotNull();
	}

}
