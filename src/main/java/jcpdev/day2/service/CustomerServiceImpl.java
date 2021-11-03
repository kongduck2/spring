package jcpdev.day2.service;

import org.springframework.stereotype.Component;

import jcpdev.day2.dto.Customer;
import jcpdev.day2.mapper.CustomerMapper;

@Component
public class CustomerServiceImpl implements CustomerService {

	private final CustomerMapper customerDao;
	
	public CustomerServiceImpl(CustomerMapper customerDao) {
		this.customerDao = customerDao;
	}
	
	@Override
	public Customer selectAll() {
		return customerDao.selectAll();
	}

	@Override
	public Customer selectOne(int idx) {
		return customerDao.selectOne(idx);
	}
}
