package com.dreammonster.ticketmayo.config.auth.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.dreammonster.ticketmayo.domain.BaseTimeEntity;
import com.dreammonster.ticketmayo.domain.naverUser.NaverUser;
import com.dreammonster.ticketmayo.domain.naverUser.Role;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes extends BaseTimeEntity {
	private Map<String, Object> attributes;
	private String nameAttributeKey;
	private String name;
	private String email;
	private String picture;
	
	@Builder
	public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.name = name;
		this.email = email;
		this.picture = picture;
	}
	
	public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
		return ofNaver("id", attributes);
		
	}
	
	private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
		
		Map<String, Object> response = (Map<String, Object>) attributes.get("response");
		
		return OAuthAttributes.builder()
				.name((String) response.get("name"))
				.email((String) response.get("email"))
				.picture((String) response.get("profile_image"))
				.attributes(response)
				.nameAttributeKey(userNameAttributeName)
				.build();
	}
	
	public NaverUser toEntity(String email) {
		
		if (email.equals("toad001@nate.com") ) {
			return NaverUser.builder()
					.name(name)
					.email(email)
					.picture(picture)
					.role(Role.ADMIN)
					.build();
		}
		return NaverUser.builder()
				.name(name)
				.email(email)
				.picture(picture)
				.role(Role.GUEST)
				.build();
	}
}
