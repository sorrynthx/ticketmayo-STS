package com.dreammonster.ticketmayo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dreammonster.ticketmayo.config.auth.LoginUserArgumentResolver;
import com.dreammonster.ticketmayo.utils.ApiMethod;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	// @LoginUser 어노테이션 등
	private final LoginUserArgumentResolver loginUserArgumentResolver;
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(loginUserArgumentResolver);
	}
	
	@Bean
	public ApiMethod apiMethod() {
		return new ApiMethod();
	}
}