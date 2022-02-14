package com.example.demo.crawling.util;

import com.example.demo.crawling.code.CrawlingType;
import com.example.demo.crawling.exception.UrlNotFoundException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@Slf4j
@UtilityClass
public class CrawlingUtil {
	
	/**
	 * 크롤링
	 * 
	 * @param type
	 * @param url
	 * @return
	 */
	public String crawling(CrawlingType type, String url) {
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
