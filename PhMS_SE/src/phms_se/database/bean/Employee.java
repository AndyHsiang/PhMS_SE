package phms_se.database.bean;

import java.sql.Date;

public class Employee {
	private final static String tableSchema = "NAME,USERNAME,PASS,DOB,PHONE,ADDRESS,EMAIL,POSITION";
	
	private String name, username, pass, phone, address, email, position;
	private Date dob;
	
	//empty constructor
	public Employee(){}
	
	/** getter
	 * @return string representation of emplyee's name
	 */
	public String getName() {
		return name;
	}
	
	/** setter: sets employee's name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** getter
	 * @return string representation of employee's username
	 */
	public String getUsername() {
		return username;
	}
	
	/** setter: sets employee's username to username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/** getter
	 * @return string representation of employee's password
	 */
	public String getPass() {
		return pass;
	}
	
	/** setter: sets employee's password to pass
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/** getter
	 * @return string representation of employee's phone number
	 */
	public String getPhone() {
		return phone;
	}
	
	/** setter: sets employee's phone number to phone
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/** getter
	 * @return string representation of employee's address
	 */
	public String getAddress() {
		return address;
	}
	
	/** setter: sets employee's address to address
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/** getter
	 * @return string representation of employee's email
	 */
	public String getEmail() {
		return email;
	}
	
	/** setter: sets employee's email to email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/** getter
	 * @return string representation of employee's position
	 */
	public String getPosition() {
		return position;
	}
	
	/** setter: sets the employee's position to position
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/** getter
	 * @return employee's date of birth as Date type
	 */
	public Date getDob() {
		return dob;
	}
	
	/** setter: sets employee's date of birth to dob
	 * @param dob
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	/** getter
	 * @return string representation of table schema for employee table in database
	 */
	public static String getTableSchema() {
		return tableSchema;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", username=" + username + ", pass="
				+ pass + ", phone=" + phone + ", address=" + address
				+ ", email=" + email + ", position=" + position + ", dob="
				+ dob + "]";
	}
}
