package com.jcpdev.day3;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jcpdev.day3.model.Order;

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
										//Model은 view 로 전달할 애트리뷰트를 저장
		//Locale : 다국어처리 클래스 , locale 이란?  국가 및 언어 설정
		logger.info("Welcome home! The client locale is {}.", locale); //log 출력
		
		java.util.Date date = new java.util.Date();	//현재 날짜와 시간
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		//model.addAttribute 메소드는 기본형데이터 정수,실수 , 문자열 등을 view로 보낼때 또는,
		//view에서 따로 입력받지 않고 새로 생성된 객체를 view로 보낼때 사용한다
		model.addAttribute("serverTime", formattedDate ); //request.setAttribute("serverTime",formattedDate)
		model.addAttribute("message", "스프링에 오신것을 환영합니다.");
		return "home";	//view : home.jsp
	}
	
	@RequestMapping(value = "test")
	public void test() {
		//return으로 view 정보가 없을때 기본동작은 요청의 value 값이 view 파일명임
	}
	
	@RequestMapping(value = "hello")
	public void test2() {
		
	}
	
	@RequestMapping(value = "regist",method = RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	@RequestMapping(value = "regist" ,method = RequestMethod.POST) //요청에 일치하는 값을 지정하는방식
	public void regist(Order order) {	//form.jsp(View)의 submit -> action="regist" -> 입력값이 order에 전달
							//인자에 @ModelAttribute가 생략됨(Attribute이름은 order) -> regist.jsp (View)에 출력
 							//애트리뷰트 이름 변경은 @ModelAttribute(name ="od") <<요런식으로   
		System.out.println(order);
	}

	@RequestMapping(value="list")
	public void list(String page) {//@RequestParam 생략되었고(기본값 required = false) page 파라미터 값을 저장한다.
		if(page == null || page.equals("")) page="1";
		
		System.out.println("page 파라미터 값 =" + page);
	}
	
		//int page로 선언했을 때
		//http://localhost:8082/day3/list 는 500 내부서버 오류
		//http://localhost:8082/day3/list?page= 는 400 잘못된 요청
	
	@RequestMapping(value="getone")
	public void getOne(@RequestParam(required = true) String idx , Model model) {
					//idx파라미터 없이 http://localhost:8082/day3/getone 요청하면 400 오류 발생
		model.addAttribute("idx", idx); //Model model 매개변수 선언하여 애트리뷰트값 저장 후 view 전달
		
	}
	
	@RequestMapping(value="param2")
	public String param2(int idx, String search , Model model) {
		System.out.println("idx="+ idx);
		System.out.println("search="+ search);
		
		return "home";
	}
	
	
	@RequestMapping(value="paramn")
	public String paramn(@RequestParam Map<String,String> param,Model model) {
		//@RequestParam 생략안됨. 파라미터 여러개를 가져와서 param Map에 저장
		System.out.println(param.get("idx"));
		System.out.println(param.get("name"));
		System.out.println(param.get("search"));
		System.out.println(param.get("cnt"));
		System.out.println(param.get("page"));
		
		model.addAllAttributes(param); //Map 전체를 넘김
		
		return "paramn";
	}
	
	@RequestMapping(value = "param",params = "action=delete")
	public String param() {
		System.out.println("action=delete 입니다.");
		
		return "home";
	}
	
	//return값으로 Model과 View를 전달하는 ModelAndView 객체 사용하기
	@RequestMapping(value="mv")
	public ModelAndView mv() {
		Order order = new Order(); //java.util.Date는 소멸된 메소드가 많음
		order.setAmount(100);order.setId("admin");order.setDevDate(Date.valueOf(LocalDate.of(2021, 11, 6)));
		ModelMap model = new ModelMap();
		model.addAttribute("order",order);
		
		return new ModelAndView("regist", model);
	}
	
	//지금까지는 jsp와 비교했을 때, view에 대해서 pageContext.forward(view파일)
	
	//jsp에서 요청을 변경할 때 response.sendRedirect로 함
	@RequestMapping(value = "redirect")
	public String redirect() {
		return "redirect:hello";
		
	}
	
	@RequestMapping(value = "redirect2")
	public String redirect2(Model model) {
		model.addAttribute("idx", 55);
		return "redirect:getone"; //model 객체 사용하는 redirect로 하면 파라미터 전달
		
	}
	
	
	
	
	
}
