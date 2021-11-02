package jcpdev.day1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jcpdev.day1.service.BoardService;

@Component	//-> bean으로 생성된다.
public class BoardController {  //웹애플리케이션에서 클라이언트 요청 처리
	private BoardService service; 
	@Autowired		//BoardService 타입의 빈을 주입한다.
	public void setService(BoardService service) { //의존관계 주입 : setter
		this.service = service;
	}
	
	//의존관계 주입 방법2:커스텀 생성자
	
	public void dataRead() {
		System.out.println("controller dataRead()------");
		service.dataRead();
	}
}
