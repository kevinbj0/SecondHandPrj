package com.sh.login;

import java.util.List;

public interface LoginServiceI {
	
    public boolean checkLogin(LoginDTO loginDTO);
	
    LoginDTO selectAll(LoginDTO loginDTO);
}
