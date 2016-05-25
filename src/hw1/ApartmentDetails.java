package hw1;

public class ApartmentDetails {
	public String apartment_id;
	public String apartment_type;
	public String facility;
	public String max_people;
	public String rent;
	public String deposit;
	public boolean vacancy;
	
	ApartmentDetails(String apartment_id,String apartment_type,String facility,String max_people,
			String rent,String deposit, boolean vacancy){
		this.apartment_id = apartment_id;
		this.apartment_type = apartment_type;
		this.facility = facility;
		this.max_people = max_people;
		this.rent= rent;
		this.deposit = deposit;
		this.vacancy = vacancy;
	}

	public String getApartment_id() {
		return apartment_id;
	}

	public void setApartment_id(String apartment_id) {
		this.apartment_id = apartment_id;
	}

	public String getApartment_type() {
		return apartment_type;
	}

	public void setApartment_type(String apartment_type) {
		this.apartment_type = apartment_type;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public String getMax_people() {
		return max_people;
	}

	public void setMax_people(String max_people) {
		this.max_people = max_people;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public boolean isVacancy() {
		return vacancy;
	}

	public void setVacancy(boolean vacancy) {
		this.vacancy = vacancy;
	}
	
}
