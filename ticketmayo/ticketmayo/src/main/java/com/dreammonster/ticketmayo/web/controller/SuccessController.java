package com.dreammonster.ticketmayo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuccessController {
	
	@GetMapping("/success")
	public String index() {
		return "html/success";
	}
	
}
