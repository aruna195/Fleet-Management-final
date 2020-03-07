<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>H1 {text-align:center;}
       H2 {text-align:center;}
</style>
<meta charset="ISO-8859-1">

<title>FleetList</title>
</head>

<body>

 <H1 style="color:green">FleetList</H1>
   
   <table border="1" cellpadding="10">
     <tr>
     <th>Fleet IDs</th> 
     <th>Fleet Name</th>
     <th>Fleet Model </th>
     <th>Fleet Make </th>
     <th>Latitude </th>
     <th>Longitude </th>
     <th>Category </th>
     <th>Serial Number </th>   

     
   </tr>
   <c:forEach items="${FleetList}" var="fleet">
     <tr>
         <td>${fleet.fleet_id}</td> 
         <td>${fleet.fleet_name}</td> 
         <td>${fleet.fleet_model}</td> 
         <td>${fleet_make}</td>
         <td>${fleet.latitude}</td> 
         <td>${fleet.longitude}</td>
         <td>${fleet.category}</td> 
         <td>${fleet.serial_number}</td>      
            
        
      </tr>  
      </c:forEach>  
   </table>
   

</body>
</html>

