package com.dreammonster.ticketmayo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ComingSoonController {
	
	@GetMapping("/comingsoon")
	public String comingsoon() {
		return "html/comingsoon";
	}
	
	@GetMapping("/comingsoon/apply")
	public String comingsoonApply() {
		return "html/comingsoonApply";
	}
	
}
