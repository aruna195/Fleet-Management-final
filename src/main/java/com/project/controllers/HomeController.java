package com.project.controllers;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.fleet.Customer;
import com.project.fleet.FleetInfo;
import CustomerDao.CustomerDao;
import CustomerDao.CustomerDaoImpl;
import CustomerFleetDao.CustomerFleetDao;

@Controller

public class HomeController {
	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private CustomerFleetDao customerFleetDao;

	@RequestMapping(value = "/")
	public String showHomePage(Model model) throws SQLException {

		System.out.println("In HomePage");
		return "home";

	}

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public String getCustomerList(Model model) throws SQLException {

		List<Customer> allCustomers = new CustomerDaoImpl().getAllCustomers();
		System.out.println(allCustomers);

		model.addAttribute("CustomerList", allCustomers);

		return "customers";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String newCustomerPage(Model model) throws SQLException {
		Customer newCustomer = new Customer();

		model.addAttribute("customer", newCustomer);

		return "newcustomerform";

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String newCustomerPage(@RequestParam String searchId, Model model) throws SQLException {
//		Customer customer = customerDao.getCustomer(Integer.parseInt(searchId));
//		List customers = new ArrayList();
//		customers.add(customer);
//		
//		model.addAttribute("CustomerList", customers);
		System.out
				.println("*********** Search by Customer ID to get the List of Fleets owned by that Customer******** ");
		List<FleetInfo> fleets = customerFleetDao.getFleets(Integer.parseInt(searchId));
		model.addAttribute("FleetList", fleets);
		return "fleetlist";

	}

	@PostMapping(value = "/save")
	public String save(@RequestParam("customerId") String id, @RequestParam("customerName") String name,
			@RequestParam("address_line_1") String address_line_1, @RequestParam("city") String city,
			@RequestParam("postal_code") String postal_code, @RequestParam("state") String state,
			@RequestParam("country") String country, @RequestParam("latitude") String latitude,
			@RequestParam("longitude") String longitude, @RequestParam("business_phone") String business_phone,
			@RequestParam("personal_phone") String personal_phone, ModelMap modelMap) {
		Customer customer = new Customer();
		customer.setCustomerId(Integer.parseInt(id));
		customer.setCustomerName(name);
		customer.setAddress_line_1(address_line_1);
		customer.setCity(city);
		customer.setPostal_code(postal_code);
		customer.setState(state);
		customer.setCountry(country);
		customer.setLatitude(Double.parseDouble(latitude));
		customer.setLongitude(Double.parseDouble(longitude));
		customer.setBusiness_phone(business_phone);
		customer.setPersonal_phone(personal_phone);

		customerDao.createCustomer(customer);

		return "redirect:/customers";

	}

	@RequestMapping(value = "/edit/{customerId}")
	public String editCustomer(@PathVariable int customerId, ModelMap modelMap) {
		Customer customer = customerDao.getCustomer(customerId);
		System.out.println("***************************"+customer.getCustomerName());
		modelMap.addAttribute("customer", customer);
		return "editcustomerform";

	}

	@PostMapping(value = "/editsave")
	public String editsave(@RequestParam("customerId") String id,@RequestParam("customerName") String name,
			@RequestParam("address_line_1") String address_line_1, @RequestParam("city") String city,
			@RequestParam("postal_code") String postal_code, @RequestParam("state") String state,
			@RequestParam("country") String country, @RequestParam("latitude") String latitude,
			@RequestParam("longitude") String longitude, @RequestParam("business_phone") String business_phone,
			@RequestParam("personal_phone") String personal_phone) {
		
		Customer editcustomer = new Customer();
		editcustomer.setCustomerId(Integer.parseInt(id));
		editcustomer.setCustomerName(name);
		editcustomer.setAddress_line_1(address_line_1);
		editcustomer.setCity(city);
		editcustomer.setPostal_code(postal_code);
		editcustomer.setState(state);
		editcustomer.setCountry(country);
		editcustomer.setLatitude(Double.parseDouble(latitude));
		editcustomer.setLongitude(Double.parseDouble(longitude));
		editcustomer.setBusiness_phone(business_phone);
		editcustomer.setPersonal_phone(personal_phone);
		customerDao.updateCustomer(editcustomer);
		return "redirect:/customers";

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCustomer(@PathVariable int id) {

		System.out.println("In DELETE............................");
		customerDao.deleteCustomer(id);

		return "redirect:/customers";

	}
}
