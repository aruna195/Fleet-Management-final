package CustomerDao;

import java.util.List;

import java.util.Map;

import com.project.fleet.Customer;

public interface CustomerDao {
	
	 //DAO Pattern is used
	
	public List<Customer> getAllCustomers();

	public Customer getCustomer(int customerId);

	public void createCustomer(Customer customer);
	
	//public void updateCustomer(Customer customer);
	public void saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);

	

	public void deleteCustomer(int customerId);
	
	public void editCustomer(Customer customer);

	public List<Customer> findCustomerById(int customerId);
	}


