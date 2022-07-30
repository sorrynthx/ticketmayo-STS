package com.dreammonster.ticketmayo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreammonster.ticketmayo.config.auth.LoginUser;
import com.dreammonster.ticketmayo.config.auth.dto.SessionUser;
import com.dreammonster.ticketmayo.service.SecondTicketService;
import com.dreammonster.ticketmayo.web.dto.OpenWaitResponseDto;
import com.dreammonster.ticketmayo.web.dto.SecondTicketAdminResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class SecondTicketController {

	private final SecondTicketService secondTicketService;

	@GetMapping("/secondTicket")
	public String secondTicket(Model model, @LoginUser SessionUser naverUser) {
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		return "secondTicket";
	}

	@ResponseBody
	@RequestMapping(value = "/secondTicket/api_v1_001", method = RequestMethod.GET)
	public List<SecondTicketAdminResponseDto> secondTicket_api_v1_001(HttpServletRequest HttpRequest,
			HttpServletResponse HttpResponse, HttpSession session, Model model) {

		List<SecondTicketAdminResponseDto> list = secondTicketService.list();

		return list;

	}

}
