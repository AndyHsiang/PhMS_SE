package phms_se.database.bean;

import java.sql.Date;

public class Patient {
	private final static String tableSchema = "FIRSTNAME,LASTNAME,DOB,PRIMARYDOC,PHONE,ADDRESS,CITY,STATE,ZIP";

	private int pid;
	private String firstName, lastName, primaryDoc, phone, address, city, state, zip;
	private Date dob;
	
	//Constructor
	public Patient(){
		
	}
	/***
	 * all getters and setters for the fields start here
	 */
	public int getPid() {
		return pid;
	}
	/**
	 * @param pid
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}
	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return
	 */
	public String getPrimaryDoc() {
		return primaryDoc;
	}
	/**
	 * @param primaryDoc
	 */
	public void setPrimaryDoc(String primaryDoc) {
		this.primaryDoc = primaryDoc;
	}
	/**
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * @param dob
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return
	 */
	public static String getTableSchema() {
		return tableSchema;
	}
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", primaryDoc=" + primaryDoc
				+ ", phone=" + phone + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", dob=" + dob
				+ "]";
	}
}
