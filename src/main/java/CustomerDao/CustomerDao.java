package CustomerDao;

import java.util.List;

import java.util.Map;

import com.project.fleet.Customer;

public interface CustomerDao {
	
	 /*  public List<Customer> getAllCustomers();
	   
	   public Customer getCustomer(int customerId);
	   
	   public List<Customer> findCustomerById(int customerId);
	   public int create(Customer customer);
       public int updateCustomer(Customer customer);
	   public int deleteCustomer(int customerId); */
	
	public List<Customer> getAllCustomers();

	public Customer getCustomer(int customerId);

	public void createCustomer(Customer customer);
	public void updateCustomer(Customer customer);

	public void deleteCustomer(int customerId);

	public List<Customer> findCustomerById(int customerId);
	}


