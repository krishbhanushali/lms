package hw1;

import java.util.Date;

public class RentOutDetails {
	public int rentOutID;
	public int rentOutUserID;
	public int rentOutApartmentID;
	public java.util.Date rentOutTerminationDate;
	public String rentOutLeaseHolderName;
	public String rentOutDocuments[];
	public int rentOutRent;
	public int rentOutDeposit;
	public RentOutDetails(int rentOutID, int rentOutUserID, int rentOutApartmentID, Date rentOutTerminationDate,
			String rentOutLeaseHolderName, String[] rentOutDocuments, int rentOutRent, int rentOutDeposit) {
		super();
		this.rentOutID = rentOutID;
		this.rentOutUserID = rentOutUserID;
		this.rentOutApartmentID = rentOutApartmentID;
		this.rentOutTerminationDate = rentOutTerminationDate;
		this.rentOutLeaseHolderName = rentOutLeaseHolderName;
		this.rentOutDocuments = rentOutDocuments;
		this.rentOutRent = rentOutRent;
		this.rentOutDeposit = rentOutDeposit;
	}
	
}
