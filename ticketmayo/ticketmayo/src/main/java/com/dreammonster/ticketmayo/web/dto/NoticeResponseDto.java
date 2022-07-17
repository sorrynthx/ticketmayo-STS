package com.dreammonster.ticketmayo.web.dto;

import com.dreammonster.ticketmayo.domain.notice.Notice;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class NoticeResponseDto {
	
	private String title;
	private String content;
	
	public NoticeResponseDto(Notice entity) {
		this.title = entity.getTitle();
		this.content = entity.getContent();
	}
	
}
