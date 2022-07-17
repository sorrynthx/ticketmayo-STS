package com.dreammonster.ticketmayo.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dreammonster.ticketmayo.domain.faq.FaqRepository;
import com.dreammonster.ticketmayo.web.dto.FaqResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FaqService {
	
	private final FaqRepository faqRepository;
	
	@Transactional
	public List<FaqResponseDto> list() {
		return faqRepository.findAllDesc().stream()
											.map(FaqResponseDto::new)			// Faq -> FaqResponseDto 
											.collect(Collectors.toList());
	}
}
