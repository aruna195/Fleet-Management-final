package com.project.fleet;

public class FleetInfo {
	
	public FleetInfo() {
		
		super();
		
	}
	
	private int fleet_id;
	private String fleet_name;
	private String fleet_model;
	private String fleet_make;
	private double latitude;
	private double longitude;
	private String category; 
	private String serial_number;
	
	public int getFleet_id() {
		return fleet_id;
	}
	public void setFleet_id(int fleet_id) {
		this.fleet_id = fleet_id;
	}
	public String getFleet_name() {
		return fleet_name;
	}
	public void setFleet_name(String fleet_name) {
		this.fleet_name = fleet_name;
	}
	public String getFleet_model() {
		return fleet_model;
	}
	public void setFleet_model(String fleet_model) {
		this.fleet_model = fleet_model;
	}
	public String getFleet_make() {
		return fleet_make;
	}
	public void setFleet_make(String fleet_make) {
		this.fleet_make = fleet_make;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	} 
}
	
	

	
