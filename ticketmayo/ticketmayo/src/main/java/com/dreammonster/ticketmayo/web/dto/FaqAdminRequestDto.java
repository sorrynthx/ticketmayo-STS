package com.dreammonster.ticketmayo.web.dto;

import javax.persistence.Column;

import com.dreammonster.ticketmayo.domain.faq.Faq;
import com.dreammonster.ticketmayo.domain.openWait.OpenWait;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FaqAdminRequestDto {
	
	private Long id;
	private String faqGroup;
	private String title;
	private String content;
	
	
	@Builder
	public FaqAdminRequestDto(String faqGroup, String title, String content) {
		this.faqGroup = faqGroup;
		this.title = title;
		this.content = content;
	}
	
	public Faq toEntity() {
		return Faq.builder()
						.faqGroup(faqGroup)
						.title(title)
						.content(content)
						.build();
	}
}
