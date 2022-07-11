package com.dreammonster.ticketmayo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

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
	public int changeStatus(OpenWaitRequestDto openWaitRequestDto) {
		return openWaitRepository.changeStatus(openWaitRequestDto);
	}
	
	@Transactional
	public List<OpenWaitAdminReponseDto> finishList() {
		return openWaitRepository.finishList();
	}	
	
}
