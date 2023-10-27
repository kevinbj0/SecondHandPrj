package com.sh.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceI {

	@Autowired
	private LoginRepositoryI userRepository;

	@Override
	public boolean checkLogin(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return userRepository.checklogin(loginDTO);
	}

	@Override
	public LoginDTO selectAll(LoginDTO loginDTO) {
		// TODO Auto-generated method stub
		return userRepository.selectAll(loginDTO);
	}
}