package CustomerDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.project.db.datasource.DataBaseFactory;
import com.project.db.datasource.MyDataSource;
import com.project.fleet.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	// list is working as a database
	@Autowired
	private static MyDataSource mySQLDatasource;
	
	private JdbcTemplate jdbcTemplate;

	List<Customer> customers;
	
	public static void getInstance() {
		if (mySQLDatasource == null)
			mySQLDatasource = DataBaseFactory.getDataSource("mysql");
		
	}


	public CustomerDaoImpl() {
		CustomerDaoImpl.getInstance();
		this.jdbcTemplate = new JdbcTemplate(mySQLDatasource.getDatasource());
		System.out.println("In Constructor");
	}
	

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		String sql = "Select * from mydb.customers";

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Customer.class));

	}

	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub

		String sql = "Select * from mydb.customers Where customer_id=" + customerId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Customer>() {

			@Override
			public Customer extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {
					Customer customer = new Customer();
					customer.setCustomerId(rs.getInt("customer_id"));
					customer.setCustomerName(rs.getString("customer_name"));
					customer.setAddress_line_1(rs.getString("address_line_1"));
					customer.setCity(rs.getString("city"));
					customer.setPostal_code(rs.getString("postal_code"));
					customer.setState(rs.getString("state"));
					customer.setCountry(rs.getString("country"));
					customer.setLatitude(rs.getDouble("latitude"));
					customer.setLongitude(rs.getDouble("longitude"));
					customer.setPersonal_phone(rs.getString("personal_phone"));
					customer.setBusiness_phone(rs.getString("business_phone"));
					return customer;
				}
				return null;
			}

		});

	}

	@Override
	public void createCustomer(Customer customer) {

		String sql = "insert into mydb.customers(customer_id, customer_name, address_line_1, city, state, country, postal_code, latitude, longitude, business_phone, personal_phone) Values(?,?,?,?,?,?,?,?,?,?,?)";

		jdbcTemplate.update(sql, customer.getCustomerId(), customer.getCustomerName(), customer.getAddress_line_1(),
				customer.getCity(), customer.getPostal_code(),customer.getState(), customer.getCountry(), 
				customer.getLatitude(), customer.getLongitude(), customer.getBusiness_phone(),
				customer.getPersonal_phone());

	}

	@Override
	public void editCustomer(Customer customer) {
		// TODO Auto-generated method stub
		 if (customer.getCustomerId() > 0) {

		String sql = "UPDATE  mydb.customers Set customerId=?, customerName=?,address_line_1()=?, city=?,postal_code=?,state=?,country=?,latitude=?,longitude=?,business_phone=?,personal_phone=? WHERE customer_id=?,";
		jdbcTemplate.update(sql, customer.getCustomerId(), customer.getCustomerName(), customer.getAddress_line_1(),
				customer.getCity(), customer.getPostal_code(), customer.getState(),  customer.getCountry(),
				customer.getLatitude(), customer.getLongitude(), customer.getBusiness_phone(),
				customer.getPersonal_phone());
		     jdbcTemplate.update(sql, customer);
	}
	}
		 

	/*
	 * else { //insert
	 * 
	 * String sql =
	 * "insert into mydb.customers(customer_id, customer_name, address_line_1, city, postal_code, state, country,  latitude, longitude, business_phone, personal_phone) Values(?,?,?,?,?,?,?,?,?,?,?)"
	 * ;
	 * 
	 * jdbcTemplate.update(sql, customer.getCustomerId(),
	 * customer.getCustomerName(), customer.getAddress_line_1(), customer.getCity(),
	 * customer.getState(), customer.getCountry(),customer.getPostal_code(),
	 * customer.getLatitude(), customer.getLongitude(),
	 * customer.getBusiness_phone(), customer.getPersonal_phone());
	 * 
	 * }
	 */

	@Override
	public void updateCustomer(Customer customer) {
		String sql = "UPDATE  mydb.customers Set customer_name='" + customer.getCustomerName() + "',address_line_1='"
				+ customer.getAddress_line_1() + "',city='" + customer.getCity() + "',postal_code='"
				+ customer.getPostal_code() + "',state='" + customer.getState() + "',country='" + customer.getCountry()
				+ "',latitude='" + customer.getLatitude() + "',longitude='" + customer.getLongitude()
				+ "',business_phone='" + customer.getBusiness_phone() + "',personal_phone='"
				+ customer.getPersonal_phone() + "' where customer_id= ?"; 
		jdbcTemplate.update(sql, customer.getCustomerId());
		

	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		String sql = "DELETE From mydb.customers where customer_id=?";
		jdbcTemplate.update(sql, customerId);
	}

	@Override
	public List<Customer> findCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}
}
