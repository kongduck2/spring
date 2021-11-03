package jcpdev.day1.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BoardDao {		//db 작업
	private String dbFactory;	
	@Value("마이바티스")
	public void setDbFactory(String dbFactory) {  //bean설정에서 property 지정하려면 setter 메소드가 있어야합니다.
		this.dbFactory = dbFactory;
	}
	
	public void dataRead() {
		System.out.println("dao dataRead()------");
		//dbFactory="Mybatis";
		System.out.println(dbFactory + "[]dbFactory 를 이용하여 데이터를 읽어옵니다.");
	}

}
