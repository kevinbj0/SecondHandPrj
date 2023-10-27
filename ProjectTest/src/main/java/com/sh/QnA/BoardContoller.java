package com.sh.QnA;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardContoller {

	@Autowired
    private BoardDAO dao;
	
	@RequestMapping(value="/board" ,method= RequestMethod.GET)
	public String board(HttpServletRequest request, Model model) {
		
		// ?éò?ù¥Ïß?
		String p = request.getParameter("p");
		int currentPage = 1;
		if(p != null) {
			currentPage = Integer.parseInt(p);
		}
		
		int  totRecords = dao.getTotalCount();
		System.out.print(totRecords);
		int pageSize = 2;
		int grpSize = 3;
		
		QnaHandler handler = new QnaHandler(currentPage, totRecords, pageSize, grpSize);
		ArrayList<QnaDTO> list = dao.getListPage(currentPage, pageSize);
		
		System.out.println(list);
		// model?óê ???û•
		model.addAttribute("list",list);	
		model.addAttribute("handler", handler);
		
		
		/*
		 
		//session Î∂àÎü¨?ò§Í∏?
		HttpSession session = request.getSession();
		
		
		// ?ûÑ?ãú ?Ñ∏?Öò
		String userid = "test";
		session.setAttribute("userid", userid );
		
		// ?Ñ∏?Öò Î∞õÏïÑ?ò§Í∏?
		String id = (String) session.getAttribute("userid");
		  
		for(int i = 0; i<list.size();i++) {
			if(list.get(i).getB_id() != id) {
				model.addAttribute("secret",false);
			}else {
				model.addAttribute("secret",true);
			}
		}
		*/
		return "board";
	}
	
}
