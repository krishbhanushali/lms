package hw1;

public class UserDetail {
	public int userID;
	public String username;
	public String password;
	public String email;
	public String contact_no;
	public String no_of_people;
	public String occupation;
	public String type;
	public String preferences;
	public boolean isManager=false;
	public boolean isProspect=false;
	public java.util.Date from_date;
	
	public UserDetail(int userID,String username,String password, String email,boolean isManager)
	{
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isManager = isManager;
	}
	public UserDetail(int userID,String username,String password, String email,String contact_no,String no_of_people
			,String occupation, String type,String preferences,java.util.Date from_date,boolean isProspect)
	{
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.contact_no = contact_no;
		this.no_of_people = no_of_people;
		this.occupation = occupation;
		this.type = type;
		this.preferences = preferences;
		this.from_date = from_date;
		this.isProspect = isProspect;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getNo_of_people() {
		return no_of_people;
	}
	public void setNo_of_people(String no_of_people) {
		this.no_of_people = no_of_people;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPreferences() {
		return preferences;
	}
	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	public boolean isProspect() {
		return isProspect;
	}
	public void setProspect(boolean isProspect) {
		this.isProspect = isProspect;
	}
	public java.util.Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(java.util.Date from_date) {
		this.from_date = from_date;
	}
	
}

