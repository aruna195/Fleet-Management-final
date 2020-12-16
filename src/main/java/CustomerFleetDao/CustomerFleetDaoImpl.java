package CustomerFleetDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.project.db.datasource.DataBaseFactory;
import com.project.db.datasource.MyDataSource;
import com.project.fleet.Customer;
import com.project.fleet.CustomerFleet;
import com.project.fleet.FleetInfo;

import CustomerDao.CustomerDaoImpl;

@Repository
public class CustomerFleetDaoImpl implements CustomerFleetDao {

	// list is working as a database
	private static MyDataSource mySQLDatasource;
	private JdbcTemplate jdbcTemplate;

	List<FleetInfo> fleet_info;


	public static void getInstance() {
		if (mySQLDatasource == null)
			mySQLDatasource = DataBaseFactory.getDataSource("mysql");
		
	}


	public CustomerFleetDaoImpl() {
		CustomerFleetDaoImpl.getInstance();
		this.jdbcTemplate = new JdbcTemplate(mySQLDatasource.getDatasource());
		System.out.println("In Constructor");
	}

	@Override
	public List<CustomerFleet> getAllCustomerFleet() {
		
		String sql = "Select * from public.cust_fleet_info";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(CustomerFleet.class));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FleetInfo> getFleets(int customer_id) {

		String sql = "select B.* from public.cust_fleet_info A , public.fleet_info B where A.fleet_id = B.fleet_id and A.customer_id="
				+ customer_id;

		return jdbcTemplate.query(sql, new ResultSetExtractor<List>() {

			@Override
			public List<FleetInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<FleetInfo> fleets = new ArrayList<FleetInfo>();
				while (rs.next()) {
					FleetInfo fleet = new FleetInfo();
					fleet.setFleet_id(rs.getInt("fleet_id"));
					fleet.setFleet_name(rs.getString("fleet_name"));
					fleet.setFleet_model(rs.getString("fleet_model"));
					fleet.setFleet_make(rs.getString("fleet_make"));
					fleet.setLatitude(rs.getDouble("latitude"));
					fleet.setLongitude(rs.getDouble("longitude"));
					fleet.setCategory(rs.getString("category"));
					fleet.setSerial_number(rs.getString("serial_number"));
					fleets.add(fleet);

				}

				return fleets;
			}
		});

	}

	@Override
	public int create(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

}
