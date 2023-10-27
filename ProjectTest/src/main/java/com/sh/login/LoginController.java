package com.sh.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String processLogin(@ModelAttribute LoginDTO loginDTO, HttpServletRequest request) {
		if (loginService.checkLogin(loginDTO)) {
			// System.out.println("dfdfdf===>" + loginDTO);

			HttpSession session = request.getSession();

			session.setAttribute("user", loginDTO);

			// 세션에서 유저 정보 가져오기
			LoginDTO loggedInUser = (LoginDTO) session.getAttribute("user");
			// System.out.println("Logged in user: " + loggedInUser);

			// selectAll 메소드 호출하여 유저 정보 가져오기
			LoginDTO selectedUser = loginService.selectAll(loginDTO);
			// System.out.println("Selected user: " + selectedUser);

			// 세션에 selectedUser 저장
			session.setAttribute("selectedUser", selectedUser);

			return "fPage";
		} else {
			return "redirect:/login?error=loginerror";
		}
	}
//
//	@GetMapping
//	String showWelcomePage() {
//		return "fPage";
//	}
}