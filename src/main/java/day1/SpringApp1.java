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

	}//main end
}
