<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>table,th{width:50%;}.btn{margin-left:50%;}</style>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<title>Add Apartment</title>

</head>
<body>			
<center>
	<div class='container-fluid'>
		<div class='btn-group btn-group-justified'>
			<div class='btn-group'>
				<a  href='ManagerHome'>Back</a>
			</div>
			<div class='btn-group'>
			</div>
			<div class='btn-group'>
				<a href='Logout'>Sign Out</a>
			</div>
		</div>
		<h1 style='color:#5bc0de'>Lease Management System</h1>
		<h3>Add Apartment</h3>
		<div class='table-responsive'>
			<form method='post'>
				<table class='table'>
					<tr><td><strong>Apartment #</strong></td><td><input style='width:100%' type='text' name='apartment_no'></td></tr>
					<tr><td><strong>Type</strong></td><td><input type='radio' name='type' value='1 BHK'>1 BHK<br><input type='radio' name='type' value='2 BHK - 1 Bath'>2 BHK - 1 Bath<br><input type='radio' name='type' value='2 BHK - 2 Bath'>2 BHK - 2 Bath<br></td></tr>
					<tr><td><strong>Facilities</strong></td><td><textarea style="width:100%;box-sizing:border-box" name='facilities'></textarea></td></tr>
					<tr><td><strong>Maximum People</strong></td><td><input style='width:100%' type='number' name='max_people'></td></tr>
					<tr><td><strong>Rent</strong></td><td><input style='width:100%' type="number" name='rent'></td></tr>
					<tr><td><strong>Deposits</strong></td><td><input style='width:100%' type='number' name='deposits'></td></tr>
					<tr><td><input class='btn btn-info' name='submit1' type='submit' value='Submit'></td><td><input class='btn btn-info' type='submit' name='clear' value='Clear'></td></tr>
					<tr>
						<c:if test="${error!=null }">
							<div class='alert alert-warning fade-in'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Error!</strong><c:out value="${error }"></c:out></div>
						</c:if>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
</center>
</body>
</html>