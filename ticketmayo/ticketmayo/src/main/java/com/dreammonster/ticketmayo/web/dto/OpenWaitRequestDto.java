package com.dreammonster.ticketmayo.web.dto;

import javax.persistence.Column;

import com.dreammonster.ticketmayo.domain.openWait.OpenWait;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class OpenWaitRequestDto {
	
	private Long id;
	private String playName;
	private String site;
	private int qty;
	private String grade;
	private String siteId;
	private String sitePw;
	private int applyCost;
	private String phone;
	private String userEmail;
	private String birth;
	private String hopeSeat;
	private String status;
	private String bankName;
	private String refundAccount;
	private String accountOwner;
	private String hopeDay;
	private String hopeTime;
	private String depositBank;
	private String depositAcct;
	private String depositOwner;
	
	@Builder
	public OpenWaitRequestDto(String playName, String site, int qty, String grade, String siteId, String sitePw, int applyCost, String phone, String userEmail, String birth, String hopeSeat, String bankName, String refundAccount, String accountOwner, String hopeDay, String hopeTime, String depositBank, String depositAcct, String depositOwner) {
		this.playName = playName;
		this.site = site;
		this.qty = qty;
		this.grade = grade;
		this.siteId = siteId;
		this.sitePw = sitePw;
		this.applyCost = applyCost;
		this.phone = phone;
		this.userEmail = userEmail;
		this.birth = birth;
		this.hopeSeat = hopeSeat;
		this.bankName = bankName;
		this.refundAccount = refundAccount;
		this.accountOwner = accountOwner;
		this.hopeDay = hopeDay;
		this.hopeTime = hopeTime;
		this.depositAcct = depositAcct;
		this.depositBank = depositBank;
		this.depositOwner = depositOwner;
	}
	
	public OpenWait toEntity() {
		return OpenWait.builder()
						.playName(playName)
						.site(site)
						.qty(qty)
						.grade(grade)
						.siteId(siteId)
						.sitePw(sitePw)
						.applyCost(applyCost)
						.phone(phone)
						.userEmail(userEmail)
						.status("신청")
						.birth(birth)
						.hopeSeat(hopeSeat)
						.bankName(bankName)
						.refundAccount(refundAccount)
						.accountOwner(accountOwner)
						.hopeDay(hopeDay)
						.hopeTime(hopeTime)
						.depositAcct(depositAcct)
						.depositBank(depositBank)
						.depositOwner(depositOwner)
						.build();
	}
}
