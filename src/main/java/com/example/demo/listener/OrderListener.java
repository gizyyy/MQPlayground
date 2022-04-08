package com.example.demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;

public class OrderListener {

	@RabbitListener(queues = { "${queue.name}" })
	public void receive(@Payload String meal) {
		System.out.println("Meal " + meal + " will be delivered soon");
	}

}
