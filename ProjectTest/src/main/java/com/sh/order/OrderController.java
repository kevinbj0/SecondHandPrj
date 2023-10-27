package com.sh.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OrderController {

	@Autowired
	OrderServiceI service;

	@GetMapping("/order")
	public String addressF() {
		return "order";
	}

	@PostMapping("/orderForm")
	public String registerMember(OrderDTO addressDTO) {
		service.registerMember(addressDTO);
		return "order";
	}
}
