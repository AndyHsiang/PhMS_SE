package phms_se.process;

import phms_se.database.bean.Drug;
import phms_se.database.bean.Patient;
import phms_se.database.bean.Prescription;
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
	public static boolean addPrescription(Prescription prescription, Patient patient){
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
}
