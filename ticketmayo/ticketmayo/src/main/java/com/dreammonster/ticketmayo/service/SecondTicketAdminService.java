package com.dreammonster.ticketmayo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.json.XML;
import org.springframework.stereotype.Service;

import com.dreammonster.ticketmayo.domain.secondTicket.SecondTicket;
import com.dreammonster.ticketmayo.domain.secondTicket.SecondTicketRepository;
import com.dreammonster.ticketmayo.utils.ApiMethod;
import com.dreammonster.ticketmayo.web.dto.SecondTicketAdminRequestDto;
import com.dreammonster.ticketmayo.web.dto.SecondTicketAdminResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SecondTicketAdminService {
	
	private final ApiMethod api;
	private final SecondTicketRepository secondTicketRepository;
	
	public String list() {
		
		String apiUrl = "http://www.kopis.or.kr/openApi/restful/pblprfr?service=7f405aa8d569443689dbdb21e15be4d3&stdate=20220101&"
														+ "eddate=20220718&rows=1000&cpage=1&shcate=AAAB&signgucode=11&prfstate=02";
		
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Client-Id", "TicketMayo");
		requestHeaders.put("Client-Secret", "TicketMayoAPI2022dreammonsterKR");
		requestHeaders.put("Content-Type", "application/json");
		
		
		String xml = api.get(apiUrl, requestHeaders);
		org.json.JSONObject jObject = XML.toJSONObject(xml);
		ObjectMapper mapper = new ObjectMapper();
	    mapper.enable(SerializationFeature.INDENT_OUTPUT);
	    Object json = null;
		
	    String output = null;
	    
	    try {
			json = mapper.readValue(jObject.toString(), Object.class);
			output = mapper.writeValueAsString(json);
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return output;
	}
	
	@Transactional
	public Long save(SecondTicketAdminRequestDto secondTicket) {
		
		return secondTicketRepository.save(secondTicket.toEntity()).getId();
	}
	
	@Transactional
	public List<SecondTicketAdminResponseDto> list2() {
		
		return secondTicketRepository.list2();
	}
	
	@Transactional
	public Long updateTicket(SecondTicketAdminRequestDto secondTicket) {
		
		SecondTicket dto = secondTicketRepository.findById(secondTicket.getId())
												 .orElseThrow(() -> new IllegalArgumentException("second_ticket 테이블에서 해당 id를 찾을 수 없습니다. id=" + secondTicket.getId()));
		
		dto.updateTicket(secondTicket);
		
		return secondTicket.getId();
	}
	
	@Transactional
	public Long deleteTicket(SecondTicketAdminRequestDto secondTicket) {
		
		SecondTicket dto = secondTicketRepository.findById(secondTicket.getId())
				 .orElseThrow(() -> new IllegalArgumentException("second_ticket 테이블에서 해당 id를 찾을 수 없습니다. id=" + secondTicket.getId()));
		
		secondTicketRepository.deleteById(dto.getId());
		
		return secondTicket.getId();
	}

}
