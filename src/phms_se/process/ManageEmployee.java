package phms_se.process;

import java.sql.Date;
import java.util.ArrayList;

import phms_se.database.DatabaseProcess;
import phms_se.database.bean.Employee;
import phms_se.database.bean.Schedule;
import phms_se.gui.ManageEmployeePage;
import phms_se.gui.NewEmployeePage;

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
	public static boolean deleteEmployee(String username){
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
		int d = employee.getDob().getYear();
		System.out.println(d);
		emp.getDobText().setText(d+"-"+employee.getDob().getMonth()+"-"+employee.getDob().getDate());
		emp.getAddressText().setText((employee.getAddress()));
		emp.getDobText().setText(employee.getDob().toString());
		emp.getPhoneText().setText(employee.getPhone());
		emp.getNameText().setText(employee.getName());
		emp.getPositionText().setText(employee.getPosition());
	}
}
