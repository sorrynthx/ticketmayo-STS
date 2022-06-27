package com.dreammonster.ticketmayo.openWait;

import lombok.Data;

@Data
public class OpenWaitDomain {
	
	private String type;
	private String subject;
	private String link;
	private String date;
	private int count;
	private String image;
	private String[] casting;
	private String site;
}
