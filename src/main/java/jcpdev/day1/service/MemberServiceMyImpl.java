package jcpdev.day1.service;

import jcpdev.day1.dao.MemberDao;
import jcpdev.dto.Member;

public class MemberServiceMyImpl implements MemberService {
	private MemberDao dao;

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
