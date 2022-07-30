package com.dreammonster.ticketmayo.web.dto;

import com.dreammonster.ticketmayo.domain.secondTicketPayment.SecondTicketPayment;

import lombok.Getter;

@Getter
public class SecondTicketPaymentRequestDto {
	
	private Long id;
	private Long playId;
	private String userEmail;
	private String accountOwner;
	private String bankName;
	private String phone;
	private String depositBank;
	private String depositAcct;
	private String depositOwner;
	
	public SecondTicketPayment toEntity() {
		return SecondTicketPayment.builder()
						   .playId(playId)
						   .userEmail(userEmail)
						   .accountOwner(accountOwner)
						   .bankName(bankName)
						   .phone(phone)
						   .depositBank(depositBank)
						   .depositAcct(depositAcct)
						   .depositOwner(depositOwner)
						   .build();
	}
}
