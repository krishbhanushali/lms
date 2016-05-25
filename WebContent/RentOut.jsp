<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="datetimepicker-master/jquery.datetimepicker.min.css">

<script type="text/javascript" src="datetimepicker-master/jquery.datetimepicker.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<script>
	$(document).ready(function(){
		$("#date").datepicker();
	});
</script>
<title>Rent out</title>
</head>
<body>
<center>
	<div class="container-fluid">
		<div>
		<div class='btn-group btn-group-justified'>
		<div class='btn-group'><a  href='ManagerHome'>Back</a></div><div class='btn-group'></div><div class='btn-group'><a href='Logout'>Sign Out</a></div>
		</div>
		<h3 style='color:#5bc0de'>Rent Out</h3>
		<div style="width:80%" class="table-responsive">
		<form method="post">
			<input type="hidden" name="apartmentID" value="<c:out value='${apartmentID }'></c:out>">
			<input type="hidden" name="userID" value="<c:out value='${userID }'></c:out>">
			<table class="table">	
				<tr><td>Lease Termination date</td><td><input type="text" id="date" name="leaseTerminationDate" required></td></tr>
				<tr><td>Lease Holder Name</td><td><input type="text" name="leaseHolderName" required></td></tr>
				<tr><td>List of documents</td><td><input type="checkbox" value="1" name="passport">Passport<br><input type="checkbox" value="1" name="calID">California ID<br><input type="checkbox" value="1" name="license">Driver's License<br></td></tr>
				<tr><td>Rent</td><td><input type="text" name="rent" required></td></tr>
				<tr><td>Deposit</td><td><input type="text" name="deposit" required></td></tr>
				<tr><td><input class="btn btn-info" type="submit" name="submit" value="Submit"></td><td><input class="btn btn-info" type="submit" name="clear" value="Clear"></td></tr>
			</table>
		</form>
		</div>
		</div>
	</div>
</center>
</body>
</html>