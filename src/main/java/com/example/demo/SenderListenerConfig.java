package com.example.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.listener.OrderListener;

@Configuration
public class SenderListenerConfig {

	@Value("${queue.name}")
	private String message;

	/**
	 * A queue with 1 minute TTL
	 * @return
	 */
	@Bean
	public Queue queue() {
		Queue queue = new Queue(message, true);
		queue.addArgument("x-message-ttl", 60000);
		queue.addArgument("x-dead-letter-exchange", "order.created.exchange.dead");
		queue.addArgument("x-dead-letter-routing-key", "order.created.route.dead");
		return queue;

	}

	@Bean(name = "orderListener")
	@ConditionalOnProperty(prefix = "order", name = "listener", havingValue = "open")
	public OrderListener notificationSender() {
		return new OrderListener();
	}

}