<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>H1 {text-align:center;}
       h2{text-align:center;}
       form{text-align:center;}
</style>
<meta charset="ISO-8859-1">

<title> New or Edit Customer</title>
</head>

<body>
<h2 style="color:green">New Customer </h2>
<h2><a href="/save"> Customer List</a></h2>
<form>
    ID:          <input type="text" name="customer_id" /><br/>	
	Name:          <input type="text" name="customer_name" /><br/>	
	Address_line_1:<input type="text" name="address_line_1" /><br/>	
	City:          <input type="text" name="city" /><br/>		
	Postal Code:   <input type="text" name="postal_code" /><br/>		
	State:         <input type="text" name="state" /><br/>		
	Country:       <input type="text" name="country" /><br/>		
	Latitude:      <input type="text" name="latitude" /><br/>		
	Longitude:     <input type="text" name="longitude" /><br/>		
	Personal Phone:<input type="text" name="business_phone" /><br/>		
	Business Phone:<input type="text" name="personal_phone" /><br/>		
	
	 <input type="submit" value="Save" />
	 
	 </form>	
	 </body>
	 </html>