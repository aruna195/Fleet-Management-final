package com.project.fleet;

public class Customer {
	
		   public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

		private String customerName;
		   private int customerId;
		   private String address_line_1; 
		   private String city; 
		   private String state ;
		   private String country; 
		   private String postal_code; 
		   private double latitude;
		   private double longitude;
		   private String business_phone;
		   private String personal_phone;
		   Customer(String customerName, int customerId){
		      this.setCustomerName(customerName);
		      this.setCustomerId(customerId);
		   }

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getPostal_code() {
			return postal_code;
		}

		public void setPostal_code(String postal_code) {
			this.postal_code = postal_code;
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

		public String getBusiness_phone() {
			return business_phone;
		}

		public void setBusiness_phone(String business_phone) {
			this.business_phone = business_phone;
		}

		public String getPersonal_phone() {
			return personal_phone;
		}

		public void setPersonal_phone(String personal_phone) {
			this.personal_phone = personal_phone;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getAddress_line_1() {
			return address_line_1;
		}

		public void setAddress_line_1(String address_line_1) {
			this.address_line_1 = address_line_1;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
}


