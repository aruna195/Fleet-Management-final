package CustomerDao;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.db.datasource.DataBaseFactory;
import com.project.fleet.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	// list is working as a database
	@Autowired
	private DataSource mySQLDatasource;
	private JdbcTemplate jdbcTemplate ;
	
	List<Customer> customers;

	@PostConstruct
	public void afterPropertiesSet() throws Exception{
		System.out.println("**********************************In Post construct*******************************");
		this.jdbcTemplate = new JdbcTemplate(mySQLDatasource);
		
	}
	public CustomerDaoImpl() {
		}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		if(mySQLDatasource == null )
			mySQLDatasource = DataBaseFactory.getDataSource("mysql");
		this.jdbcTemplate = new JdbcTemplate(mySQLDatasource);
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
					customer.setCustomerId(rs.getInt("customerId"));
					customer.setCustomerName(rs.getString("customerName"));
					customer.setAddress_line_1(rs.getString("Address_line_1"));
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
		// TODO Auto-generated method stub
		// update
		if (customer.getCustomerId() > 0) {


					String sql = "UPDATE  mydb.customers Set  customerName=?,address_line_1()=?, city=?,postal_code=?,state=?,country=?,latitude=?,longitude=?,business_phone=?,personal_phone=? WHERE customer_id=?,";
					jdbcTemplate.update(sql, customer.getCustomerId(), customer.getCustomerName(), customer.getAddress_line_1(),
							customer.getCity(), customer.getState(), customer.getPostal_code(), customer.getCountry(),
							customer.getLatitude(), customer.getLongitude(), customer.getBusiness_phone(),
							customer.getPersonal_phone());

				}

				else {
					// insert

					String sql = "insert into mydb.customers(customer_id, customer_name, address_line_1, city, state, country, postal_code, latitude, longitude, business_phone, personal_phone) Values(?,?,?,?,?,?,?,?,?,?,?)";

					jdbcTemplate.update(sql, customer.getCustomerId(), customer.getCustomerName(), customer.getAddress_line_1(),
							customer.getCity(), customer.getState(), customer.getPostal_code(), customer.getCountry(),
							customer.getLatitude(), customer.getLongitude(), customer.getBusiness_phone(),
							customer.getPersonal_phone());

				}

			

		
	}
	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		String sql = "DELETE From mydb.customers where customer_id=?";
		jdbcTemplate.update(sql, customerId);
	}

		
	}

	
	