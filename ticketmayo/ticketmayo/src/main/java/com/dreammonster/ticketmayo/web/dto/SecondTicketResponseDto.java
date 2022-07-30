package com.dreammonster.ticketmayo.web.dto;

import com.dreammonster.ticketmayo.domain.secondTicket.SecondTicket;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SecondTicketResponseDto {
	
	private Long id;
	private String title;
	private String playDay;
	private String playTime;
	private String playLoc;
	private String grade;
	private String seatInfo1;
	private String seatInfo2;
	private String seatInfo3;
	private int qty;
	private int price;
	private int deliveryFee;
	private String owner;
	
	private int subPrice;
	private int totalPrice;
	private String ownerSecured;
	
	@Builder
	public SecondTicketResponseDto(SecondTicket entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.playDay = entity.getPlayDay();
		this.playTime = entity.getPlayTime();
		this.playLoc = entity.getPlayLoc();
		this.grade = entity.getGrade();
		this.seatInfo1 = entity.getSeatInfo1();
		this.seatInfo2 = entity.getSeatInfo2();
		this.seatInfo3 = entity.getSeatInfo3();
		this.qty = entity.getQty();
		this.deliveryFee = entity.getDeliveryFee();
		this.price = entity.getPrice();
		this.owner = entity.getOwner();
		
		this.subPrice = entity.getQty() * entity.getPrice();
		this.totalPrice = entity.getQty() * entity.getPrice() + entity.getDeliveryFee();
		
		String[] ownerSecuredArr = entity.getOwner().split("@");
		this.ownerSecured = ownerSecuredArr[0].substring(0,3) + "******" + '@' + "naver.com";
	}
}
