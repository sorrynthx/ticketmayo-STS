package com.dreammonster.ticketmayo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreammonster.ticketmayo.service.OpenWaitService;
import com.dreammonster.ticketmayo.web.dto.OpenWaitResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OpenWaitController {
	
	private final OpenWaitService openWaitService;
	
	@GetMapping("/openWait")
	public String openWait() {
		
		return "openWait";
	}
	
	@ResponseBody
	@RequestMapping(value = "/openWait/api_v1_001", method = RequestMethod.GET)
	public List<OpenWaitResponseDto> openWait_api_v1_001(HttpServletRequest HttpRequest, HttpServletResponse HttpResponse, HttpSession session, Model model) {
		
		// api call
		List<OpenWaitResponseDto> list = openWaitService.list();

		return list;
		
	}
	
}
