package phms_se.process.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Andy Hsiang
 */
public class InputChecker {
	
	/**username should be in all lowercase letters
	 * @param username
	 * @return true if username contains valid characters
	 */
	public static boolean userName(String username){
		if(username.matches("[a-zA-Z](\\w){8,29}"))
			return true;
		return false;
	}
	/**
	 * password should consist only letters and digits and length must be longer than
	 *  8 characters and less than 30 characters
	 * @param pass
	 * @return true if pass contains valid characters
	 */
	public static boolean password(String pass){
		if(pass.matches("(\\w){8,30}"))
			return true;
		return false;
	}
	/**
	 * full name should have 2 parts, check both by calling other method
	 * @param name
	 * @return true if name contains valid characters
	 */
	public static boolean fullName(String name){
		String[] temp = name.split(" ");
		if(name(temp[0])&&name(temp[1]))
			return true;
		return false;
	}
	public static boolean fullNameIgnoreCase(String name){
		String[] temp = name.split(" ");
		if(nameIgnoreCase(temp[0])&&nameIgnoreCase(temp[1]))
			return true;
		return false;
	}
	/**
	 * checks either fname or lname
	 * @param name
	 * @return true if valid
	 */
	public static boolean name(String name){
		if(name.matches("[A-Z][a-z]{2,30}"))
			return true;
		return false;
	}
	public static boolean nameIgnoreCase(String name){
		if(name.matches("[a-z]{2,30}"))
			return true;
		return false;
	}
	/**
	 * @param phone
	 * @return true if phone has 10 digits
	 */
	public static boolean phone(String phone){
		if(phone.matches("(\\d){10}"))
			return true;
		return false;
	}
	/**
	 * @param address
	 * @return true if address has all parts and valid
	 */
	public static boolean fullAddress(String address){
		return false;
	}
	/**
	 * @param address
	 * @return true if street address is correctly formed
	 */
	public static boolean streetAddress(String address){
		if(address.matches("(\\d)+(\\s)[a-zA-Z\\s\\.]+")&&address.length()<100)
			return true;
		return false;
	}
	/**
	 * @param city
	 * @return true if city is correctly formed
	 */
	public static boolean city(String city){
		if(city.matches("[A-Z][a-z]+(\\s[A-Z][a-z]+(\\.)?)*")&&city.length()<30)
			return true;
		return false;
	}
	/**
	 * @param state
	 * @return true if State has exactly 2 uppercase letters
	 */
	public static boolean state(String state){
		if(state.matches("[A-Z]{2}"))
			return true;
		return false;
	}
	/**
	 * @param zip
	 * @return true if zip is either 5 digits or 5 digits follow by - and 4 digits
	 */
	public static boolean zip(String zip){
		if(zip.matches("(\\d){5}(-(\\d){4})?"))
			return true;
		return false;
	}
	/**
	 * @param email
	 * @return true if email is correctly formed
	 */
	public static boolean email(String email){
		if(email.matches("(\\w)+(\\.(\\w)+)*@(\\w)+(\\.(\\w)+)*\\.[a-z]{3}")&&email.length()<100)
			return true;
		return false;
	}
	/**
	 * @param digits
	 * @return true if digits are all digits
	 */
	public static boolean digits(int digits){
		String s = ""+digits;
		if(s.matches("(\\d)+"))
			return true;
		return false;
	}
	/**
	 * overloaded digits
	 * @param digits
	 * @return true if digits are all digits
	 */
	public static boolean digits(String digits){
		if(digits.matches("(\\d)+"))
			return true;
		return false;
	}
	public static boolean dob(String dob){
		String[] d = dob.split("[-\\s\\:,]");
		
		Date date= new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		String[] today=modifiedDate.split("[-\\s\\:,]");
		
		if(d[0].length()!=4)
			return false;
		if(!digits(d[0]))
			return false;
		
		if(Integer.parseInt(d[0])>Integer.parseInt(today[0]))
			return false;
		else if (Integer.parseInt(d[0])==Integer.parseInt(today[0])){
			if(Integer.parseInt(d[1])>Integer.parseInt(today[1]))
				return false;
			else if (Integer.parseInt(d[1])==Integer.parseInt(today[1])){
				if (Integer.parseInt(d[2])>Integer.parseInt(today[2]))
					return false;
			}
		}
		if(d[1].length()==1 && (Integer.parseInt(d[1])>9||Integer.parseInt(d[1])<1))
			return false;
		else if (d[1].length()>2)
			return false;
		if(d[2].length()==1 && (Integer.parseInt(d[2])>9||Integer.parseInt(d[2])<1))
			return false;
		else if (d[2].length()>2)
			return false;

		if(!digits(d[1])||!digits(d[2]))
			return false;
		if(Integer.parseInt(d[1])>12||Integer.parseInt(d[1])<1){
			return false;
		}
		if(Integer.parseInt(d[2])>31||Integer.parseInt(d[2])<1)
			return false;

		return true;
	}
	public static boolean position(String position){
		 position=position.toLowerCase();
		 if(!position.equals("tech")||!position.equals("manager")||!position.equals("pharmacist")){
			 return false;}
		 else return true;
		 
	}
}
