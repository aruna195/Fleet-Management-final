package com.project.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.fleet.Customer;

import CustomerDao.CustomerDao;
import CustomerDao.CustomerDaoImpl;
@Controller
public class HomeController {
	// @GetMapping(value = "/")

	// public String showHomePage(Model model) throws SQLException {

	// System.out.println("In HomePage");
	/*
	 * List<Customer> allCustomers = new CustomerDaoImpl().getAllCustomers();
	 * System.out.println(allCustomers);
	 * 
	 * model.addAttribute("CustomerList", allCustomers);
	 * 
	 * return "customers";
	 * 
	 * //return "home";
	 */

	// return "Create";

	/*
	 * List<FleetInfo> allFleetInfo = new FleetDaoImpl().getAllFleet();
	 * System.out.println(allFleetInfo);
	 * 
	 * model.addAttribute("FleetList", allFleetInfo); return "fleetlist";
	 */

	// return "home";
	@Autowired
	private CustomerDao customerDao;

	@RequestMapping(value = "/")
	public String showHomePage(Model model) throws SQLException {

		System.out.println("In HomePage");

		/*List<Customer> allCustomers = new CustomerDaoImpl().getAllCustomers();
		System.out.println(allCustomers);

		model.addAttribute("CustomerList", allCustomers);
		//((ModelAndView) model).setViewName("customers");
		return "customers"; */
		
		List<Customer> allCustomers = new CustomerDaoImpl().getAllCustomers();
		System.out.println(allCustomers);
			
		model.addAttribute("CustomerList", allCustomers);
		
		return "customers";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)

	public String newCustomerPage(Model model) throws SQLException{
		Customer newCustomer = new Customer();
		model.addAttribute("customer", newCustomer);
		//((ModelAndView) model).setViewName("NewCustomerForm");
		return "newcustomerform";

	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	
	public String  save(@ModelAttribute Customer customer) {
		customerDao.updateCustomer(customer);
		
		return "redirect:/customers";
	
		
	
	} 
	

	@RequestMapping(value = "/edit/{id}")
	public String editCustomer(@PathVariable int customerId, Model model) {

		
		Customer customer = customerDao.getCustomer(customerId);
		
		model.addAttribute("customer", customer);
		return "newcustomerform";
	}
@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	
	public String  editsave(@ModelAttribute Customer customer) {
		customerDao.updateCustomer(customer);
		
		return "redirect:/customers";
}
	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable int customerId) {

		
		customerDao.deleteCustomer(customerId);

		return "redirect:/customers";
	}

}
