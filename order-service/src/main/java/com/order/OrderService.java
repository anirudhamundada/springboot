package com.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	private static final String MESSAGE_QUEUE = "message_queue";
	
	public void saveOrder(OrderVO order) {
		orderRepository.save(order);
		// restTemplate.getForEntity("http://EMAIL-SERVICE/email", String.class);
				
		// Send a message
		System.out.println("Sending email");
		jmsTemplate.convertAndSend(MESSAGE_QUEUE, "abc@citi.com");
				
	}
	
	public List<OrderVO> getOrders() {
		return orderRepository.findAll();
	}
}
