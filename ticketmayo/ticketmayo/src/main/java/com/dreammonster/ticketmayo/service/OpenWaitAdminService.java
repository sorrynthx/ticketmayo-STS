package com.dreammonster.ticketmayo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dreammonster.ticketmayo.domain.openWait.OpenWait;
import com.dreammonster.ticketmayo.domain.openWait.OpenWaitRepository;
import com.dreammonster.ticketmayo.utils.ApiMethod;
import com.dreammonster.ticketmayo.web.dto.OpenWaitAdminReponseDto;
import com.dreammonster.ticketmayo.web.dto.OpenWaitRequestDto;
import com.dreammonster.ticketmayo.web.dto.OpenWaitResponseDto;
import com.dreammonster.ticketmayo.web.dto.OpenWaitResponseDto.OpenWaitResponseDtoBuilder;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OpenWaitAdminService {
	
	private final OpenWaitRepository openWaitRepository;
	
	@Transactional
	public List<OpenWaitAdminReponseDto> applyList() {
		return openWaitRepository.applyList();
	}
	
	@Transactional
	public List<OpenWaitAdminReponseDto> finishList() {
		return openWaitRepository.finishList();
	}
	
	@Transactional
	public Long updateStatus(OpenWaitRequestDto openWaitRequestDto) {
		
		OpenWait dto = openWaitRepository.findById(openWaitRequestDto.getId())
										 .orElseThrow(() -> new IllegalArgumentException("open_wait 테이블에서 해당 id를 찾을 수 없습니다. id=" + openWaitRequestDto.getId()));
		
		dto.updateStatus(openWaitRequestDto.getApplyCost(), openWaitRequestDto.getStatus());
		
		return openWaitRequestDto.getId();
	}	
	
}
