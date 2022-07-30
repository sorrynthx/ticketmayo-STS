package com.dreammonster.ticketmayo.web.dto;


import com.dreammonster.ticketmayo.domain.secondTicket.SecondTicket;

import lombok.Getter;

@Getter
public class SecondTicketAdminRequestDto {
	
	private Long id;
	private String title;
	private String poster;
	private String grade;
	private String seatInfo1;
	private String seatInfo2;
	private String seatInfo3;
	private String seatInfo4;
	private String playDay;
	private String playTime;
	private int price;
	private String playLoc;
	private int qty;
	private int deliveryFee;
	private String payment;
	private String owner;
	private String actor;
	private String code;
	
	
	public SecondTicket toEntity() {
		return SecondTicket.builder()
						   .title(title)
						   .poster(poster)
						   .grade(grade)
						   .seatInfo1(seatInfo1)
						   .seatInfo2(seatInfo2)
						   .seatInfo3(seatInfo3)
						   .seatInfo4(seatInfo4)
						   .playDay(playDay)
						   .playTime(playTime)
						   .price(price)
						   .playLoc(playLoc)
						   .qty(qty)
						   .deliveryFee(deliveryFee)
						   .payment(payment)
						   .owner(owner)
						   .actor(actor)
						   .code("판매중")
						   .build();
	}
}
