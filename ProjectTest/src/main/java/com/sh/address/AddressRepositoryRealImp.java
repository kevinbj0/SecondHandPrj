package com.sh.address;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddressRepositoryRealImp implements AddressRepositoryI {

	@Autowired
	private SqlSession session;
	private static String namespace = "com.sh.address.AddressMapper.";

	@Override
	public int insert(AddressDTO addressDTO) {

		return session.insert(namespace + "insertUser", addressDTO);
	}

}
