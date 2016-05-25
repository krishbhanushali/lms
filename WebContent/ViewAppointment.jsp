<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,hw1.ApartmentDetails,hw1.Appointment,hw1.UserDetail" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<title>View Appointments</title>
</head>
<body>
<center>
<div class="container-fluid">
	<div class='btn-group btn-group-justified'>
			<div class='btn-group'><a href="ViewApartment">Back</a></div>
			<div class="btn-group"></div>
			<div class='btn-group'>
				<a href='Logout'>Sign Out</a>
			</div>
	</div>
	<h1 style='color:#5bc0de'>Lease Management System</h1>
	<p>Apartment Details</p>
	<div class="table-responsive .table-bordered .table-striped">
		<table style="width:50%" class="table">
			<c:set var="aptID" value="${aptID }"></c:set>
			<fmt:parseNumber var="aptIDNumber" type="number" value="${aptID }" />
			
			<c:forEach items="${Apartments }" var="apart">	
				<c:if test="${apart.apartment_id==aptID }">
				 	<tr><td>Apartment #</td><td><c:out value="${apart.apartment_id }"></c:out></td></tr>
					<tr><td>Type</td><td><c:out value="${apart.apartment_type }"></c:out></td></tr>
					<tr><td>Facilities</td><td><c:out value="${apart.facility }"></c:out></td></tr>
					<tr><td>Maximum people</td><td><c:out value="${apart.max_people }"></c:out></td></tr>
					<tr><td>Rent</td><td><c:out value="${apart.rent }"></c:out></td></tr>
					<tr><td>Deposit</td><td><c:out value="${apart.deposit }"></c:out></td></tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
	<h3 style='color:#5bc0de'>Applications for this Apartment</h3>
	<div style="width:100%" class="table-responsive .table-bordered .table-striped">
		<table class="table">
			<th>Application #</th><th>Application Name</th><th>Contact #</th><th># of People</th><th>Occupation</th><th>Preferences</th>
			<th>Need from date</th><th>Status</th><th>Reschedule Date</th><th>Ruled out Dates</th><th>Rented out</th>
			<c:forEach items="${Appointments }" var="appoint">
				<c:if test="${appoint.appointmentAptID == aptID }">
					<c:set var="userID" value="${appoint.appointmentUserID }"></c:set>
					<c:forEach items="${Users }" var="user">
						<c:if test="${user.userID==userID }">
							<tr>
								<td><c:out value="${appoint.appointmentID }"></c:out></td>
								<td><c:out value="${user.username }"></c:out></td>
								<td><c:out value="${user.contact_no }"></c:out></td>
								<td><c:out value="${user.no_of_people }"></c:out></td>
								<td><c:out value="${user.occupation }"></c:out></td>
								<td><c:out value="${user.preferences }"></c:out></td>
								<td><c:out value="${user.from_date }"></c:out></td>
								<td><c:out value="${appoint.appointmentStatus }"></c:out></td>
								<c:choose>
									<c:when test="${appoint.appointmentStatus.equals('Rented Out') }">
										<td><p>Cannot Reschedule. Apartment is rented out.</p></td>
									</c:when>
									<c:when test="${appoint.appointmentStatus.equals('Accepted') }">
										<td><p>Appointment scheduled at <c:out value="${appoint.appointmentDate }"></c:out></p></td>
									</c:when>
									<c:otherwise>
										<td>
											<form method="post">
												<c:if test="${error!=null }">
													<div class='alert alert-warning fade-in'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Error! </strong><c:out value="${error }"></c:out></div>
												</c:if>
												<input name="apartmentID" type="hidden" value="<c:out value="${aptID }"></c:out>"> 
												<input name="appointmentID" type="hidden" value="<c:out value="${appoint.appointmentID }"></c:out>">
												<input name="appointmentDate" type='text' required/>
												<c:if test="${appoint.ruledOutDates.isEmpty() }">
													<input class="btn btn-info" type="submit" value="Schedule">												
												</c:if>
												<c:if test="${!appoint.ruledOutDates.isEmpty() }">
													<input class="btn btn-info" type="submit" value="Reschedule">												
												</c:if>
											</form>
										</td>
									</c:otherwise>
								</c:choose>
								<c:set var="i" value="1"></c:set>
								<td>
									<c:forEach items="${appoint.ruledOutDates }" var="dates" varStatus="loopIndex">
										<c:out value="${i }"></c:out>)
										<c:out value="${dates }"></c:out>
										<c:set var="i" value="${i+1 }"></c:set>
										<br>
									</c:forEach>
								</td>
								<td>
									<c:choose>
									<c:when test="${appoint.appointmentStatus=='Accepted' }">
										<a href="RentOut?userID=<c:out value='${user.userID }'></c:out>&apartmentID=<c:out value='${appoint.appointmentAptID }'></c:out>">Rent out</a>
									</c:when>
									<c:otherwise>
										<p>Rent Out</p>
									</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</c:if>
			</c:forEach>
		</table>
	</div>
</div>
</center>
</body>
</html>