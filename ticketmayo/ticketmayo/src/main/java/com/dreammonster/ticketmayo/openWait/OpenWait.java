package com.dreammonster.ticketmayo.openWait;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OpenWait {
	
	@GetMapping("/openWait")
	public String openWait() {
		
		return "openWait";
	}
}
