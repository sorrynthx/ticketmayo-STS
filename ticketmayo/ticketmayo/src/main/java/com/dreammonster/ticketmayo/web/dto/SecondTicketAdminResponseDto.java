package com.dreammonster.ticketmayo.web.dto;

public interface SecondTicketAdminResponseDto {
	
	Long getId();
	String getTitle();
	String getPoster();
	String getGrade();
	String getSeat_info1();
	String getSeat_info2();
	String getSeat_info3();
	String getSeat_info4();
	String getPlay_day();
	String getPlay_time();
	Integer getPrice();
	String getPlay_loc();
	Integer getQty();
	Integer getDelivery_fee();
	String getPayment();
	String getOwner();
	String getActor();
	String getCode();
	
	String getCreated_date();
}
