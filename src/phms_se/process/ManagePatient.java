package phms_se.process;

import java.sql.Date;
import java.text.SimpleDateFormat;

import phms_se.process.helper.HelperMethods;
import phms_se.process.helper.InputChecker;
import phms_se.gui.Gui;
import phms_se.gui.ManageEmployeePage;
import phms_se.gui.NewPatientPage;
import phms_se.gui.PatientProfilePage;
import phms_se.database.DatabaseProcess;
import phms_se.database.bean.Patient;

/***
 * @author Andy
 */
public class ManagePatient {
	
	/**
	 * 
	 * @param searchText
	 * @return
	 */
	public static Patient searchPatient(String searchText){
		String[] searchFields = HelperMethods.splitString(searchText);
		Patient bean = new Patient();
		
		if(searchFields.length==1){
			if(InputChecker.name(searchFields[0])){
				bean.setFirstName(HelperMethods.capFirst(searchFields[0]));
				bean=(Patient)DatabaseProcess.getRow(bean);	
				if(bean==null){
					bean = new Patient();
					bean.setLastName(HelperMethods.capFirst(searchFields[0]));
				}
			}else if(InputChecker.phone(searchFields[0])){
				bean.setPhone(searchFields[0]);
			}else if(searchFields[0].length()==5){
				if(InputChecker.digits(searchFields[0]))
					return searchPatient(Integer.parseInt(searchFields[0]));
			}
		}else if(searchFields.length==2){
			if(InputChecker.fullName(searchText)){
				bean.setFirstName(HelperMethods.capFirst(searchFields[0]));
				bean.setLastName(HelperMethods.capFirst(searchFields[1]));
			}
		//assuming user input full name and phone
		}else if(searchFields.length==3){
			return searchPatient((HelperMethods.capFirst(searchFields[0])+" "+HelperMethods.capFirst(searchFields[1])), searchFields[2]);
		}
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
		String[] patientName = HelperMethods.splitString(patientFullName);
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
		
		profilePage.getpDob().setText(bean.getDob().toString());
		profilePage.getPhoneNumber().setText(bean.getPhone());
		profilePage.getpDoctor().setText(bean.getPrimaryDoc());
		profilePage.getZipT().setText(bean.getZip());
		profilePage.getStateT().setText(bean.getState());
		profilePage.getCityT().setText(bean.getCity());
	}
	/**
	 * @param patientFullName
	 * @return
	 */
	public static boolean deletePatient(Patient bean){
		return DatabaseProcess.delete(bean);
	}
	/**
	 * @param bean
	 * @return
	 */
	public static boolean modifyPatient(PatientProfilePage pPage){
		Patient modified = new Patient();
		Patient original = Gui.getCurrentPatient();
		
		Date dob = HelperMethods.getDate(pPage.getpDob().getText());
		String[] patientName = HelperMethods.splitString(pPage.getpName().getText());
	
		//set the modified patient info
		modified.setPid(original.getPid());
		modified.setAddress(pPage.getpAddress().getText());
		modified.setDob(dob);
		modified.setPhone(pPage.getPhoneNumber().getText());
		modified.setCity(pPage.getCityT().getText());
		modified.setPrimaryDoc(pPage.getpDoctor().getText());
		modified.setState(pPage.getStateT().getText());
		modified.setZip(pPage.getZipT().getText());
		modified.setFirstName(patientName[0]);
		modified.setLastName(patientName[1]);
		
		//is phone modified?
		if(!original.getPhone().equals(modified.getPhone())){
			//does new number have correct phone number format?
			if(InputChecker.phone(pPage.getPhoneNumber().getText())){
				DatabaseProcess.modifyRow(modified, "phone");
				System.out.println("phone field updated");
			}
			else {
				System.out.println("wrong phone number format");
				return false;
			}
			
		//is primary doc field modified?
		}if(!original.getPrimaryDoc().equals(modified.getPrimaryDoc())){
			//check primary doc field format
			if(InputChecker.fullName(modified.getPrimaryDoc())){
				DatabaseProcess.modifyRow(modified, "PRIMARYDOC");
				System.out.println("primary doctor field updated");
			}
			else {
				System.out.println("wrong format for primary doctor");
				return false;
			}
			
		//is Address modified?
		}if(!original.getAddress().equals(modified.getAddress())){
			//check address field format
			if(InputChecker.streetAddress(modified.getAddress())){
				DatabaseProcess.modifyRow(modified, "ADDRESS");
				System.out.println("address updated");
			}
			else {
				System.out.println("wrong format for address");
			return false;
			}
		
		//is State modified?
		}if(!original.getState().equals(modified.getState())){
			//check State field format
			if(InputChecker.state(modified.getState())){
				DatabaseProcess.modifyRow(modified, "STATE");
				System.out.println("state updated");
			}
			else {
				System.out.println("wrong format for STATE");
				return false;
			}

		//is zip modified?
		}if(!original.getZip().equals(modified.getZip())){
			//check zip field format
			if(InputChecker.state(modified.getZip())){
				DatabaseProcess.modifyRow(modified, "ZIP");
				System.out.println("zip updated");
			}
			else {
				System.out.println("wrong format for ZIP");
				return false;
			}
		
		//is last name modified?
		}if(!original.getLastName().equals(modified.getLastName())){
			//check lastname field format
			if(InputChecker.name(modified.getLastName())){
				DatabaseProcess.modifyRow(modified, "LASTNAME");
				System.out.println("last name updated");
			}
			else {
				System.out.println("wrong format for LASTNAME");
				return false;
			}
		
		//is first name modified?
		}if(!original.getFirstName().equals(modified.getFirstName())){
			//check lastname field format
			if(InputChecker.name(modified.getFirstName())){
				DatabaseProcess.modifyRow(modified, "FIRSTNAME");
				System.out.println("first name updated");
			}
			else {
				System.out.println("wrong format for FIRSTNAME");
				return false;
			}
		
		//is dob modified?
		}if(!original.getDob().equals(modified.getDob())){
			//check lastname field format
			if(InputChecker.dob(pPage.getpDob().getText())){
				DatabaseProcess.modifyRow(modified, "DOB");
				System.out.println("DoB updated");
			}
			else {
				System.out.println("wrong format for Dob");
				return false;
			}
		}
		System.out.println("all modified fields are updated");
		return true;
	}
	public static boolean addNewPatient(NewPatientPage newPatient){
		
		Date dob = HelperMethods.getDate(newPatient.getDob());
		
		Patient newPat = new Patient();
		newPat.setFirstName(newPatient.getfName().getText());
		newPat.setLastName(newPatient.getlName().getText());
		newPat.setPhone(newPatient.getPhone().getText());
		newPat.setPrimaryDoc(newPatient.getDoctor().getText());
		newPat.setAddress(newPatient.getAddress().getText());
		newPat.setDob(dob);
		newPat.setCity(newPatient.getCity().getText());
		newPat.setState(newPatient.getState().getText());
		newPat.setZip(newPatient.getZip().getText());
		
		if(DatabaseProcess.insert(newPat)){
			Gui.setCurrentPatient(newPat);
			return true;
		}
		return false;
	}
	public static void clearTable(PatientProfilePage profileP){
		int rows= profileP.getPrescriptionHistory().getRowCount();
		int i=0;
		while(i<rows){
			profileP.getPrescriptionHistory().setValueAt("",i,0);
			profileP.getPrescriptionHistory().setValueAt("",i,1);
			profileP.getPrescriptionHistory().setValueAt("",i,2);
			profileP.getPrescriptionHistory().setValueAt("",i,3);
			profileP.getPrescriptionHistory().setValueAt("",i,4);
			profileP.getPrescriptionHistory().setValueAt("",i,5);
			profileP.getPrescriptionHistory().setValueAt("",i,6);
			i++;
		}
		
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
					if(InputChecker.city(newPatient.getCity().getText())){
					patient.setCity(newPatient.getCity().getText());
					if(InputChecker.state(newPatient.getState().getText())){
					patient.setState(newPatient.getState().getText());	
					if(InputChecker.zip(newPatient.getZip().getText())){
						patient.setZip(newPatient.getZip().getText());
					
					if(InputChecker.phone(newPatient.getPhone().getText())){
						patient.setPhone(newPatient.getPhone().getText());
						if(newPatient.getAddress().getText()!=null){
							patient.setAddress(newPatient.getAddress().getText());
						if(newPatient.getDob()!=null){
								if(InputChecker.dob(newPatient.getDob()))
									return true;
								else{ System.out.println("invalid format for Dob");
								newPatient.getWarning().setText("invalid format for Dob");}
							}else{
								System.out.println("wrong format for DoB");
								newPatient.getWarning().setText("wrong format for DoB");}
						}else{
						System.out.println("wrong format for address");
						newPatient.getWarning().setText("wrong format for address");}
					}else{
						System.out.println("wrong format for phone");
						newPatient.getWarning().setText("wrong format for phone");}
					}else{newPatient.getWarning().setText("wrong format for zip code");}
					}else{newPatient.getWarning().setText("wrong format for state");}
				}else{newPatient.getWarning().setText("wrong format for city");
				}
				}else{
					System.out.println("wrong format for doc name");
					newPatient.getWarning().setText("wrong format for doc name");}
			}else{
				System.out.println("wrong format for last name");
			    newPatient.getWarning().setText("wrong format for last name");}
		}else{
			System.out.println("wrong format for first name");
		    newPatient.getWarning().setText("wrong format for first name");}
		return false;
	}
	/**
	 * @param patient
	 */
	public static void getPatientHistory(Patient patient){
		
	}
	public static void resetUnpaid(PatientProfilePage patientP){
		patientP.getPrescriptionList().setText("Unpaid Prescription List: \n");
		patientP.getTaxAmt().setText("");
		patientP.getCoPayAmt().setText("");
		patientP.getTotalAmt().setText("");
		patientP.getSubAmt().setText("");
	}
	public static void clearNewPatient(NewPatientPage newp){
		newp.getfName().setText("");
		newp.getlName().setText("");
		newp.getDoctor().setText("");
		newp.getPhone().setText("");
		newp.getAddress().setText("");
		newp.getCity().setText("");
		newp.getZip().setText("");
		newp.getState().setText("");
		newp.getWarning().setText("");
		
	}
}
