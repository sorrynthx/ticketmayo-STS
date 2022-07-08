package com.dreammonster.ticketmayo.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.dreammonster.ticketmayo.domain.naverUser.Role;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
	
	private final CustomOAuth2NaverUserService customOAuth2NaverUserService;
	
	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http
			// h2-console 화면을 사용하기 위해 해당 옵션 disable
			.csrf().disable().headers().frameOptions().disable()
			.and()
				// URL별 권한관리 설정 옵션 시작점(authoriezRequests가 선언되어야만 antMatchers 옵션 사용 가능)
				.authorizeRequests()
				// 권한관리 대상 지정, "/"등 지정된 URL은 전체 열람 권한
				.antMatchers("/**", "/assets/css/**", "/assets/media/**", "/assets/js/**", "/assets/plugins/**", "/h2-console/**").permitAll()
				// "/api/v1/** 주소를 가진 aPI는 USER 권한을 가진 사람만 가능"
				.antMatchers("/api/v1/**").hasRole(Role.USER.name())
				// 설정된 값들 이외 나머지 URL들을 나타냄 (인증된 사용자만 나머지 URL 허용)
				.anyRequest().authenticated()
			.and()
				// 로그아웃 시, "/"으로 이동
				.logout()
					.logoutSuccessUrl("/")
			.and()
				// OAuth2 로그인 기능
				.oauth2Login()
					// OAuth2 로그인 성공 후 사용자 정보 가져올 때의 설정 담당
					.userInfoEndpoint()
						// 소셜 로그인 성공 시, 후속 조치를 진행할 UserService 인터페이스 구현체 등록
						.userService(customOAuth2NaverUserService)
			
			.and()
			.loginPage("/login")
			.defaultSuccessUrl("/openWait");
		return http.build();
	}
	
}
