package com.dreammonster.ticketmayo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dreammonster.ticketmayo.config.auth.LoginUser;
import com.dreammonster.ticketmayo.config.auth.dto.SessionUser;

@Controller
public class CommunityController {
	
	@GetMapping("/community")
	public String community(Model model, @LoginUser SessionUser naverUser) {
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		return "community";
	}
	
	@GetMapping("/community_muse")
	public String communityMuse(Model model, @LoginUser SessionUser naverUser) {
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		return "communityMuse";
	}
}
