package com.dreammonster.ticketmayo.secondTicketPayment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondTikcetPaymentController {
	
	@GetMapping("/secondTicketPayment")
	public String secondTicketPayment() {
		
		return "secondTicketPayment";
	}
	
	@GetMapping("/secondTicketPayment_result")
	public String secondTicketPayment_result() {
		
		return "secondTicketPayment_result";
	}
}
