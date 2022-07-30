package com.dreammonster.ticketmayo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dreammonster.ticketmayo.domain.secondTicket.SecondTicket;
import com.dreammonster.ticketmayo.domain.secondTicket.SecondTicketRepository;
import com.dreammonster.ticketmayo.domain.secondTicketPayment.SecondTicketPaymentRepository;
import com.dreammonster.ticketmayo.web.dto.SecondTicketPaymentRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SecondTicketPaymentService {
	
	private final SecondTicketRepository secondTicketRepository;
	private final SecondTicketPaymentRepository secondTicketPaymentRepository;

	public Map<String, Object> save(SecondTicketPaymentRequestDto secondTicketPayment) {
		
		SecondTicket secondTicket = secondTicketRepository.findById(secondTicketPayment.getPlayId())
														  .orElseThrow(() -> new IllegalArgumentException("second_ticket 테이블에서 해당 id를 찾을 수 없습니다. id=" + secondTicketPayment.getPlayId()));
		
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		if (secondTicket.getCode().equals("거래중")) {
			rtnMap.put("code", 0);
			rtnMap.put("msg", "이미 다른 사람이 거래중입니다.");
		} 
		else if (secondTicket.getCode().equals("판매완료")) {
			rtnMap.put("code", -1);
			rtnMap.put("msg", "판매가 완료된 티켓입니다.");
		} 
		else {
			// 거래상태: 판매중 -> 거래중
			secondTicket.updateCode_doing(secondTicket);
			
			// 거래 등록
			secondTicketPaymentRepository.save(secondTicketPayment.toEntity()).getId();
			
			rtnMap.put("code", 1);
			rtnMap.put("msg", "이체 확인 후 연락드리겠습니다.");
		}
		
		return rtnMap;
	}
	


}
