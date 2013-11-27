package phms_se.process;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import phms_se.database.DatabaseProcess;
import phms_se.database.bean.Drug;
import phms_se.database.bean.Employee;
import phms_se.database.bean.Patient;
import phms_se.database.bean.Schedule;
import phms_se.gui.Gui;
import phms_se.gui.ManageEmployeePage;
import phms_se.gui.NewEmployeePage;
import phms_se.gui.NewPatientPage;
import phms_se.gui.newSchedule;
import phms_se.process.helper.HelperMethods;
import phms_se.process.helper.InputChecker;

/**
 * @author Andy Hsiang
 */
public class ManageEmployee {
	/**
	 * @param bean
	 * @return
	 */
	public static boolean addNewEmployee(NewEmployeePage newEmployee){
		
		Date dob = HelperMethods.getDate(newEmployee.getDob());
		
		Employee newEmp = new Employee();
		newEmp.setName(newEmployee.getEmpName().getText());
		newEmp.setUsername(newEmployee.getEmpUsername().getText());
		newEmp.setDob(dob);
		newEmp.setPass(newEmployee.getPassword().getText());
		newEmp.setPhone(newEmployee.getEmpPhone().getText());
		newEmp.setAddress(newEmployee.getEmpAddress().getText());
		newEmp.setEmail(newEmployee.getEmpEmail().getText());
		newEmp.setPosition(newEmployee.getEmpPosition().getText());
		
		return DatabaseProcess.insert(newEmp);
		}
	/**
	 * @param username
	 * @return
	 */
	public static boolean deleteEmployee(ManageEmployeePage empPage){
		int row= empPage.getRow();
	String username=	empPage.getTable().getValueAt(row, 1).toString();
	Employee bean=new Employee();
	bean.setUsername(username);
	DatabaseProcess.delete(bean);
		return false;
	}
	/**
	 * @param bean
	 * @return
	 */
	public static boolean modifyEmployee(ManageEmployeePage empPage, Employee bean){
		//check if phone number has changed
		if(!empPage.getPhoneText().getText().equals(bean.getPhone())){
			//check if the field formatted correctly
			if(InputChecker.phone(empPage.getPhoneText().getText())){
				bean.setPhone(empPage.getPhoneText().getText());
				DatabaseProcess.modifyRow(bean, "phone");
			}else {
				System.out.println("wrong phone field format");
				return false;
			}
		}
		//check if address has changed
		if(!empPage.getAddressText().getText().equals(bean.getAddress())){
			//check if the field formatted correctly
			if(InputChecker.streetAddress(empPage.getAddressText().getText())){
				bean.setAddress(empPage.getAddressText().getText());
				DatabaseProcess.modifyRow(bean, "address");
			}else {
				System.out.println("wrong address format");
				return false;
			}
		}
		//check if position has changed
		if(!empPage.getPositionText().getText().equals(bean.getPosition())){
			//check if the field formatted correctly
			if(InputChecker.position(empPage.getPositionText().getText())){
				bean.setPosition(empPage.getPositionText().getText());
				DatabaseProcess.modifyRow(bean, "position");
			}else {
				System.out.println("wrong position field format");
				return false;
			}
		}
//		//check if email has changed
//		if(!empPage.getEmailText().getText().equals(bean.getEmail())){
//			//check if the field formatted correctly
//			if(InputChecker.email(empPage.getEmailText().getText())){
//				bean.setEmail(empPage.getEmailText().getText());
//				DatabaseProcess.modifyRow(bean, "email");
//			}else {
//				System.out.println("wrong email field format");
//				return false;
//			}
//		}
		
		//i didnt not do this for salary and work hours because these are supposed to be handled seperately in schedules
		return true;
	}
	/**
	 * @param username
	 * @param schedule
	 * @return
	 * @throws ParseException 
	 */
	public static boolean addNewSchedule() throws ParseException{
		newSchedule.getEnd();
		String s = newSchedule.getStart().getText();
		//System.out.println(s);
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		long ms = sdf.parse(s).getTime();
		Time start = new Time(ms);
		String e = newSchedule.getEnd().getText();
		SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");
		long d = sdf.parse(s).getTime();
		Time end = new Time(ms);
		String wageget =newSchedule.getWage().getText();
		BigDecimal wage=new BigDecimal(wageget);
		int vacationDays=Integer.parseInt(newSchedule.getVacation().getText());
		int year = 113;
		int day = 22;
		int month = 04;
		Date work = new Date(year,month,day);
		Employee bean=Gui.getCurrentEmployee();
		String username=bean.getUsername();
		Schedule sched= new Schedule();
		sched.setFrom(start);
		sched.setTo(end);
		sched.setHourRate(wage);
		sched.setUsername(username);
		sched.setVacationDays(vacationDays);
		sched.setWorkDay(work);
		DatabaseProcess.insert(sched);
		return false;
	}
	/**
	 * @param username
	 * @param schedule
	 * @return
	 */
	public static boolean modifySchedule(String username, Schedule schedule){
		return false;
	}
	/**
	 * @param username
	 * @param schedule
	 * @return
	 */
	public static boolean removeSchedule(String username, Schedule schedule){
		return false;
	}
	/**
	 * @param emp
	 * @param schedule
	 */
	public static void generateReport(Employee emp, Schedule schedule){
		
	}
	
	public static void clearTable(ManageEmployeePage manageEmp){
		int rows= manageEmp.getTable().getRowCount();
		int i=0;
		while(i<rows){
			manageEmp.getTable().setValueAt("",i,0);
			manageEmp.getTable().setValueAt("",i,1);
			i++;
		}
		
	}
	public static void fillEmployeeTable (ManageEmployeePage manageEmp){
		String realname = null;
		String username=null;
		clearTable(manageEmp);
		ArrayList<String> names=new ArrayList<String>();
		names= DatabaseProcess.getEmployeeNames();
		int j=0;
		int i=0;
		//manageEmp.getTable().
		for(;i<names.size();i++,j++){
			realname= names.get(i);
			manageEmp.getTable().setValueAt(realname, j, 0);
			
			username=names.get(++i);
		manageEmp.getTable().setValueAt(username, j, 1);}
		
	}
	public static void populateEmployeeInfo(ManageEmployeePage emp,String username){
		Employee employee=new Employee();
		employee.setUsername(username);
		employee=(Employee)DatabaseProcess.getRow(employee);
		Gui.setCurrentEmployee(employee);
		emp.getDobText().setText(employee.getDob().toString());
		emp.getAddressText().setText((employee.getAddress()));
		emp.getPhoneText().setText(employee.getPhone());
		emp.getNameText().setText(employee.getName());
		emp.getPositionText().setText(employee.getPosition());
		Schedule s=new Schedule();
		s.setUsername(username);
		int year = 113;
		int day = 22;
		int month = 04;
		Date work = new Date(year,month,day);
		s.setWorkDay(work);
		if(DatabaseProcess.getRow(s) != null){
			s=(Schedule)DatabaseProcess.getRow(s);
		String str = s.getHourRate().toString();
		String str2 = "$"+str;
		emp.getSalaryText().setText(str2);
		Time t = s.getFrom();
		Time t2 = s.getTo();
		String str3 = t + " - " + t2;
		emp.getSchedule().setText(str3);}
		else{
			emp.getSalaryText().setText("");
			emp.getSchedule().setText("");
		}
	}
	public static boolean verifyNewEmployee(NewEmployeePage newEmp){
		if(InputChecker.fullName(newEmp.getEmpName().getText())){
			
			if(!newEmp.getEmpUsername().getText().equals("")){
				
				if(!newEmp.getPassword().getText().equals("")){
					if(!newEmp.getEmpEmail().getText().equals("")){
						if(!InputChecker.position(newEmp.getEmpPosition().getText())){
						
							if(InputChecker.phone(newEmp.getEmpPhone().getText())){
						
								if(newEmp.getEmpAddress().getText()!=null){
							
									if(newEmp.getDob()!=null){
										if(InputChecker.dob(newEmp.getDob()))
											return true;
										else{ System.out.println("invalid format for Dob");
											newEmp.getWarning().setText("invalid format for Dob");}
									}else{
										System.out.println("wrong format for DoB");
										newEmp.getWarning().setText("wrong format for DoB");}
								}else{
									System.out.println("wrong format for address");
									newEmp.getWarning().setText("wrong format for address");}
							}else{
									System.out.println("wrong format for phone");
									newEmp.getWarning().setText("wrong format for phone");}
						}else {newEmp.getWarning().setText("Incorrect Position");}
					}else{newEmp.getWarning().setText("Incorrect Email format");}
				}else{newEmp.getWarning().setText("incorrect password");}
			}else{newEmp.getWarning().setText("incorrect username");}
		}else{
			System.out.println("wrong format for name");
			newEmp.getWarning().setText("wrong format for name");}
		return false;
	}
	public static void clearNewEmployee(NewEmployeePage newEmp){
		newEmp.getEmpName().setText("");
		newEmp.getEmpUsername().setText("");
		newEmp.getPasswordForClear().setText("");
		newEmp.getEmpPhone().setText("");
		newEmp.getEmpAddress().setText("");
		newEmp.getEmpEmail().setText("");
		newEmp.getEmpPosition().setText("");
		newEmp.getConfirmPassword().setText("");
		newEmp.getWarning().setText("");
		
	}
}
