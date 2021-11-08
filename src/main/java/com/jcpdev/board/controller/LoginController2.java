package com.jcpdev.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcpdev.board.model.Customer;
import com.jcpdev.board.service.CustomerService;

//@Controller
public class LoginController2 {
	
	private final CustomerService service;
	
	public LoginController2(CustomerService service) {
		this.service = service;
	}
	
	
	@RequestMapping(value = "login",method = RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
	//위에서 입력한 로그인 정보를 Model 객체로 전달받는다.
	@RequestMapping(value = "login",method = RequestMethod.POST)
	public String loginOk(String email,String password , Model model,HttpSession session) { 
		Customer result = service.login(Customer.builder().email(email).password(password).build());
		if(result != null) { //로그인 성공
			session.setAttribute("customer", result);
			return "home"; //정상 로그인 후 -> home.jsp
		}else { //로그인 실패
			model.addAttribute("message","로그인 정보가 틀립니다.");
			model.addAttribute("url","login");
			return "alertLogin";
		}
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
	
	
}
