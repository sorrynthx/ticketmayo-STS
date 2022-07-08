package com.dreammonster.ticketmayo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TicketmayoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketmayoApplication.class, args);
	}

}
