package com.dreammonster.ticketmayo.web.dto;

import com.dreammonster.ticketmayo.domain.notice.Notice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class NoticeAdminRequestDto {
	
	private Long id;
	private String title;
	private String content;
	
	
	@Builder
	public NoticeAdminRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public Notice toEntity() {
		return Notice.builder()
						.title(title)
						.content(content)
						.build();
	}
}
