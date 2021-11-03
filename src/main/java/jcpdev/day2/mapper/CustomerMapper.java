package jcpdev.day2.mapper;

import jcpdev.day2.dto.Customer;


public interface CustomerMapper {   
	Customer selectAll();
	Customer selectOne(int idx);
	void insert(Customer dto);
	void update(Customer dto);
	void delete(Customer dto);
	
	
}
