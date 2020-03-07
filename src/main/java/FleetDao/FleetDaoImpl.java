package FleetDao;


	import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.project.db.datasource.DataBaseFactory;
import com.project.db.datasource.MyDataSource;
import com.project.fleet.FleetInfo;
	

	@Repository
	public class FleetDaoImpl implements FleetDao {

		private static MyDataSource mySQLDatasource;
		private JdbcTemplate jdbcTemplate ;
		
		List<FleetInfo> fleet_info;

		public static void getInstance() {
			if (mySQLDatasource == null)
				mySQLDatasource = DataBaseFactory.getDataSource("mysql");
			
		}


		public FleetDaoImpl() {
			FleetDaoImpl.getInstance();
			this.jdbcTemplate = new JdbcTemplate(mySQLDatasource.getDatasource());
			System.out.println("In Constructor");
		}

		@Override
		public List<FleetInfo> getAllFleet() {
						String sql = "Select * from mydb.fleet_info"; 						
						return jdbcTemplate.query(sql, new BeanPropertyRowMapper(FleetInfo.class));
		}@Override
		public FleetInfo getFleetInfo(int fleet_id) {
			// TODO Auto-generated method stub
			String sql = "Select * from mydb.fleet_info Where fleet_id=" + fleet_id;
			return jdbcTemplate.query(sql, new ResultSetExtractor<FleetInfo>() {

				@Override
				public FleetInfo extractData(ResultSet rs) throws SQLException, DataAccessException {

					if (rs.next()) {
						FleetInfo fleet = new FleetInfo();
	fleet.setFleet_id (rs.getInt("fleet_id "));
	fleet.setFleet_name(rs.getString("fleet_name"));
	fleet.setFleet_model(rs.getString("fleet_model"));
	fleet.setFleet_make(rs.getString("fleet_make"));
	fleet.setLatitude(rs.getDouble("latitude"));
	fleet.setLongitude(rs.getDouble("longitude"));
	fleet.setCategory(rs.getString("category"));
	fleet.setSerial_number(rs.getString("serial_number"));
	return fleet;
	
					} 
			
			return null;
		}
			});
}
		@Override
		public void createFleetInfo(FleetInfo fleet) {
			// TODO Auto-generated method stub
			
			String sql = "insert into mydb.fleet_info(fleet_id, fleet_name, fleet_model, fleet_make, latitude, longitude, category, serial_number) Values(?,?,?,?,?,?,?,?)";

			jdbcTemplate.update(sql, fleet.getFleet_id(),fleet.getFleet_name(),fleet.getFleet_model (),fleet.getFleet_make (),
						fleet.getLatitude(), fleet.getLongitude(), fleet.getCategory(),
					fleet.getSerial_number());

			
		}
/*		@Override
		public void updateFleetInfo(FleetInfo fleet) {
			// TODO Auto-generated method stub
			String sql ="Update mydb.fleet_info Set Fleet_name=?,Fleet_model=?,Fleet_make=?,Latitude=?, Longitude=?,Category=?,Serial_number=?  WHERE fleet_id=?,";
					jdbcTemplate.update(sql, fleet.getFleet_id(),fleet.getFleet_name(),fleet.getFleet_model (),fleet.getFleet_make (),fleet.getLatitude(), fleet.getLongitude(), fleet.getCategory(),fleet.getSerial_number()); 
					 
			
		}
		@Override
		public void deleteFleetInfo(int fleet_id) {
			// TODO Auto-generated method stub
			String sql = "DELETE from mydb.fleet_info where fleet_id=?";
			jdbcTemplate.update(sql,fleet_id);
			
		}
		@Override
		public void editFleetInfo(FleetInfo fleet) {
			// TODO Auto-generated method stub
			
		} */


		@Override
		public void updateFleetInfo(FleetInfo fleet) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void editFleetInfo(FleetInfo fleet) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void deleteFleetInfo(int fleet_id) {
			// TODO Auto-generated method stub
			
		}
	}
