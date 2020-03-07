package com.project.controllers;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.fleet.Customer;

import CustomerDao.CustomerDao;
import CustomerDao.CustomerDaoImpl;

@RunWith(SpringRunner.class)
public class HomeControllerTest {
	
	
	CustomerDao dao = new CustomerDaoImpl() ;
	
	public HomeControllerTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testShowHomePage() throws URISyntaxException {
		
		List<Customer> allCustomers = dao.getAllCustomers();
		Assert.assertNotNull(allCustomers);
		Assert.assertTrue(allCustomers.size() > 1);
	}
		
	@Test
	public void testCustomer() throws URISyntaxException {
		
		List<Customer> allCustomers = dao.getAllCustomers();
		Customer customer = dao.getCustomer(4);
		Assert.assertNotNull(customer);
		Assert.assertTrue(customer.getCustomerId() == 4);
	}
}
