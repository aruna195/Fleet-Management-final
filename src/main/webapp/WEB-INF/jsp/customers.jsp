<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>H1 {text-align:center;}
       H2 {text-align:center;}
</style>
<meta charset="ISO-8859-1">

<title>CustomerList</title>
</head>

<body>

 <H1 style="color:green">Customer List</H1>
    <form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
 <h3><a href="/new">New Customer</a></h3>
   
   <table border="1" cellpadding="10">
     <tr>
     <th>Customer IDs</th> 
     <th>Customer Name</th>
     <th>Address </th>
     <th>City </th>
     <th>State </th>
     <th>Country </th>
     <th>Postal Code </th>
     <th>Latitude </th>
     <th>Longitude </th>
     <th>Business Phone </th>
     <th>Personal Phone </th>   

     
   </tr>
   <c:forEach items="${CustomerList}" var="customer">
     <tr>
         <td>${customer.customerId}</td> 
         <td>${customer.customerName}</td> 
         <td>${customer.address_line_1}</td> 
         <td>${customer.city}</td>
         <td>${customer.state}</td>
         <td>${customer.country}</td>
         <td>${customer.postal_code}</td>
         <td>${customer.latitude}</td> 
         <td>${customer.longitude}</td>
         <td>${customer.business_phone}</td> 
         <td>${customer.personal_phone}</td>          
         <td>
                <a href="/edit?id=${customer.id}">Edit</a>
                &nbsp;&nbsp;&nbsp;
                <a href="/delete?id=${customer.id}">Delete</a>
            </td>    
        
      </tr>  
      </c:forEach>  
   </table>
   

</body>
</html>


