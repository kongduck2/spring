package jcpdev.day1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jcpdev.day1.dao.MemberDao;
import jcpdev.dto.Member;

@Component
public class MemberServiceYourImpl implements MemberService{
	private MemberDao dao;
	@Autowired
	
	public MemberServiceYourImpl(MemberDao dao) {
		System.out.println("MemberService유어Impl create ///////////////////");
		this.dao = dao;
	}    
		
		public Member findMember(int idx) {
		System.out.println("MemberService유어Impl findMember() ///////////////////");
			return dao.findMember(idx*10);
		}	
}