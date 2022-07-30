package com.dreammonster.ticketmayo.web.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreammonster.ticketmayo.config.auth.LoginUser;
import com.dreammonster.ticketmayo.config.auth.dto.SessionUser;
import com.dreammonster.ticketmayo.domain.naverUser.Role;
import com.dreammonster.ticketmayo.service.SecondTicketAdminService;
import com.dreammonster.ticketmayo.web.dto.SecondTicketAdminRequestDto;
import com.dreammonster.ticketmayo.web.dto.SecondTicketAdminResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SecondTicketAdminController {
	
	private final SecondTicketAdminService secondTicketAdminService;
	
	@GetMapping("/secondTicketAdmin")
	public String secondTicketAdmin(Model model, @LoginUser SessionUser naverUser) {
		// 로그인 정보
		if (naverUser != null) {
			
			// 관리자 아닌 경우
			if (naverUser.getRole() != Role.ADMIN) return "error";
			
			// 관리자
			else {
				model.addAttribute("naverUser", naverUser);
				return "secondTicketAdmin";
			}
			
		} else return "error";
	}
	
	@ResponseBody
	@RequestMapping(value = "/secondTicket/admin/api_v1_001", method = RequestMethod.GET)
	public String secondTicketAdmin_api_v1_001(HttpServletRequest HttpRequest, HttpServletResponse HttpResponse, HttpSession session, Model model) {
		
		// api call
		String result = secondTicketAdminService.list();

		return result;
		
	}
	
	@ResponseBody
	@PostMapping("/secondTicket/admin/api_v1_002")
	public Long secondTicketAdmin_api_v1_002(@RequestBody SecondTicketAdminRequestDto secondTicket) {

		return secondTicketAdminService.save(secondTicket);
		
	}
	
	@ResponseBody
	@GetMapping("/secondTicket/admin/api_v1_003")
	public List<SecondTicketAdminResponseDto> secondTicketAdmin_api_v1_003(HttpServletRequest HttpRequest, HttpServletResponse HttpResponse, HttpSession session, Model model) {
		
		// api call
		List<SecondTicketAdminResponseDto> result = secondTicketAdminService.list2();

		return result;
		
	}
	
	@ResponseBody
	@PostMapping("/secondTicket/admin/api_v1_004")
	public Long secondTicketAdmin_api_v1_004(@RequestBody SecondTicketAdminRequestDto secondTicket) {
		
		return secondTicketAdminService.updateTicket(secondTicket);
	}
	
	@ResponseBody
	@PostMapping("/secondTicket/admin/api_v1_005")
	public Long secondTicketAdmin_api_v1_005(@RequestBody SecondTicketAdminRequestDto secondTicket) {
		
		return secondTicketAdminService.deleteTicket(secondTicket);
	}
}
