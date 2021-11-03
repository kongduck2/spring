package jcpdev.day2.service;

import jcpdev.day2.dto.BoardDto;

public interface FreeboardService {
	//메소드 이름은 임의로 정의가능. 일반적으로 mapper와 메소드 이름을 동일하게 하는게 편하다.
	int getCount();
	BoardDto getBoardOne(int idx);
	

}
