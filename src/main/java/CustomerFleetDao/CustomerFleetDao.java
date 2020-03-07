package CustomerFleetDao;

import java.util.List;

import com.project.fleet.Customer;
import com.project.fleet.CustomerFleet;

public interface CustomerFleetDao {

	public List<CustomerFleet> getAllCustomerFleet();

	public int getFleetId(int customer_id);

	public int create(Customer customer);

}
