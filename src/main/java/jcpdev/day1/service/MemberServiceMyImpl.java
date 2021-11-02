package jcpdev.day1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jcpdev.day1.dao.MemberDao;
import jcpdev.dto.Member;

@Component
public class MemberServiceMyImpl implements MemberService {
	@Autowired
	private MemberDao dao;
	
	public MemberServiceMyImpl() {//@Autowired 하려면 기본 생성자 필요
	}

	//의존성 주입을 생성자로 한다.
	public MemberServiceMyImpl(MemberDao dao) {
		System.out.println("MemberServiceMyImpl create.///////////////////");
		this.dao = dao;
	}

	public Member findMember(int idx) {
		
		System.out.println("MemberServiceMyImpl findMember()///////////////////");
		return dao.findMember(idx);
	}

}
