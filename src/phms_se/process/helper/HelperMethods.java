package phms_se.process.helper;

import java.sql.Date;

public class HelperMethods {
	
	public static String[] splitString(String str){
		String[] stringArray = str.split("[ :/,-]");
		return stringArray;
	}
	
	//this method extracts/creates date object from a string representing a date
	public static Date getDate(String s){
		String[] d = s.split("[-\\s\\:,]");
		
		int year = Integer.parseInt(d[0]);
		
		int month = Integer.parseInt(d[1]);
		int day = Integer.parseInt(d[2]);
		@SuppressWarnings("deprecation")
		Date dob = new Date(year-1900, month-1, day);
		
		return dob;
	}
	
	//cap first letter
	public static String capFirst(String s){
		return (s.charAt(0)+"").toUpperCase()+s.substring(1);
	}
}
