package com.example.demo.global.service;

import com.example.demo.global.dto.ApiRequest;

public interface ValidService {
	
	/**
	 * 유효성 체크
	 * 
	 * @param apiRequest
	 * @return
	 */
	void valid(ApiRequest apiRequest);

}
