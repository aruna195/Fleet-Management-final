package FleetDao;


	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;

	import javax.annotation.PostConstruct;
	import javax.sql.DataSource;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.jdbc.core.BeanPropertyRowMapper;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.core.RowCallbackHandler;
	import org.springframework.stereotype.Repository;

	import com.project.db.datasource.DataBaseFactory;
    import com.project.fleet.FleetInfo;
	

	@Repository
	public class FleetDaoImpl implements FleetDao {

		// list is working as a database
		@Autowired
		private DataSource mySQLDatasource;
		private JdbcTemplate jdbcTemplate ;
		
		List<FleetInfo> fleet_info;

		@PostConstruct
		public void afterPropertiesSet() throws Exception{
			System.out.println("**********************************In Post construct*******************************");
			this.jdbcTemplate = new JdbcTemplate(mySQLDatasource);
			
		}
		public FleetDaoImpl() {
			}

		@Override
		public List<FleetInfo> getAllFleet() {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
						if(mySQLDatasource == null )
							mySQLDatasource = DataBaseFactory.getDataSource("mysql");
						this.jdbcTemplate = new JdbcTemplate(mySQLDatasource);
						String sql = "Select * from mydb.fleet_info"; 						
						return jdbcTemplate.query(sql, new BeanPropertyRowMapper(FleetInfo.class));
		}@Override
		public FleetInfo getFleetInfo(int fleet_id) {
			// TODO Auto-generated method stub
			return null;
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		


}
