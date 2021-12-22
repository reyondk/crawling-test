package com.example.demo.global.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListUtilTest {

	@Test
	void 영문자_숫자_리스트_mix_두_리스트_사이즈가_동일한_테스트() {
		List<String> alphabets = new ArrayList<>();
		alphabets.add("a");
		alphabets.add("b");
		alphabets.add("c");
		
		List<String> numbers = new ArrayList<>();
		numbers.add("1");
		numbers.add("2");
		numbers.add("3");
		
		String str = ListUtil.mixListsToString(alphabets, numbers);
		assertThat(str).isEqualTo("a1b2c3");
	}
	
	@Test
	void 영문자_숫자_리스트_mix_영문자_리스트가_더큰_테스트() {
		List<String> alphabets = new ArrayList<>();
		alphabets.add("a");
		alphabets.add("b");
		alphabets.add("c");
		alphabets.add("d");
		alphabets.add("e");
		
		List<String> numbers = new ArrayList<>();
		numbers.add("1");
		numbers.add("2");
		numbers.add("3");
		
		String str = ListUtil.mixListsToString(alphabets, numbers);
		assertThat(str).isEqualTo("a1b2c3de");
	}
	
	@Test
	void 영문자_숫자_리스트_mix_숫자_리스트가_더큰_테스트() {
		List<String> alphabets = new ArrayList<>();
		alphabets.add("a");
		alphabets.add("b");
		alphabets.add("c");
		
		List<String> numbers = new ArrayList<>();
		numbers.add("1");
		numbers.add("2");
		numbers.add("3");
		numbers.add("4");
		numbers.add("5");
		
		String str = ListUtil.mixListsToString(alphabets, numbers);
		assertThat(str).isEqualTo("a1b2c345");
	}
	
	@Test
	void 영문자_숫자_리스트_mix_영문자_리스트가_0인_테스트() {
		List<String> alphabets = new ArrayList<>();
		List<String> numbers = new ArrayList<>();
		numbers.add("1");
		numbers.add("2");
		numbers.add("3");
		
		String str = ListUtil.mixListsToString(alphabets, numbers);
		assertThat(str).isEqualTo("123");
	}
	
	@Test
	void 영문자_숫자_리스트_mix_숫문자_리스트가_0인_테스트() {
		List<String> alphabets = new ArrayList<>();
		alphabets.add("a");
		alphabets.add("b");
		alphabets.add("c");
		
		List<String> numbers = new ArrayList<>();
		
		String str = ListUtil.mixListsToString(alphabets, numbers);
		assertThat(str).isEqualTo("abc");
	}
	
	@Test
	void 영문자_숫자_리스트_mix_두_리스트가_0인_테스트() {
		List<String> alphabets = new ArrayList<>();
		List<String> numbers = new ArrayList<>();
		
		String str = ListUtil.mixListsToString(alphabets, numbers);
		assertThat(str).isEqualTo("");
	}

}
