package com.example.demo.crawling.util;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.crawling.util.StringUtil;
import org.junit.jupiter.api.Test;

class StringUtilTest {

	@Test
	void 영문자_정규식_테스트() {
		String str = StringUtil.regexAlphabet("abcABC012ㄱㄴㄷ!@#   ");
		assertThat(str).isEqualTo("abcABC");
	}

	@Test
	void 숫자_정규식_테스트() {
		String str = StringUtil.regexNumber("abcABC012ㄱㄴㄷ!@#   ");
		assertThat(str).isEqualTo("012");
	}

	@Test
	void 염문자_숫자_정규식_테스트() {
		String str = StringUtil.regexAlphabetAndNumberAndWhitespace("abcABC012ㄱㄴㄷ!@#   ");
		assertThat(str).isEqualTo("abcABC012");
	}

	@Test
	void 몫_구하기_테스트() {
		String str = StringUtil.quotient("12345678901234567890", 2);
		assertThat(str).isEqualTo("12345678901234567890");
	}

	@Test
	void 나머지_구하기_테스트() {
		String str = StringUtil.remainder("12345678901234567890", 3);
		assertThat(str).isEqualTo("90");
	}

}
