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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreammonster.ticketmayo.config.auth.LoginUser;
import com.dreammonster.ticketmayo.config.auth.dto.SessionUser;
import com.dreammonster.ticketmayo.domain.naverUser.Role;
import com.dreammonster.ticketmayo.service.OpenWaitAdminService;
import com.dreammonster.ticketmayo.service.OpenWaitService;
import com.dreammonster.ticketmayo.web.dto.OpenWaitAdminReponseDto;
import com.dreammonster.ticketmayo.web.dto.OpenWaitRequestDto;
import com.dreammonster.ticketmayo.web.dto.OpenWaitResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OpenWaitAdminController {
	
	private final OpenWaitAdminService openWaitAdminService;
	
	@GetMapping("/openWaitAdmin")
	public String openWaitAdmin(Model model, @LoginUser SessionUser naverUser) {
		
		// 로그인 정보
		if (naverUser != null) {
			
			// 관리자 아닌 경우
			if (naverUser.getRole() != Role.ADMIN) return "error";
			
			// 관리자
			else {
				model.addAttribute("naverUser", naverUser);
				return "openWaitAdmin";
			}
			
		} else return "error";
	}
	
	@ResponseBody
	@PostMapping("/openWait/admin/api_v1_001")
	public List<OpenWaitAdminReponseDto> openWaitAdminApplyList() {
		
		return openWaitAdminService.applyList();
	}
	
}
