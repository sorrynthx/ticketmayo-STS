package com.dreammonster.ticketmayo.domain.secondTicket;

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
public class SecondTicket extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=120)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String poster;
	
	@Column(length=10)
	private String grade;
	
	@Column(length=30)
	private String seatInfo1;
	
	@Column(length=30)
	private String seatInfo2;
	
	@Column(length=30)
	private String seatInfo3;
	
	@Column(length=30)
	private String seatInfo4;
	
	@Column(length=12)
	private String playDay;
	
	@Column(length=6)
	private String playTime;
	
	@Column
	private int price;
	
	@Column(length=50)
	private String playLoc;
	
	@Column
	private int qty;
	
	@Column
	private int deliveryFee;
	
	@Column(length=15)
	private String payment;
	
	@Column
	private String owner;
	
	@Column
	private String actor;
	
	@Column
	private String code;
	
	@Builder
	public SecondTicket(String title, String poster, String grade, String seatInfo1, String seatInfo2, String seatInfo3, String seatInfo4, String playDay, String playTime,
			int price, String playLoc, int qty, int deliveryFee, String payment, String owner, String actor, String code) {
		this.title = title;
		this.poster = poster;
		this.grade = grade;
		this.seatInfo1 = seatInfo1;
		this.seatInfo2 = seatInfo2;
		this.seatInfo3 = seatInfo3;
		this.seatInfo4 = seatInfo4;
		this.playDay = playDay;
		this.playTime = playTime;
		this.price = price;
		this.playLoc = playLoc;
		this.qty = qty;
		this.deliveryFee = deliveryFee;
		this.payment = payment;
		this.owner = owner;
		this.actor = actor;
		this.code = code;
	}
	
	public void updateTicket(SecondTicketAdminRequestDto secondTicket) {
		
		this.title = secondTicket.getTitle();
		this.poster = secondTicket.getPoster();
		this.grade = secondTicket.getGrade();
		this.seatInfo1 = secondTicket.getSeatInfo1();
		this.seatInfo2 = secondTicket.getSeatInfo2();
		this.seatInfo3 = secondTicket.getSeatInfo3();
		this.seatInfo4 = secondTicket.getSeatInfo4();
		this.playDay = secondTicket.getPlayDay();
		this.playTime = secondTicket.getPlayTime();
		this.price = secondTicket.getPrice();
		this.playLoc = secondTicket.getPlayLoc();
		this.qty = secondTicket.getQty();
		this.deliveryFee = secondTicket.getDeliveryFee();
		this.payment = secondTicket.getPayment();
		this.owner = secondTicket.getOwner();				
		this.actor = secondTicket.getActor();
	}

	public void updateCode_doing(SecondTicket secondTicket) {
		this.code = "거래중";
	}
	
}
