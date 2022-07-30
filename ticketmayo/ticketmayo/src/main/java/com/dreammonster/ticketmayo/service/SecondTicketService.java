package com.dreammonster.ticketmayo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dreammonster.ticketmayo.domain.secondTicket.SecondTicket;
import com.dreammonster.ticketmayo.domain.secondTicket.SecondTicketRepository;
import com.dreammonster.ticketmayo.web.dto.SecondTicketAdminResponseDto;
import com.dreammonster.ticketmayo.web.dto.SecondTicketResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SecondTicketService {
	
	private final SecondTicketRepository secondTicketRepository;
	
	
	@Transactional
	public List<SecondTicketAdminResponseDto> list() {
		
		return secondTicketRepository.listSecured();
	}

	@Transactional
	public SecondTicketResponseDto secondTicket4Payment(Long id) {
		
		SecondTicket secondTicket = secondTicketRepository.findById(id)
														  .orElseThrow(() -> new IllegalArgumentException("second_ticket 테이블에서 해당 id를 찾을 수 없습니다. id="+id));
		return new SecondTicketResponseDto(secondTicket);
	}

}
