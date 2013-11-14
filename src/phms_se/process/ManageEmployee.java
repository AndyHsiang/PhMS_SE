package phms_se.process;

import phms_se.database.bean.Employee;
import phms_se.database.bean.Schedule;

/**
 * @author Andy Hsiang
 */
public class ManageEmployee {
	/**
	 * @param bean
	 * @return
	 */
	public static boolean addNewEmployee(Employee bean){
		return false;
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
}
