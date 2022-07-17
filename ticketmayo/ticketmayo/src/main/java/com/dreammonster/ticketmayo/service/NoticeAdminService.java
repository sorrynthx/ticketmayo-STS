package com.dreammonster.ticketmayo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dreammonster.ticketmayo.domain.notice.Notice;
import com.dreammonster.ticketmayo.domain.notice.NoticeRepository;
import com.dreammonster.ticketmayo.web.dto.NoticeAdminRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeAdminService {
	
	private final NoticeRepository noticeRepository;
	
	@Transactional
	public Long save(NoticeAdminRequestDto noticeAdminRequestDto) {
		return noticeRepository.save(noticeAdminRequestDto.toEntity()).getId();
	}
	
	@Transactional
	public List<Notice> list() {
		return noticeRepository.findAll();
	}
	
	@Transactional
	public Long noticeAdminUpdate(NoticeAdminRequestDto notice) {
		
		Notice dto = noticeRepository.findById(notice.getId())
				 .orElseThrow(() -> new IllegalArgumentException("notice 테이블에서 해당 id를 찾을 수 없습니다. noticeAdminUpdate id=" + notice.getId()));

		dto.update( notice.getTitle(), notice.getContent());
		
		return notice.getId();
	}
	
	@Transactional
	public Long delete(NoticeAdminRequestDto notice) {
		
		Notice dto = noticeRepository.findById(notice.getId())
				 .orElseThrow(() -> new IllegalArgumentException("notice 테이블에서 해당 id를 찾을 수 없습니다. delete id=" + notice.getId()));
		
		noticeRepository.deleteById(dto.getId());
		
		return notice.getId();
	}

}
