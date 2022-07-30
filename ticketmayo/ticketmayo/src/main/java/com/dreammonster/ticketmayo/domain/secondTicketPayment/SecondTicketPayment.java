package com.dreammonster.ticketmayo.domain.secondTicketPayment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dreammonster.ticketmayo.domain.BaseTimeEntity;
import com.dreammonster.ticketmayo.web.dto.SecondTicketAdminRequestDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class SecondTicketPayment extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long playId;
	
	@Column(length=50)
	private String userEmail;
	
	@Column(length=10)
	private String accountOwner;
	
	@Column(length=10)
	private String bankName;
	
	@Column(length=20)
	private String phone;
	
	@Column(length=25)
	private String depositBank;
	
	@Column(length=35)
	private String depositAcct;
	
	@Column(length=10)
	private String depositOwner;
	
	@Column
	private String paymentNumber;
	
	@Builder
	public SecondTicketPayment(Long playId, String userEmail, String accountOwner, String bankName, String phone, String depositBank, String depositAcct, String depositOwner) {
		this.playId = playId;
		this.userEmail = userEmail;
		this.accountOwner = accountOwner;
		this.bankName = bankName;
		this.phone = phone;
		this.depositBank = depositBank;
		this.depositAcct = depositAcct;
		this.depositOwner = depositOwner;
		
		// 현재 날짜
		LocalDate now = LocalDate.now();  
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");        
		String formatedNow = now.format(formatter);        
		// 날짜 + 밀리세컨드: 거래번호 
		this.paymentNumber = formatedNow + System.currentTimeMillis();
		
	}
	
}
