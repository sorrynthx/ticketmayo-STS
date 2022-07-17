package com.dreammonster.ticketmayo.domain.openWait;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dreammonster.ticketmayo.domain.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(value={"modified_date"}, allowGetters=true)
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
	private int applyCost;
	
	@Column
	private String phone;
	
	@Column
	private String userEmail;
	
	@Column
	private String status;
	
	@Column
	private String birth;
	
	@Column
	private String hopeSeat;
	
	@Column
	private String bankName;
	
	@Column
	private String refundAccount;
	
	@Column
	private String accountOwner;
	
	@Column
	private String hopeDay;
	
	@Column
	private String hopeTime;
	
	@Column
	private String depositBank;
	
	@Column
	private String depositAcct;
	
	@Column
	private String depositOwner;
	
	@Builder
	public OpenWait(String playName, String site, int qty, String grade, String siteId, String sitePw, int applyCost, String phone, String userEmail, String status, String birth, String hopeSeat, String bankName, String refundAccount, String accountOwner, String hopeDay, String hopeTime, String depositBank, String depositAcct, String depositOwner) {
		
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
	
	public void updateStatus(int applyCost, String status) {
		this.applyCost = applyCost;
		this.status = status;
	}
}
