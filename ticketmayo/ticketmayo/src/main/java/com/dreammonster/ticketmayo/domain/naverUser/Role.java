package com.dreammonster.ticketmayo.domain.naverUser;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
	
	GUEST("ROLE_GUEST", "손님"),
	USER("ROLE_USER", "회원"),
	ADMIN("ROLE_ADMIN", "관리자");
	
	private final String key;
	private final String title;
}
