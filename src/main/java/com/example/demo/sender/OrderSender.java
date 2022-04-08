package com.example.demo.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class OrderSender {

	private RabbitTemplate rabbitTemplate;

	private Queue queue;

	public void send(final String meal) {
		rabbitTemplate.convertAndSend(this.queue.getName(), meal);
	}

	@RabbitListener(queues = { "${queue.name.dead}" })
	public void receive(@Payload String meal) {
		System.out.println("Looks like no restaurant is open now");
	}
}