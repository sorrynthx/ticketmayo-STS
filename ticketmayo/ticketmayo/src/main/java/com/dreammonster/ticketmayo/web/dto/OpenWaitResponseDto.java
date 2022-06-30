package com.dreammonster.ticketmayo.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OpenWaitResponseDto {
	
	private String type;
	private String subject;
	private String link;
	private String date;
	private int count;
	private String image;
	private String[] casting;
	private String site;
	
	private String errCode;
	
	@Builder												
	public OpenWaitResponseDto(String errCode) {
		this.errCode = errCode;
	}
}
