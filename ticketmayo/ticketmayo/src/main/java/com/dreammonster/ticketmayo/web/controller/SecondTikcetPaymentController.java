package com.dreammonster.ticketmayo.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreammonster.ticketmayo.config.auth.LoginUser;
import com.dreammonster.ticketmayo.config.auth.dto.SessionUser;
import com.dreammonster.ticketmayo.service.SecondTicketPaymentService;
import com.dreammonster.ticketmayo.service.SecondTicketService;
import com.dreammonster.ticketmayo.web.dto.SecondTicketPaymentRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SecondTikcetPaymentController {
	
	private final SecondTicketService secondTicketService;
	private final SecondTicketPaymentService secondTicketPaymentService;
	
	@PostMapping("/secondTicketPayment")
	public String secondTicketPayment(Model model, @RequestParam Long id, @LoginUser SessionUser naverUser) {
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		
		model.addAttribute("secondTicket", secondTicketService.secondTicket4Payment(id));
		return "secondTicketPayment";
	}
	
	@ResponseBody
	@PostMapping("/secondTicketPayment/api_v1_001")
	public Map<String, Object> secondTicketPayment_api_v1_001(@RequestBody SecondTicketPaymentRequestDto secondTicketPayment, HttpServletRequest HttpRequest, HttpServletResponse HttpResponse, HttpSession session, Model model) {

		return secondTicketPaymentService.save(secondTicketPayment);
		
	}
	
	@GetMapping("/secondTicketPayment_result")
	public String secondTicketPayment_result() {
		
		return "secondTicketPayment_result";
	}
}
