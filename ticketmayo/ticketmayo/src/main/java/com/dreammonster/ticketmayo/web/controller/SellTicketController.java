package com.dreammonster.ticketmayo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dreammonster.ticketmayo.config.auth.LoginUser;
import com.dreammonster.ticketmayo.config.auth.dto.SessionUser;

@Controller
public class SellTicketController {
	
	@GetMapping("/sellTicket")
	public String sellTicket(Model model, @LoginUser SessionUser naverUser) {
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		return "html/sellTicket";
	}
	
	@GetMapping("/sellTicket/apply")
	public String sellTicketApply() {
		return "html/sellTicketApply";
	}
}
