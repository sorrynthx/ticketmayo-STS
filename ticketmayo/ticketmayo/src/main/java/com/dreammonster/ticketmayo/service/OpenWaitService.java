package com.dreammonster.ticketmayo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dreammonster.ticketmayo.utils.ApiMethod;
import com.dreammonster.ticketmayo.web.dto.OpenWaitResponseDto;
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
		
		
		String responseBody = "";
		try {
			responseBody = api.get(apiUrl, requestHeaders);
			
			System.out.print( "-> "+ responseBody);
			
			Gson gson = new Gson();
			
			List<OpenWaitResponseDto> list = gson.fromJson(responseBody.toString(), List.class);
			
			return list;
			
		} catch (Exception e) {
			System.out.println("--> " + e.getMessage());
			List<OpenWaitResponseDto> list = new ArrayList<OpenWaitResponseDto>();
			return list;
		}
	}
	
	
}
