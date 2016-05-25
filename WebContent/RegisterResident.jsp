<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>table,th{width:auto !important}.btn{margin-left:50%;}</style>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="datetimepicker-master/jquery.datetimepicker.min.css">

<script type="text/javascript" src="datetimepicker-master/jquery.datetimepicker.full.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<script>
	$(document).ready(function(){
		$("#date").datepicker();
	});
</script>
<title>Registration Page</title>
</head>
<body>
<body>
<center>
	<div class='btn-group btn-group-justified'>
		<div class='btn-group'><a href='Login'>Back</a></div><div class='btn-group'></div>
	</div>
	<div class='container-fluid'>
		<div class='table-responsive'>
			<form method='post'>
				<table class='table'>
					<tr><h3 style="color:#5bc0de">Registration Page</h3></tr>
					<tr><td>Username :</td><td><input style='width:100%' type='text' name='username' required></td></tr>
					<tr><td>Password :</td><td><input style='width:100%' type='password' name='password' required></td></tr>
					<tr><td>Confirm Password :</td><td><input style='width:100%' type='password' name='confirm_password' required></td></tr>
					<tr><td>Email :</td><td><input style='width:100%' type='text' name='email' required></td></tr>
					<tr><td>Contact # :</td><td><input style='width:100%' type='number' maxlength="10" name='contact_no' required></td></tr>
					<tr><td># People :</td><td><input style='width:100%' type='number' name='no_of_people' required></td></tr>
					<tr><td>Occupation :</td><td><input type='radio' name='occupation' value='Student'>Student<br><input type='radio' value='Family' name='occupation'>Family<br><input type='radio' value='Business' name='occupation'>Business</td></tr>
					<tr><td>Type :</td><td><input type='radio' name='type' value='1 BHK'>1 BHK<br><input type='radio' name='type' value='2 BHK - 1 Bath'>2 BHK - 1 Bath<br><input type='radio' name='type' value='2 BHK - 2 Bath'>2 BHK - 2 Bath<br></td></tr>
					<tr><td>Preferences :</td><td><textarea style='width=100%'  type='text' name='preferences' required></textarea></td></tr>
					<tr><td>Need from date :</td><td><input style='width:100%' id="date" type="text" name='from_date' required></td></tr>
					<tr><td><input class='btn btn-info' type='submit' name='submitForm' value='Submit'></td><td><input class='btn btn-info' type='submit' name='clearForm' value='Clear'></td></tr>
					<tr>
						<c:if test="${error!=null }">
							<div class='alert alert-warning fade-in'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Error!</strong><c:out value="${error }"></c:out></div>
						</c:if>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<a href='Login'> Back</a>
</center>
</body>
</html>