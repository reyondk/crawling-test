package com.example.demo.global.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.example.demo.global.code.CrawlingType;
import com.example.demo.global.exception.UrlNotFoundException;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class CrawlingUtil {
	
	/**
	 * 크롤링
	 * 
	 * @param type
	 * @param url
	 * @return
	 */
	public static String crawling(CrawlingType type, String url) {
		try {
			Document doc = Jsoup.connect(url).get();
			String ans = type.isHtmlIgnore() ? doc.text() : doc.html();	
			return ans;
			
		} catch (Exception e) {
			log.error("{}", e);
			throw new UrlNotFoundException();
		}
	}
	
}
