package com.dreammonster.ticketmayo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreammonster.ticketmayo.service.OpenWaitAdminService;
import com.dreammonster.ticketmayo.service.OpenWaitService;
import com.dreammonster.ticketmayo.web.dto.OpenWaitResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OpenWaitAdminController {
	
	private final OpenWaitAdminService openWaitAdminService;
	
	@GetMapping("/openWaitAdmin")
	public String openWaitAdmin() {
		
		return "openWaitAdmin";
	}
	
	
	
}
