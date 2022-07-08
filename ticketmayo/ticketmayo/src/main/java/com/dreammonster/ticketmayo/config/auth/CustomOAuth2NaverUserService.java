package com.dreammonster.ticketmayo.config.auth;

import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.dreammonster.ticketmayo.config.auth.dto.OAuthAttributes;
import com.dreammonster.ticketmayo.config.auth.dto.SessionUser;
import com.dreammonster.ticketmayo.domain.naverUser.NaverUser;
import com.dreammonster.ticketmayo.domain.naverUser.NaverUserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomOAuth2NaverUserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
	
	private final NaverUserRepository naverUserRepository;
	private final HttpSession httpSession;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);
		
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		
		String userNameAttributeName = userRequest.getClientRegistration()
													.getProviderDetails()
													.getUserInfoEndpoint()
													.getUserNameAttributeName(); 
		
		OAuthAttributes attributes = OAuthAttributes
				.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
		
		NaverUser naverUser = saveOrUpdate(attributes);
		
		httpSession.setAttribute("naverUser", new SessionUser(naverUser));
		
		return new DefaultOAuth2User(
				Collections.singleton(new SimpleGrantedAuthority(naverUser.getRoleKey())), 
				attributes.getAttributes(), 
				attributes.getNameAttributeKey()
			);
	}
	
	private NaverUser saveOrUpdate(OAuthAttributes attributes) {
		NaverUser naverUser = naverUserRepository.findByEmail(attributes.getEmail())
												.map(entity -> entity.update(
																				attributes.getName(), 
																				attributes.getPicture()
																			)
													)
												.orElse(attributes.toEntity(attributes.getEmail()));
		return naverUserRepository.save(naverUser);
	}
	
}
