package day1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp1 {

	public static void main(String[] args) {
		//bean을 관리하는 스프링 컨테이너에 접근하는 객체를 생성한다. -> spring-context
		//이 때 bean설정파일을 지정한다. 스프링 컨테이너는 bean을 생성하고 저장소에 등록하여 관리한다.
		ApplicationContext context =
			new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext.xml");
		
		BoardController controller = (BoardController) context.getBean("boardController"); 
		controller.dataRead();
		System.out.println("-----------------------");
		Singer singer = (Singer) context.getBean("singer");
		System.out.println(singer);
		System.out.println("-----------------------");
		
		BoardController controller2 =
			(BoardController) context.getBean("boardController");
		//bean 생성의 기본값은 싱글턴 패턴
		System.out.println("controller==controller2");
		System.out.println(controller==controller2);
		System.out.println("-----------------------");
		//singer 빈을 한번더 가져와서 위의 17번 라인객체와 비교
		Singer singer2 = (Singer)context.getBean("singer"); //새로운 객체생성
		System.out.println("singer==singer2");
		System.out.println(singer==singer2); //prititype 설정 bean : 거짓
		singer2.setSinger("원더걸스");
		System.out.println(singer);
		System.out.println(singer2); //두 객체는 서로 다름
	}//main end
}
