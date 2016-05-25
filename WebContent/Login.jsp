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
<style>.padding8{margin-bottom:8px;}.doBorder{border:10px solid #5bc0de;}.container-fluid{margin:10px; width:90%;}</style>
<title>Login Page</title>
</head>
<body>

<center>
<div class='container-fluid doBorder'>
<h1 style='color:#5bc0de'>Lease Management System</h1>
<div>
<form method='post'>
<table>
	<tr><td><td><h3>Login Page</h3></td></tr>
	<tr><td style='padding-right:5px'>Email Id</td><td><input class='padding8 form-control' type='text' name='username'></td></tr>
	<tr><td style='padding-right:5px'>Password </td><td><input class='form-control' type='password' name='password'></td></tr>
	<tr><td></td><td><input class='btn btn-info' style='margin:20px 10px 10px 10px;padding:5px 5px 5px 5px' name='submit1' type='submit' value='Login'><input class='btn btn-info' style='margin:20px 10px 10px 10px;padding:5px 5px 5px 5px' type='submit' name='clear' value='Clear'></td></tr>
	<tr>
	<c:if test="${error!=null }">
	<div class='alert alert-warning fade-in'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Error!</strong><c:out value="${error }"></c:out></div>
	</c:if>
	
	</tr>
	
	<tr><td></td><td><a href='RegisterResident'>Register for Prospects</a></td></tr>
</table>
</form>
</div>
</div>
</center>		
				
</body>
</html>