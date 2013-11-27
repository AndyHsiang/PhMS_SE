package phms_se.process.helper;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;

import javax.swing.JOptionPane;

public class HelperMethods {
	public static String[] splitString(String str){
		String[] stringArray = str.split("[\\s:/,-]");
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
	
	//multiply bigdecimal values
	public static BigDecimal multiplyCost(int itemQuantity, BigDecimal itemPrice)
	{
		BigDecimal x = itemPrice.multiply(new BigDecimal(itemQuantity));
		return x;
	}
	public static BigDecimal totalCost(BigDecimal cost, BigDecimal currentCost){
		
		return currentCost.add(cost);
	}
	public static BigDecimal addOne(BigDecimal num){
		BigDecimal x = num.add(new BigDecimal(1));
		return x;
	}
	public static BigDecimal patientCost(BigDecimal a,BigDecimal total){
		BigDecimal patientCost= total.multiply(a);
		return patientCost;
	}
	public static String currencyFormat(BigDecimal n) {
	    return NumberFormat.getCurrencyInstance().format(n);
	}
	
	public static void warning(String msg) {

	    JOptionPane.showMessageDialog(null, "Attention!\n"+msg);
	}
}
