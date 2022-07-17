package com.dreammonster.ticketmayo.web.dto;

import com.dreammonster.ticketmayo.domain.faq.Faq;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FaqResponseDto {
	
	private String faqGroup;
	private String title;
	private String content;
	
	public FaqResponseDto(Faq entity) {
		this.faqGroup = entity.getFaqGroup();
		this.title = entity.getTitle();
		this.content = entity.getContent();
	}
	
}
