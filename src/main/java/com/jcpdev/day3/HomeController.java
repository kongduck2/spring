package com.jcpdev.day3;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) { //locale 정보를 받아와서 -> DateFormat에 적용
		//Locale : 다국어처리 클래스 , locale 이란?  국가 및 언어 설정
		logger.info("Welcome home! The client locale is {}.", locale); //log 출력
		
		Date date = new Date();	//현재 날짜와 시간
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); //request.setAttribute("serverTime",formattedDate)
		
		return "home";	//view : home.jsp
	}
	
	@RequestMapping(value = "test")
	public void test() {
		//return으로 view 정보가 없을때 기본동작은 요청의 value 값이 view 파일명임
	}
	
	@RequestMapping(value = "hello")
	public void test2() {
		
	}
	
	
	
	
	
	
}
