package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sender.MealOrder;
import com.example.demo.sender.OrderSender;

@RestController
@RequestMapping("/order")
public class OrderResource {

	@Autowired
	private OrderSender queueSender;

	@PutMapping
	public void send(@RequestBody MealOrder mealOrder) {
		queueSender.send(mealOrder.getMeal());
	}

}