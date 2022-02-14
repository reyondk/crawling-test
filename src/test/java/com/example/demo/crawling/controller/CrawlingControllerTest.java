package com.example.demo.crawling.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.crawling.dto.request.PrintRequest;
import com.example.demo.crawling.code.CrawlingType;
import com.example.demo.crawling.handler.GlobalExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class CrawlingControllerTest {

	@Autowired
	private CrawlingController crawlingController;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	void before() {
		mockMvc = MockMvcBuilders.standaloneSetup(crawlingController)
			.setControllerAdvice(new GlobalExceptionHandler())
			.build();
	}

	@Test
	void 출력_성공_테스트() throws Exception {
		PrintRequest request = new PrintRequest("http://www.wemakeprice.com", CrawlingType.HTML_IGNORE, 100);
		MvcResult mvcResult = mockMvc.perform(post("/api/v1/crawling/print")
			.content(request.toString())
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andDo(MockMvcResultHandlers.log())
			.andReturn();
		log.error("response : {}", mvcResult.getResponse().getContentAsString());
	}

	@Test
	void 출력_실패_테스트() throws Exception {
		PrintRequest request = new PrintRequest("www.wemakeprice.com", CrawlingType.HTML_IGNORE, -1);
		MvcResult mvcResult = mockMvc.perform(post("/api/v1/crawling/print")
			.content(request.toString())
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isBadRequest())
			.andDo(MockMvcResultHandlers.log())
			.andReturn();
		log.error("response : {}", mvcResult.getResponse().getContentAsString());
	}

}
