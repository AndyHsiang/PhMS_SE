package phms_se.database.bean;

import java.sql.Date;

public class Prescription {
	
	private final static String tableSchema ="START_DAY,THIS_DAY,DOSE,QUANTITY,REFILL,DID,PID";
	
	private Date startDay, thisDay;
	private int prescriptionID, quantity, refill, did, pid;
	private String dose;
	
	public Prescription(){}

	public int getPrescriptionID() {
		return prescriptionID;
	}

	public void setPrescriptionID(int prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDate(Date startDay) {
		this.startDay = startDay;
	}

	public Date getThisDay() {
		return thisDay;
	}

	public void setThisDay(Date thisDay) {
		this.thisDay = thisDay;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRefill() {
		return refill;
	}

	public void setRefill(int refill) {
		this.refill = refill;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public static String getTableSchema() {
		return tableSchema;
	}

	@Override
	public String toString() {
		return "Prescription [startDate=" + startDay + ", thisDay=" + thisDay
				+ ", quantity=" + quantity + ", refill=" + refill + ", did="
				+ did + ", pid=" + pid + ", dose=" + dose + "]";
	}
}
