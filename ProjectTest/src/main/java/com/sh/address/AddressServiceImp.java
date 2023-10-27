package com.sh.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImp implements AddressServiceI {

	@Autowired
	AddressRepositoryI dao;

	@Override
	public int registerMember(AddressDTO addressDTO) {

		return dao.insert(addressDTO);
	}

}
