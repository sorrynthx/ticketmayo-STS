package com.dreammonster.ticketmayo.web.dto;

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
	private String applyCost;
	private String phone;
	private String userEmail;
	private String birth;
	private String hopeSeat;
	private String status;
	
	@Builder
	public OpenWaitRequestDto(String playName, String site, int qty, String grade, String siteId, String sitePw, String applyCost, String phone, String userEmail, String birth, String hopeSeat) {
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
						.build();
	}
}
