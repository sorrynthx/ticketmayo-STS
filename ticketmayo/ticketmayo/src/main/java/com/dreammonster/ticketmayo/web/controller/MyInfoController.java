package com.dreammonster.ticketmayo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dreammonster.ticketmayo.config.auth.LoginUser;
import com.dreammonster.ticketmayo.config.auth.dto.SessionUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MyInfoController {
	
	//private final OpenWaitService openWaitService;
	
	@GetMapping("/myInfo")
	public String myInfo(Model model, @LoginUser SessionUser naverUser) {
		
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		
		return "html/myInfo";
	}
	
}
