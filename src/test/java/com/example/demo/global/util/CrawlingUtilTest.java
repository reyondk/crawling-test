package com.example.demo.global.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.demo.global.code.CrawlingType;

class CrawlingUtilTest {

	@Test	
	void HTML_IGNORE_크롤링_테스트() {
		String html = CrawlingUtil.crawling(CrawlingType.HTML_IGNORE, "http://www.wemakeprice.com");
		assertThat(html).isNotNull();
	}
	
	@Test
	void TEXT_ALL_크롤링_테스트() {
		String html = CrawlingUtil.crawling(CrawlingType.TEXT_ALL, "http://www.wemakeprice.com");
		assertThat(html).isNotNull();
	}
	
}
