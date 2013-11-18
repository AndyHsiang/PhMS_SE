package phms_se.process;

import phms_se.gui.Gui;
import phms_se.database.DatabaseProcess;
import phms_se.database.bean.Employee;

/**
 * @author Andy
 */
public class ManageSystem {
	
	/**
	 * @return
	 */
	public static boolean logOff() {
		return false;
	}
	
	/**
	 * @param pass
	 * @param username
	 * @return
	 */
	public static boolean shutDown(String username, String pass){
		
		String position = checkPosition(username, pass);
		
		if(position.equals("manager")){
			DatabaseProcess.closeConnection();
			System.exit(0);
			return true;
		}
		return false;
	}
	
	/**
	 * @param username
	 * @param pass
	 * @return true if username and pass is matching pair stored in db for an employee
	 */
	public static boolean login(String username, String pass){
		
		Employee bean = new Employee();
		bean.setUsername(username);	
		bean = (Employee)DatabaseProcess.getRow(bean);
		
		//if username cannot be found in the database
		if(bean == null){
			System.out.println(username+" not found!");
			return false;
		}
		if(bean.getUsername().equals(username)&&bean.getPass().equals(pass)){
			Gui.setCurrentUser(bean);
			return true;
		}
		System.out.println("incorrect username and password combination");
		return false;
	}
	
	/**
	 * @param username
	 * @param pass
	 * @return
	 */
	public static String checkPosition(String username, String pass){
		
		Employee bean = new Employee();
		bean.setUsername(username);	
		bean = (Employee)DatabaseProcess.getRow(bean);
		
		//if username cannot be found in the database
		if(bean == null){
			return "not found";
		}
		if(bean.getUsername().equals(username)&&bean.getPass().equals(pass)){
			return bean.getPosition().toLowerCase();
		}else{
			return "incorrect username and password combination";
		}
	}
	public static boolean canAccess(String position, String subsystem){
		if(position.equals("manager"))
			return true;
		if(position.equals("pharmacist")&&!subsystem.equals("employee"))
			return true;
		if(position.equals("tech")&&subsystem.equals("patient"))
			return true;
		return false;
	}
}
