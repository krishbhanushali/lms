<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,hw1.ApartmentDetails,hw1.Appointment" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
<script type='text/javascript' src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<title>Look Up Apartments</title>
</head>
<body>
<center>				
	<div class='container-fluid'>
		<div class='btn-group btn-group-justified'>
			<div class='btn-group'></div>
			<div class='btn-group'>
				<a href='Logout'>Sign Out</a>
			</div>
		</div>
		<h1 style='color:#5bc0de'>Lease Management System</h1>
		<center>
		<h3>Welcome <c:out value="${Username }"></c:out> !</h3><br>
		<p>Apartment Details</p>
		<div class='table-responsive'>
		<table class='table'>
			<tr><th>Apartment ID</th><th>Apartment Type</th><th>Facility</th><th>Max People</th><th>Rent</th><th>Deposit</th><th>Appointment Date</th><th>Operation</th></tr>
			<c:set var="userID" value="${userID }"></c:set>
			<c:forEach items="${Apartments }" var="apart">
				<c:set var="result" value="true"></c:set>
				<c:set var="dummy"></c:set>
					<c:forEach items="${Appointments }" var="appoint">
						<c:if test="${appoint.appointmentAptID==Integer.parseInt(apart.apartment_id) && appoint.appointmentUserID==userID }">
							<c:set var="result" value="false"></c:set>
							<c:set var="dummy" value="${appoint }"></c:set>
						</c:if>
					</c:forEach>
					<c:if test="${apart.vacancy==true }">
						<!-- if vacant and user has requested for appointments -->
						<c:if test="${result==false }">
							<tr>
								<td><c:out value="${apart.apartment_id }"></c:out></td>
								<td><c:out value="${apart.apartment_type }"></c:out></td>
								<td><c:out value="${apart.facility }"></c:out></td>
								<td><c:out value="${apart.max_people }"></c:out></td>
								<td><c:out value="${apart.rent }"></c:out></td>
								<td><c:out value="${apart.deposit }"></c:out></td>
								<c:if test="${apart.vacancy==true }">
									<td>
										<c:if test="${dummy.appointmentDate!=null }">
											<c:out value="${dummy.appointmentDate }"></c:out>
										</c:if>
										<c:if test="${dummy.appointmentDate==null }">
											<p>N. A</p>
										</c:if>
									</td>
									<td>
										<c:if test="${dummy.appointmentStatus=='Waiting' }">
											<form method="post">
												<input type="hidden" name="appointmentID" value="<c:out value='${dummy.appointmentID }'></c:out>">
												<input type="hidden" name="apartmentID" value="<c:out value='${apart.apartment_id }'></c:out>">
												<input class="btn btn-info" type="submit" name="accept" value="Accept">
												<input class="btn btn-info" type="submit" name="deny" value="Deny">
											</form>
										</c:if>
										<c:if test="${dummy.appointmentStatus=='Requested' }">
											<c:out value="${dummy.getAppointmentStatus() }"></c:out>
										</c:if>
										<c:if test="${dummy.appointmentStatus=='Accepted' }">
											<c:out value="You accepted the appointment Date ${dummy.appointmentDate }"></c:out>
										</c:if>
										<c:if test="${dummy.appointmentStatus=='Denied' }">
											<c:out value="You denied the appointment Date ${dummy.appointmentDate }"></c:out>
										</c:if>
									</td>
								</c:if>
							</tr>
						</c:if>
						<!-- next if loop if vacant and user has not requested for appointment -->
						<c:if test="${result==true }">
							<tr>
								<td><c:out value="${apart.apartment_id }"></c:out></td>
								<td><c:out value="${apart.apartment_type }"></c:out></td>
								<td><c:out value="${apart.facility }"></c:out></td>
								<td><c:out value="${apart.max_people }"></c:out></td>
								<td><c:out value="${apart.rent }"></c:out></td>
								<td><c:out value="${apart.deposit }"></c:out></td>
								<td><c:out value="N. A"></c:out></td>
								<td><a href="RequestMapping?userID=<c:out value='${userID }'></c:out>&aptID=<c:out value='${apart.apartment_id }'></c:out>">Request Appointment</a></td>									
							</tr>
						</c:if>
					</c:if>
			</c:forEach>
		
		</table>	
		</div>
		</div>
</center>
</body>
</html>