package com.dreammonster.ticketmayo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreammonster.ticketmayo.config.auth.LoginUser;
import com.dreammonster.ticketmayo.config.auth.dto.SessionUser;
import com.dreammonster.ticketmayo.service.FaqService;
import com.dreammonster.ticketmayo.web.dto.FaqResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class FaqController {
	
	private final FaqService faqService;
	
	@GetMapping("/faq")
	public String faq(Model model, @LoginUser SessionUser naverUser) {
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		return "html/faq";
	}
	
	@ResponseBody
	@PostMapping("/faq/api_v1_001")
	public List<FaqResponseDto> faq_api_v1_001(HttpServletRequest HttpRequest, HttpServletResponse HttpResponse, HttpSession session, Model model) {
		
		List<FaqResponseDto> list = faqService.list();
		
		return list;
		
	}
}
