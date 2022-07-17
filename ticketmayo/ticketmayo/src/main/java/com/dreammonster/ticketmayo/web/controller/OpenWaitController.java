package com.dreammonster.ticketmayo.web.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreammonster.ticketmayo.config.auth.LoginUser;
import com.dreammonster.ticketmayo.config.auth.dto.SessionUser;
import com.dreammonster.ticketmayo.domain.openWait.OpenWait;
import com.dreammonster.ticketmayo.service.OpenWaitService;
import com.dreammonster.ticketmayo.web.dto.OpenWaitRequestDto;
import com.dreammonster.ticketmayo.web.dto.OpenWaitResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OpenWaitController {
	
	private final OpenWaitService openWaitService;
	
	@PostMapping("/openWaitWelcome")
	public String openWaitWelcome(@RequestParam String subject, @RequestParam String site, Model model, @LoginUser SessionUser naverUser) {
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		model.addAttribute("subject", subject);
		model.addAttribute("site", site);
		return "openWaitWelcome";
	}
	
	@GetMapping("/openWait")
	public String openWait(Model model, @LoginUser SessionUser naverUser) {
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		return "openWait";
	}
	
	@ResponseBody
	@RequestMapping(value = "/openWait/api_v1_001", method = RequestMethod.GET)
	public List<OpenWaitResponseDto> openWait_api_v1_001(HttpServletRequest HttpRequest, HttpServletResponse HttpResponse, HttpSession session, Model model) {
		
		// api call
		List<OpenWaitResponseDto> list = openWaitService.list();

		return list;
		
	}
	
	@PostMapping("/openWaitBuyMusical")
	public String openWaitBuyMusical(@RequestParam String subject, @RequestParam String site, Model model, @LoginUser SessionUser naverUser) {
		
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		
		model.addAttribute("subject", subject);
		model.addAttribute("site", site);
		return "openWaitBuy";
	}
	
	@ResponseBody
	@PostMapping("/openWait/api_v1_002")
	public Long openWaitSave(@RequestBody OpenWaitRequestDto openWait) {
		
		int cnt = openWaitService.findByUserEmailAndPlayName(openWait); 
		
		if (cnt != 0) return -1L; 
		else return openWaitService.save(openWait);
	}
	
	@PostMapping("/openWaitInvoice")
	public String openWaitInvoice(@RequestParam Long reqId, Model model, @LoginUser SessionUser naverUser) {
		
		if (naverUser != null) {
			model.addAttribute("naverUser", naverUser);
		}
		
		Optional<OpenWait> owOptinal = openWaitService.findById(reqId);
		
		owOptinal.ifPresent(ow -> {
		    if (ow.getId() > -1) {
		    	model.addAttribute("ow", ow);
		    	model.addAttribute("owCheck", true);
		    } else {
		    	model.addAttribute("owCheck", false);
		    }
		});
		
		return "openWaitInvoice";
	}
	
}
