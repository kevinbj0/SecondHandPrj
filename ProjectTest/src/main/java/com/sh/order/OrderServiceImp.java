package com.sh.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderServiceI {

	@Autowired
	OrderRepositoryI dao;

	@Override
	public int registerMember(OrderDTO orderDTO) {

		return dao.insert(orderDTO);
	}

}
