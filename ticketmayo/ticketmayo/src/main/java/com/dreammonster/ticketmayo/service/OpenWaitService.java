package com.dreammonster.ticketmayo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dreammonster.ticketmayo.utils.ApiMethod;
import com.dreammonster.ticketmayo.web.dto.OpenWaitResponseDto;
import com.dreammonster.ticketmayo.web.dto.OpenWaitResponseDto.OpenWaitResponseDtoBuilder;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OpenWaitService {
	
	private final ApiMethod api;
	
	// 오픈예정 공연 호출.
	public List<OpenWaitResponseDto> list() {
		
		String apiUrl = "http://localhost:5001/api_v1/scraping1";
		
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Client-Id", "TicketMayo");
		requestHeaders.put("Client-Secret", "TicketMayoAPI2022dreammonsterKR");
		requestHeaders.put("Content-Type", "application/json");
		
		List<OpenWaitResponseDto> list = new ArrayList<OpenWaitResponseDto>();
		String responseBody = "";
		
		try {
			// api get방식 호출
			responseBody = api.get(apiUrl, requestHeaders);
			
			// api error code: "-1"
			if (responseBody.equals("-1")) {
				list.add(0, sendErrCode(responseBody));
				return list;
			}
			
			// api success : JSON
			Gson gson = new Gson();
			list = gson.fromJson(responseBody.toString(), List.class);
			return list;
			
		} catch (Exception e) {
			System.out.println("오픈예정 공연 호출 에러 --> " + e.getMessage());
			list.add(0, sendErrCode("-1"));
			return list;
		}
	}
	
	public OpenWaitResponseDto sendErrCode(String code) {
		return new OpenWaitResponseDto(code);
	}
	
}
