package jcpdev.day2.service;

import jcpdev.day2.dto.Customer;

public interface CustomerService {
	Customer selectAll();
	Customer selectOne(int idx);

}
