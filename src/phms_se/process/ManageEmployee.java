package phms_se.process;

import java.sql.Date;
import java.util.ArrayList;

import phms_se.database.DatabaseProcess;
import phms_se.database.bean.Employee;
import phms_se.database.bean.Patient;
import phms_se.database.bean.Schedule;
import phms_se.gui.ManageEmployeePage;
import phms_se.gui.NewEmployeePage;
import phms_se.gui.NewPatientPage;
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
		String s=newEmployee.getDob();
		String[] d = s.split("[-\\s\\:,]");
		int year = Integer.parseInt(d[0]);
		int month = Integer.parseInt(d[1]);
		int day = Integer.parseInt(d[2]);
		@SuppressWarnings("deprecation")
		Date dob = new Date(year, month, day);
		
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
	public static boolean modifyEmployee(Employee bean){
		return false;
	}
	/**
	 * @param username
	 * @param schedule
	 * @return
	 */
	public static boolean addNewSchedule(String username, Schedule schedule){
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
	
	public static void fillEmployeeTable (ManageEmployeePage manageEmp){
		String realname = null;
		String username=null;
		ArrayList<String> names=new ArrayList<String>();
		names= DatabaseProcess.getEmployeeNames();
		for(int i =0,j=0;i<names.size();i++,j++){
			realname= names.get(i);
			manageEmp.getTable().setValueAt(realname, j, 0);
			username=names.get(++i);
		manageEmp.getTable().setValueAt(username, j, 1);}
	}
	public static void populateEmployeeInfo(ManageEmployeePage emp,String username){
		Employee employee=new Employee();
		employee.setUsername(username);
		employee=(Employee)DatabaseProcess.getRow(employee);
		emp.getDobText().setText(employee.getDob().getYear()+"-"+employee.getDob().getMonth()+"-"+employee.getDob().getDate());
		emp.getAddressText().setText((employee.getAddress()));
		
//		Seriously guys? you setText 2 times and overwrite the correct Dob values?
//		I am pulling my hair to find this kind of bug man, please be more careful, it takes a long time to find bugs
		
//		emp.getDobText().setText(employee.getDob().toString());

		emp.getPhoneText().setText(employee.getPhone());
		emp.getNameText().setText(employee.getName());
		emp.getPositionText().setText(employee.getPosition());
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
}
