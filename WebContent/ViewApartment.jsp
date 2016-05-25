<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,hw1.ApartmentDetails" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Apartments</title>
</head>
<body>
	<center>
	<div class='container-fluid'>
		<div class='btn-group btn-group-justified'>
		<div class='btn-group'><a  href='ManagerHome'>Back</a></div><div class='btn-group'></div><div class='btn-group'><a href='Logout'>Sign Out</a></div>
		</div>
		<h1 style='color:#5bc0de'>Lease Management System</h1>
		<p text-align='left'>Apartment Details</p>
		<div class='table-responsive'>
			<table class='table'>
				<tr><th>Apartment ID</th><th>Apartment Type</th><th>Facility</th><th>Max People</th><th>Rent</th><th>Deposit</th><th>Vacant</th><th>Change Availability</th><th>Appointments</th></tr>
				<c:set var="yes" value="YES"></c:set>
				<c:set var="no" value="NO"></c:set>
				<c:if test="${get_id!=null }">
					<c:forEach items="${Apartments } " var="apart">
						<c:if test="${get_id.equals(apart.apartment_id) }">
							<c:set target="${apart }" property="vacancy" value="true"></c:set>
						</c:if>
					</c:forEach>
				</c:if>
				<c:forEach items="${Apartments }" var="apart">
					<tr>
						<td><c:out value="${apart.apartment_id }"></c:out></td>
						<td><c:out value="${apart.apartment_type }"></c:out></td>
						<td><c:out value="${apart.facility }"></c:out></td>
						<td><c:out value="${apart.max_people }"></c:out></td>
						<td><c:out value="${apart.rent }"></c:out></td>
						<td><c:out value="${apart.deposit }"></c:out></td>
						<td>
							<c:if test="${apart.vacancy==true }">
								<c:out value="${yes }"></c:out>
							</c:if>
							<c:if test="${apart.vacancy==false }">
								<c:out value="${no }"></c:out>
							</c:if>
						</td>
						<td>
							<c:if test="${apart.vacancy==true }">
								<c:out value=" "></c:out>
							</c:if>
							<c:if test="${apart.vacancy==false }">
								<a href="ViewApartment?id=<c:out value='${apart.apartment_id }'></c:out>">Make Available</a>
							</c:if>
						</td>
						<td>
							<c:if test="${apart.vacancy==true }">
								<a href="ViewAppointment?aptID=<c:out value='${apart.apartment_id }'></c:out>">View Appointment</a>
							</c:if>
							<c:if test="${apart.vacancy==false }">
								<c:out value=" "></c:out>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	</center>
</body>
</html>