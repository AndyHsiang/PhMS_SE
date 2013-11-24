package phms_se.process;

import java.sql.Date;
import java.util.ArrayList;

import phms_se.database.DatabaseProcess;
import phms_se.database.bean.Drug;
import phms_se.database.bean.Patient;
import phms_se.database.bean.Prescription;
import phms_se.gui.FillPrescription;
import phms_se.gui.Gui;
import phms_se.gui.PatientProfilePage;
import phms_se.process.helper.HelperMethods;

/**
 * @author Andy
 */
public class ManagePrescription {
	/**
	 * @param drug
	 * @param patient
	 * @param prescription
	 * @return
	 */
	public static boolean refillDrug(Drug drug, Prescription prescription){
		if(drug.getInterACtion()!=null){
			if(checkInteraction(drug.getDrugName(), drug.getInterACtion()))
				return false;
		}
		return true;
	}
	/**
	 * @param prescription
	 * @param patient
	 * @return
	 */
	public static boolean addPrescription(FillPrescription fillP){
		String drugName = fillP.getDrugName().getText();
		Drug derp = new Drug();
		Prescription perp = new Prescription();
		derp.setDrugName(drugName);
		derp=(Drug)DatabaseProcess.getRow(derp);
		int id = derp.getDrugId();
		perp.setDid(id);
		int patient = Gui.getCurrentPatient().getPid();
		perp.setPid(patient);
		//fillP.getPrescriber()
		perp.setQuantity(Integer.parseInt(fillP.getQuantity().getText()));
		perp.setRefill(Integer.parseInt(fillP.getRefillCount().getText()));
		Date Start=HelperMethods.getDate(fillP.getFillDate().getText());
		perp.setThisDay(Start);
		perp.setStartDate(Start);
		perp.setDose("3/DAY");
		System.out.println(perp);
		DatabaseProcess.insert(perp);
		//perp.fillP.getExpiration()
		return false;
	}
	/**
	 * @param prescription
	 * @param patient
	 * @return
	 */
	public static boolean removePrescription(Prescription prescription, Patient patient){
		return false;
	}
	/**
	 * @param amount
	 * @param paymentType
	 * @return
	 */
	public static boolean processPayment(double amount, String paymentType){
		return false;
	}
	/**
	 * helpper method to check filling drug against drug in interaction list
	 * @param drugFilling
	 * @param drugInList
	 * @return true if drug names match
	 */
	private static boolean checkInteraction(String drugFilling, String drugInList){
		String[] activeDrugs = HelperMethods.splitString(drugInList);
		for(int i = 0; i<activeDrugs.length; i++){
			if(drugFilling.toLowerCase().equals(drugInList.toLowerCase()))
				return true;
		}
		return false;
	}
	public static void displayPrescription(PatientProfilePage profileP){
		Patient p = Gui.getCurrentPatient();
		int pid=p.getPid();
		ArrayList<Integer> prescID=new ArrayList<Integer>();
		prescID=DatabaseProcess.getPrescription(pid);
		for(int i=0;i<prescID.size();i++){
			Prescription bean =new Prescription();
			bean.setPrescriptionID(prescID.get(i));
		bean=(Prescription)DatabaseProcess.getRow(bean);
		
			profileP.getPrescriptionHistory().setValueAt(prescID.get(i),i,0);
			profileP.getPrescriptionHistory().setValueAt(bean.getQuantity(),i,2);
			profileP.getPrescriptionHistory().setValueAt(bean.getDose(),i,3);
			profileP.getPrescriptionHistory().setValueAt(bean.getThisDay().toString(),i,4);
			profileP.getPrescriptionHistory().setValueAt(bean.getRefill(),i,6);
			Drug d=new Drug();
			d.setDrugId(bean.getDid());
			d=(Drug)DatabaseProcess.getRow(d);
			profileP.getPrescriptionHistory().setValueAt(d.getDrugName(),i,1);
			profileP.getPrescriptionHistory().setValueAt(bean.getStartDate().toString(), i, 5);
		}
	}
}
