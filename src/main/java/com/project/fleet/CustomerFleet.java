package com.project.fleet;

public class CustomerFleet {
	
	 private int customerId;
	 private int fleet_id;
	public CustomerFleet(int customerId, int fleet_id) {
		super();
		this.customerId = customerId;
		this.fleet_id = fleet_id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getFleet_id() {
		return fleet_id;
	}
	public void setFleet_id(int fleet_id) {
		this.fleet_id = fleet_id;
	}

}
