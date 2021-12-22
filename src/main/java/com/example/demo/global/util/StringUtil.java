package com.example.demo.global.util;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StringUtil {
	
	/**
	 * 영문자 제외 replace 처리
	 * 
	 * @param str
	 * @return
	 */
	public static String regexAlphabet(String str) {
		if (str == null) {
			return "";
		}
		
		String ans = str.replaceAll("[^a-zA-Z]+", "");
		return ans;
	}
	
	/**
	 * 숫자 제외 replace 처리
	 * 
	 * @param str
	 * @return
	 */
	public static String regexNumber(String str) {
		if (str == null) {
			return "";
		}
		
		String ans = str.replaceAll("[^0-9]+", "");
		return ans;
	}
	
	/**
	 * 영문자, 숫자, 공백 제외 replace 처리
	 * 
	 * @param str
	 * @return
	 */
	public static String regexAlphabetAndNumberAndWhitespace(String str) {
		if (str == null) {
			return "";
		}
		
		String ans = str.replaceAll("[^a-zA-Z0-9|s]+", "");
		return ans;
	}
	
	/**
	 * 몫까지의 str 구하기
	 * 
	 * @param str
	 * @param bundle
	 * @return
	 */
	public static String quotient(String str, long bundle) {
		if (bundle < 1) {
			return str;
		}
		
		long quotient = str.length() / bundle;
		long endIndex = quotient * bundle;
        String ans = str.substring(0, Long.valueOf(endIndex).intValue());
		return ans;
	}
	
	/**
	 * 나머지만큼의 str 구하기
	 * 
	 * @param str
	 * @param bundle
	 * @return
	 */
	public static String remainder(String str, long bundle) {
		if (bundle < 1) {
			return str;
		}
		
		long remainder = str.length() % bundle;
		long startIndex = str.length() - remainder;
        String ans = str.substring(Long.valueOf(startIndex).intValue());
		return ans;
	}

}
