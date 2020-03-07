package CustomerFleetDao;

import java.util.List;

import com.project.fleet.Customer;
import com.project.fleet.CustomerFleet;
import com.project.fleet.FleetInfo;

public interface CustomerFleetDao {

	public List<CustomerFleet> getAllCustomerFleet();

	public List<FleetInfo> getFleets(int customer_id);

	public int create(Customer customer);

}
