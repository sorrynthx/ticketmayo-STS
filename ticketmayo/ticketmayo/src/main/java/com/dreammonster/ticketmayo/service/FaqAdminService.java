package com.dreammonster.ticketmayo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dreammonster.ticketmayo.domain.faq.Faq;
import com.dreammonster.ticketmayo.domain.faq.FaqRepository;
import com.dreammonster.ticketmayo.web.dto.FaqAdminRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FaqAdminService {
	
	private final FaqRepository faqRepository;
	
	@Transactional
	public Long save(FaqAdminRequestDto faqAdminRequestDto) {
		return faqRepository.save(faqAdminRequestDto.toEntity()).getId();
	}
	
	@Transactional
	public List<Faq> list() {
		return faqRepository.findAll();
	}
	
	@Transactional
	public Long faqAdminUpdate(FaqAdminRequestDto faq) {
		
		Faq dto = faqRepository.findById(faq.getId())
				 .orElseThrow(() -> new IllegalArgumentException("faq 테이블에서 해당 id를 찾을 수 없습니다. faqAdminUpdate id=" + faq.getId()));

		dto.update(faq.getFaqGroup(), faq.getTitle(), faq.getContent());
		
		return faq.getId();
	}
	
	@Transactional
	public Long delete(FaqAdminRequestDto faq) {
		
		Faq dto = faqRepository.findById(faq.getId())
				 .orElseThrow(() -> new IllegalArgumentException("faq 테이블에서 해당 id를 찾을 수 없습니다. delete id=" + faq.getId()));
		
		faqRepository.deleteById(dto.getId());
		
		return faq.getId();
	}
}
