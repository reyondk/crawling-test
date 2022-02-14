package com.example.demo.crawling.service;

import com.example.demo.crawling.dto.response.PrintResponse;
import com.example.demo.crawling.dto.request.PrintRequest;
import com.example.demo.crawling.exception.UrlNotFoundException;
import com.example.demo.crawling.util.CrawlingUtil;
import com.example.demo.crawling.util.ListUtil;
import com.example.demo.crawling.util.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class CrawlingService {
	
	private final ValidService validService;

	/**
	 * 출력
	 * @param request
	 * @return
	 */
	public PrintResponse print(PrintRequest request) {
		validService.valid(request);
		
		String html = Optional.ofNullable(CrawlingUtil.crawling(request.getType(), request.getUrl()))
			.orElseThrow(UrlNotFoundException::new);
		html = StringUtil.regexAlphabetAndNumberAndWhitespace(html);
		log.debug("html : {}", html);

		// AaBbCcDd 순 정렬
		List<String> alphabets = Stream.of(StringUtil.regexAlphabet(html).split(""))
			.sorted((o1, o2) -> {
				int res = o1.compareToIgnoreCase(o2);
				int ans = (res == 0) ? o1.compareTo(o2) : res;
				return ans;
			})
			.collect(Collectors.toList());
		List<String> numbers = Stream.of(StringUtil.regexNumber(html).split(""))
			.sorted()
			.collect(Collectors.toList());
		
		// 영어 숫자 리스트 Mix (A0a1a7BbZz)
		String mixStr = ListUtil.mixListsToString(alphabets, numbers);
		log.debug("mixStr : {}", mixStr);
		
		// 결과값 묶음 단위 내/외 값
		String quotient = StringUtil.quotient(mixStr, request.getBundle());
		String remainder = StringUtil.remainder(mixStr, request.getBundle());
		log.debug("quotient : {}", quotient);
		log.debug("remainder : {}", remainder);
		
		PrintResponse response = new PrintResponse(quotient, remainder);
		return response;
	}
	
}
