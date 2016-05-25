package hw1;

import java.util.ArrayList;
import java.util.Date;

public class Appointment {
	public int appointmentID;
	public int appointmentAptID;
	public int appointmentUserID;
	public String appointmentStatus;
	public java.util.Date appointmentDate;
	public boolean appointmentAcceptDeny;
	public ArrayList<java.util.Date> ruledOutDates = new ArrayList<java.util.Date>();
	public Appointment(){}
	public Appointment(int appointmentID, int appointmentAptID, int appointmentUserID, String appointmentStatus) {
		super();
		this.appointmentID = appointmentID;
		this.appointmentAptID = appointmentAptID;
		this.appointmentUserID = appointmentUserID;
		this.appointmentStatus = appointmentStatus;
	}
	public int getAppointmentID() {
		return appointmentID;
	}
	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}
	public int getAppointmentAptID() {
		return appointmentAptID;
	}
	public void setAppointmentAptID(int appointmentAptID) {
		this.appointmentAptID = appointmentAptID;
	}
	public int getAppointmentUserID() {
		return appointmentUserID;
	}
	public void setAppointmentUserID(int appointmentUserID) {
		this.appointmentUserID = appointmentUserID;
	}
	public String getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	public java.util.Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(java.util.Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public boolean isAppointmentAcceptDeny() {
		return appointmentAcceptDeny;
	}
	public void setAppointmentAcceptDeny(boolean appointmentAcceptDeny) {
		this.appointmentAcceptDeny = appointmentAcceptDeny;
	}
	public ArrayList<java.util.Date> getRuledOutDates() {
		return ruledOutDates;
	}
	public void setRuledOutDates(ArrayList<java.util.Date> ruledOutDates) {
		this.ruledOutDates = ruledOutDates;
	}
	
	
	
}
