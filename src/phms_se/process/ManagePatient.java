package phms_se.process;

import java.sql.Date;

import phms_se.process.helper.InputChecker;
import phms_se.gui.NewPatientPage;
import phms_se.gui.PatientProfilePage;
import phms_se.database.DatabaseProcess;
import phms_se.database.bean.Patient;

/***
 * @author Andy
 */
public class ManagePatient {
	private static String[] splitString(String s){
		String[] stringArray = s.split("\\s");
		return stringArray;
	}
	/***
	 * @param patientFullName
	 * @return patient if found
	 */
	public static Patient searchPatient(String patientFullName){
		String[] patientName = splitString(patientFullName);
		Patient bean = new Patient();
		bean.setFirstName(patientName[0]);
		bean.setLastName(patientName[1]);	
		bean=(Patient)DatabaseProcess.getRow(bean);
		if(bean!=null)
			return bean;
		else return null;
	}
	/**
	 * @param patientFullName
	 * @param phoneNum
	 * @return patient if found
	 */
	public static Patient searchPatient(String patientFullName, String phoneNum){
		String[] patientName = splitString(patientFullName);
		Patient bean = new Patient();
		bean.setFirstName(patientName[0]);
		bean.setLastName(patientName[1]);
		bean.setPhone(phoneNum);
		bean=(Patient)DatabaseProcess.getRow(bean);
		if(bean!=null)
			return bean;
		else return null;
	}
	/**
	 * overload search patient method
	 * @param pid
	 * @return patient if found
	 */
	public static Patient searchPatient(int pid){
		Patient bean = new Patient();
		bean.setPid(pid);
		bean=(Patient)DatabaseProcess.getRow(bean);
		if(bean!=null)
			return bean;
		else return null;
	}
	/**
	 * This method populate the profile page to reflect the current patient
	 * @param bean
	 * @param profilePage
	 * @return true if the page has been populated with info without any error
	 */
	@SuppressWarnings("deprecation")
	public static void setPatientProfilePage(Patient bean, PatientProfilePage profilePage){

		profilePage.getpName().setText(bean.getFirstName()+" "+bean.getLastName());
		profilePage.getpAddress().setText(bean.getAddress());
		profilePage.getpDob().setText(bean.getDob().getYear()+"-"+bean.getDob().getMonth()+"-"+bean.getDob().getDate());
		profilePage.getPhoneNumber().setText(bean.getPhone());
		profilePage.getpDoctor().setText(bean.getPrimaryDoc());
	}
	/**
	 * @param patientFullName
	 * @return
	 */
	public static boolean deletePatient(String patientFullName){
		return false;
	}
	/**
	 * @param bean
	 * @return
	 */
	public static boolean modifyPatient(Patient bean){
		return false;
	}
	public static boolean addNewPatient(NewPatientPage newPatient){
		String[] d = newPatient.getDoB().getText().split("[-\\s\\:,]");
		int year = Integer.parseInt(d[0]);
		int month = Integer.parseInt(d[1]);
		int day = Integer.parseInt(d[2]);
		@SuppressWarnings("deprecation")
		Date dob = new Date(year, month, day);
		
		Patient newPat = new Patient();
		newPat.setFirstName(newPatient.getfName().getText());
		newPat.setLastName(newPatient.getlName().getText());
		newPat.setPhone(newPatient.getPhone().getText());
		newPat.setPrimaryDoc(newPatient.getDoctor().getText());
		newPat.setAddress(newPatient.getAddress().getText());
		newPat.setDob(dob);
		
		return DatabaseProcess.insert(newPat);
	}
	/**
	 * @param bean
	 * @return
	 */
	public static boolean verifyNewPatient(NewPatientPage newPatient){
		Patient patient = new Patient();
		if(InputChecker.name(newPatient.getfName().getText())){
			patient.setFirstName(newPatient.getfName().getText());
			if(InputChecker.name(newPatient.getfName().getText())){
				patient.setLastName(newPatient.getlName().getText());
				if(InputChecker.fullName(newPatient.getDoctor().getText())){
					patient.setPrimaryDoc(newPatient.getDoctor().getText());
					if(InputChecker.phone(newPatient.getPhone().getText())){
						patient.setPhone(newPatient.getPhone().getText());
						if(newPatient.getAddress().getText()!=null){
							patient.setAddress(newPatient.getAddress().getText());
							if(newPatient.getDoB().getText()!=null){
								if(InputChecker.dob(newPatient.getDoB().getText()))
									return true;
								else System.out.println("invalid format for Dob");
							}else
								System.out.println("wrong format for DoB");
						}else
						System.out.println("wrong format for address");
					}else
						System.out.println("wrong format for phone");
				}else
					System.out.println("wrong format for doc name");
			}else
				System.out.println("wrong format for last name");
		}else
			System.out.println("wrong format for first name");
		return false;
	}
	/**
	 * @param patient
	 */
	public static void getPatientHistory(Patient patient){
		
	}
}
