package com.example.demo.crawling.code;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CrawlingType {

	HTML_IGNORE, TEXT_ALL;

	public boolean isHtmlIgnore() {
		return HTML_IGNORE == this;
	}

	public boolean isTextAll() {
		return TEXT_ALL == this;
	}

	@JsonCreator
	public static CrawlingType getEnumByValue(String value) {
		try {
			return CrawlingType.valueOf(value);
		} catch (Exception e) {
			return null;
		}
	}

}
