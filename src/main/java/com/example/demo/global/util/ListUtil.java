package com.example.demo.global.util;

import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ListUtil {
	
	/**
	 * 영문자 숫자 리스트 Mix (A0a1a7BbZz)
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static String mixListsToString(List<String> list1, List<String> list2) {
		int size1 = list1 == null ? 0 : list1.size();
		int size2 = list2 == null ? 0 : list2.size();
		int minSize = Math.min(size1, size2);
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < minSize; i++) {
			sb.append(list1.get(i));
			sb.append(list2.get(i));
		}
		
		if (size1 == size2) {
			return sb.toString();
		}
		
		List<String> list = (minSize == size1) ? list2 : list1;
		int size = list.size();
		
		for (int i = minSize; i < size; i++) {
			sb.append(list.get(i));
		}
		
		return sb.toString();
	}
	
}
