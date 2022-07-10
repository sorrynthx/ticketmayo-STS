package com.dreammonster.ticketmayo.domain.openWait;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dreammonster.ticketmayo.domain.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class OpenWait extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String playName;
	
	@Column
	private String site;
	
	@Column
	private int qty;
	
	@Column
	private String grade;
	
	@Column
	private String siteId;
	
	@Column
	private String sitePw;
	
	@Column
	private String applyCost;
	
	@Column
	private String phone;
	
	@Column
	private String userEmail;
	
	@Column
	private String status;
	
	@Builder
	public OpenWait(String playName, String site, int qty, String grade, String siteId, String sitePw, String applyCost, String phone, String userEmail, String status) {
		
		this.playName = playName;
		this.site = site;
		this.qty = qty;
		this.grade = grade;
		this.siteId = siteId;
		this.sitePw = sitePw;
		this.applyCost = applyCost;
		this.phone = phone;
		this.userEmail = userEmail;
		this.status = status;
	}
	
}
