package com.dreammonster.ticketmayo.secondTicket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondTicketController {
	
	@GetMapping("/secondTicket")
	public String secondTicket() {
		
		return "secondTicket";
	}
	
}
