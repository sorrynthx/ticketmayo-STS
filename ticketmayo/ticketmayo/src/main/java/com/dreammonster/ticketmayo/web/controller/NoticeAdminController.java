package com.dreammonster.ticketmayo.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreammonster.ticketmayo.config.auth.LoginUser;
import com.dreammonster.ticketmayo.config.auth.dto.SessionUser;
import com.dreammonster.ticketmayo.domain.faq.Faq;
import com.dreammonster.ticketmayo.domain.naverUser.Role;
import com.dreammonster.ticketmayo.domain.notice.Notice;
import com.dreammonster.ticketmayo.service.FaqAdminService;
import com.dreammonster.ticketmayo.service.NoticeAdminService;
import com.dreammonster.ticketmayo.service.OpenWaitService;
import com.dreammonster.ticketmayo.web.dto.FaqAdminRequestDto;
import com.dreammonster.ticketmayo.web.dto.FaqAdminResponseDto;
import com.dreammonster.ticketmayo.web.dto.NoticeAdminRequestDto;
import com.dreammonster.ticketmayo.web.dto.OpenWaitAdminReponseDto;
import com.dreammonster.ticketmayo.web.dto.OpenWaitRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeAdminController {
	
	private final NoticeAdminService noticeAdminService;
	
	@GetMapping("/noticeAdmin")
	public String noticeAdmin(Model model, @LoginUser SessionUser naverUser) {
		// 로그인 정보
		if (naverUser != null) {
			
			// 관리자 아닌 경우
			if (naverUser.getRole() != Role.ADMIN) return "error";
			
			// 관리자
			else {
				model.addAttribute("naverUser", naverUser);
				return "noticeAdmin";
			}
			
		} else return "error";
	}
	
	@ResponseBody
	@PostMapping("/notice/admin/api_v1_001")
	public Long noticeAdminSave(@RequestBody NoticeAdminRequestDto notice) {
		
		return noticeAdminService.save(notice);
	}
	
	@ResponseBody
	@PostMapping("/notice/admin/api_v1_002")
	public List<Notice> noticeAdminList() {
		
		return noticeAdminService.list();
	}
	
	@ResponseBody
	@PostMapping("/notice/admin/api_v1_003")
	public Long noticeAdminUpdate(@RequestBody NoticeAdminRequestDto notice) {
		
		return noticeAdminService.noticeAdminUpdate(notice);
	}
	
	@ResponseBody
	@PostMapping("/notice/admin/api_v1_004")
	public Long noticeAdminDelete(@RequestBody NoticeAdminRequestDto notice) {
		
		return noticeAdminService.delete(notice);
	}
}
