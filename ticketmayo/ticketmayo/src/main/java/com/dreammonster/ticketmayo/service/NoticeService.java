package com.dreammonster.ticketmayo.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dreammonster.ticketmayo.domain.notice.NoticeRepository;
import com.dreammonster.ticketmayo.web.dto.NoticeResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeService {
	
	private final NoticeRepository noticeRepository;
	
	@Transactional
	public List<NoticeResponseDto> list() {
		return noticeRepository.findAllDesc().stream()
											.map(NoticeResponseDto::new)			// Notice -> NoticeResponseDto 
											.collect(Collectors.toList());
	}
}
