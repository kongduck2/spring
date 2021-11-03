package jcpdev.day1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jcpdev.day1.service.BoardService;

@Component	//-> bean으로 생성된다.
public class BoardController {  //웹애플리케이션에서 클라이언트 요청 처리
	private BoardService service; 
	@Autowired		//BoardService 타입의 빈을 주입한다.
	public void setService(BoardService service) { //의존관계 주입 방법1 : setter(수정)메소드
		this.service = service;
	}
	
	//의존관계 주입 방법2:커스텀 생성자
	
	public void dataRead() {
		System.out.println("controller dataRead()------");
		service.dataRead();
	}
}

/*
@Autowired 는 필드,생성자,메소드에서 의존관계를 주입할 수 있다.-> byType 으로 주입한다.
          주입할 bean 이 없으면 오류가 발생한다.
@Component로 bean을 생성할 때에는  사용할 떄에는 기본생성자 -> 커스텀 생성자 순서로 생성한다.
-> 이 때 @Autowired를 만나면 해당 빈을 먼저 생성하여 주입한다.

@Qualifier(value="bean 이름")   는 
          @Autowired 로 주입 시킬 타입의 bean이 여러개일 때 빈의 이름을 지정한다.
        필드,생성자,setter메소드 에 사용할 수 있다.

@Autowired(required = false) 는 주입할 빈이 없을 때 오류 발생하지 않는다.


*결론 : 추천 
 대부분의 의존관계 주입은 한 번 일어나면 애플리케이션 종료시점까지 의존관계를 변경하지 않는다.
 bean 을 주입할 필드 변수는 final로 선언하고 , 생성자 주입을 사용한다.
*/