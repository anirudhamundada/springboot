package com.email;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmailController {
	private static final String MESSAGE_QUEUE = "message_queue";
	
	@GetMapping("email")
	String sendMail() {
		System.out.println("email sent");
		return "send successfully";
	}
	
	@PostMapping("email")
	@JmsListener(destination = MESSAGE_QUEUE)
	String sendPostMail(@RequestBody String email) {
		System.out.println("email sent to: " + email);
		return "send successfully";
	}
}
