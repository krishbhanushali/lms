<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<style>.padding8{margin:8px;}.doBorder{border:4px solid #5bc0de;}.container-fluid{margin:10px; width:90%;}</style>
<title>Manager Home</title>
</head>
<body>		
<center>
	<div class="container-fluid doBorder">
		<h1 style="color:#5bc0de;">Lease Management System</h1>
		<table>
			<tr><td style="text-align:right"><strong>Welcome <c:out value="${Username }"></c:out> !</strong><a style="text-align:right" href="Logout">Sign Out</a></td></tr>
			<tr><td style="float:left"><a href="AddApartment">Add Apartment</a></td>
			<td><a href="ViewApartment">View Apartment</a></td></tr>
		</table>
	</div>
</center>			
</body>
</html>