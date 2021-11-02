package day1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp2 {

	public static void main(String[] args) {
		ApplicationContext context
		= new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext2.xml");
		
		System.out.println("=====================================");
		
		//bean저장소에 특정 bean을 가져옴.
		MemberController controller = (MemberController) context.getBean("memberController");
		System.out.println(controller.findMember(23));
	}
}
