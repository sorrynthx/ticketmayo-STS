package com.dreammonster.ticketmayo.config.auth.dto;

import java.io.Serializable;

import com.dreammonster.ticketmayo.domain.naverUser.NaverUser;
import com.dreammonster.ticketmayo.domain.naverUser.Role;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
	
	private String name;
	private String email;
	private String picture;
	private Role role;
	
	public SessionUser(NaverUser naverUser) {
		this.email = naverUser.getEmail();
		this.name = naverUser.getName();
		this.picture = naverUser.getPicture();
		this.role = naverUser.getRole();
	}
}
