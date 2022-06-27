package com.dreammonster.ticketmayo.openWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dreammonster.ticketmayo.utils.ApiMethod;
import com.google.gson.Gson;

@Service
public class OpenWaitService {
	
	ApiMethod api = new ApiMethod();
	
	// 오픈예정 공연 호출.
	public List<OpenWaitDomain> list() {
		
		String apiUrl = "http://localhost:5001/api_v1/scraping1";
		
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Client-Id", "TicketMayo");
		requestHeaders.put("Client-Secret", "TicketMayoAPI2022dreammonsterKR");
		requestHeaders.put("Content-Type", "application/json");
		
		
		String responseBody = api.get(apiUrl, requestHeaders);
		
		System.out.print(responseBody);
		
		Gson gson = new Gson();
		
		List<OpenWaitDomain> list = gson.fromJson(responseBody.toString(), List.class);
		
		return list;
	}
	
	
}
