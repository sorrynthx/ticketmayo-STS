package com.dreammonster.ticketmayo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dreammonster.ticketmayo.config.auth.LoginUser;
import com.dreammonster.ticketmayo.config.auth.dto.SessionUser;

@Controller
public class MuseController {
	
	@GetMapping("/muse")
	public String muse(Model model, @LoginUser SessionUser naverUser) {
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		return "html/muse";
	}
	
	@GetMapping("/muse/detail")
	public String museDetail(Model model, @LoginUser SessionUser naverUser) {
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		return "html/museDetail";
	}
}
