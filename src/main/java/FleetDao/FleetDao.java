package FleetDao;

import java.util.List;

import com.project.fleet.FleetInfo;

public interface FleetDao {
	
	public List<FleetInfo> getAllFleet();
	   public FleetInfo getFleetInfo(int fleet_id);
	

}
