package com.dreammonster.ticketmayo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dreammonster.ticketmayo.utils.ApiMethod;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Bean
	public ApiMethod apiMethod() {
		return new ApiMethod();
	}
}