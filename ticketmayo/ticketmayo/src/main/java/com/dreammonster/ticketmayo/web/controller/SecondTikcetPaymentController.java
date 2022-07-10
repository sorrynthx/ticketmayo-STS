package com.dreammonster.ticketmayo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dreammonster.ticketmayo.config.auth.LoginUser;
import com.dreammonster.ticketmayo.config.auth.dto.SessionUser;

@Controller
public class SecondTikcetPaymentController {
	
	@GetMapping("/secondTicketPayment")
	public String secondTicketPayment(Model model, @LoginUser SessionUser naverUser) {
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		return "secondTicketPayment";
	}
	
	@GetMapping("/secondTicketPayment_result")
	public String secondTicketPayment_result() {
		
		return "secondTicketPayment_result";
	}
}
