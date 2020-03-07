package FleetDao;

import java.util.List;


import com.project.fleet.FleetInfo;

public interface FleetDao {
	
	public List<FleetInfo> getAllFleet();
	   public FleetInfo getFleetInfo(int fleet_id);
	   
	   public void createFleetInfo(FleetInfo fleet);
		public void updateFleetInfo(FleetInfo fleet);
		public void editFleetInfo(FleetInfo fleet);

		public void deleteFleetInfo(int fleet_id);

	

}
