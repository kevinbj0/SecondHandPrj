package com.sh.order;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryRealImp implements OrderRepositoryI {

	@Autowired
	private SqlSession session;
	private static String namespace = "com.sh.order.OrderMapper.";

	@Override
	public int insert(OrderDTO orderDTO) {

		return session.insert(namespace + "insertOrder", orderDTO);
	}

}
