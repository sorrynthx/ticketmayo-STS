package com.dreammonster.ticketmayo.web.dto;

import com.dreammonster.ticketmayo.domain.faq.Faq;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class NoticeAdminResponseDto {
	
	private String title;
	private String content;
	
	
	@Builder
	public NoticeAdminResponseDto( String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public Faq toEntity() {
		return Faq.builder()
						.title(title)
						.content(content)
						.build();
	}
}
