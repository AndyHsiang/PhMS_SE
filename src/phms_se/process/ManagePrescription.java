package phms_se.process;

import java.awt.Color;
import java.awt.Component;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.TableCellRenderer;

import phms_se.database.DatabaseProcess;
import phms_se.database.bean.Drug;
import phms_se.database.bean.Patient;
import phms_se.database.bean.Prescription;
import phms_se.gui.FillPrescription;
import phms_se.gui.Gui;
import phms_se.gui.ManageEmployeePage;
import phms_se.gui.PatientProfilePage;
import phms_se.process.helper.DeleteConfirmation;
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
		Date Exp=HelperMethods.getDate(fillP.getExpiration().getText());
		perp.setThisDay(Start);
		perp.setStartDate(Start);
		perp.setDose("3/DAY");
		perp.setExirationDate(Exp);
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
	public static boolean removePrescription(DeleteConfirmation removeP){

		Prescription bean=new Prescription();
		DeleteConfirmation.getPrescriptionID().getText().toString();
		bean.setPrescriptionID(Integer.parseInt(DeleteConfirmation.getPrescriptionID().getText()));
		DatabaseProcess.delete(bean);
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
		clearTable(profileP);
		Patient p = Gui.getCurrentPatient();
		int pid=p.getPid();
		ArrayList<Integer> prescID=new ArrayList<Integer>();
		prescID=DatabaseProcess.getPrescription(pid);
		ArrayList<Integer> paid=new ArrayList<Integer>();
		ArrayList<Integer> expired=new ArrayList<Integer>();
		int j=0;
		System.out.println(prescID);
		for(int i=0;i<prescID.size();i++){
			Prescription bean =new Prescription();
			bean.setPrescriptionID(prescID.get(i));
		bean=(Prescription)DatabaseProcess.getRow(bean);
		if(!bean.getPayStatus()){
			profileP.getPrescriptionHistory().setValueAt(prescID.get(i),j,0);
			profileP.getPrescriptionHistory().setValueAt(bean.getQuantity(),j,2);
			profileP.getPrescriptionHistory().setValueAt(bean.getDose(),j,3);
			profileP.getPrescriptionHistory().setValueAt(bean.getThisDay().toString(),j,4);
			profileP.getPrescriptionHistory().setValueAt(bean.getRefill(),j,6);
			Drug d=new Drug();
			d.setDrugId(bean.getDid());
			d=(Drug)DatabaseProcess.getRow(d);
			profileP.getPrescriptionHistory().setValueAt(d.getDrugName(),j,1);
			profileP.getPrescriptionHistory().setValueAt(bean.getStartDate().toString(), j, 5);
			profileP.getPrescriptionHistory().setValueAt(bean.getPayStatus(),j,7);j++;}
		else if(bean.getRefill()!=0)
			paid.add(bean.getPrescriptionID());
		else expired.add(bean.getPrescriptionID());}
		System.out.println(paid);
		for(int i=0;i<paid.size();i++){
			Prescription paidBean =new Prescription();
			paidBean.setPrescriptionID(paid.get(i));
			paidBean=(Prescription)DatabaseProcess.getRow(paidBean);
			profileP.getPrescriptionHistory().setValueAt(paid.get(i),j,0);
			profileP.getPrescriptionHistory().setValueAt(paidBean.getQuantity(),j,2);
			profileP.getPrescriptionHistory().setValueAt(paidBean.getDose(),j,3);
			profileP.getPrescriptionHistory().setValueAt(paidBean.getThisDay().toString(),j,4);
			profileP.getPrescriptionHistory().setValueAt(paidBean.getRefill(),j,6);
			Drug d=new Drug();
			d.setDrugId(paidBean.getDid());
			d=(Drug)DatabaseProcess.getRow(d);
			profileP.getPrescriptionHistory().setValueAt(d.getDrugName(),j,1);
			profileP.getPrescriptionHistory().setValueAt(paidBean.getStartDate().toString(), j, 5);
			profileP.getPrescriptionHistory().setValueAt(paidBean.getPayStatus(),j,7);j++;}
		for(int i=0;i<expired.size();i++){
			Prescription expiredBean =new Prescription();
			expiredBean.setPrescriptionID(expired.get(i));
			expiredBean=(Prescription)DatabaseProcess.getRow(expiredBean);
			profileP.getPrescriptionHistory().setValueAt(expired.get(i),j,0);
			profileP.getPrescriptionHistory().setValueAt(expiredBean.getQuantity(),j,2);
			profileP.getPrescriptionHistory().setValueAt(expiredBean.getDose(),j,3);
			profileP.getPrescriptionHistory().setValueAt(expiredBean.getThisDay().toString(),j,4);
			profileP.getPrescriptionHistory().setValueAt(expiredBean.getRefill(),j,6);
			Drug d=new Drug();
			d.setDrugId(expiredBean.getDid());
			d=(Drug)DatabaseProcess.getRow(d);
			profileP.getPrescriptionHistory().setValueAt(d.getDrugName(),j,1);
			profileP.getPrescriptionHistory().setValueAt(expiredBean.getStartDate().toString(), j, 5);
			profileP.getPrescriptionHistory().setValueAt(expiredBean.getPayStatus(),j,7);j++;}
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
			profileP.getPrescriptionHistory().setValueAt("",i,7);
			i++;
		}
		
	}
		
	
		
	
	public static boolean isPaid(Prescription bean){
		boolean paid= bean.getPayStatus();
		return paid;
	}
	
	
}
