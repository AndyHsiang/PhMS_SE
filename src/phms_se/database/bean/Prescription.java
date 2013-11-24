package phms_se.database.bean;

import java.sql.Date;

public class Prescription {
	
	private final static String tableSchema ="START_DATE,THIS_DAY,DOSE,QUANTITY,REFILL,EXIRATION_DATE, PAY_STATUS, DID,PID";
	
	private Date startDate, thisDay, exirationDate;
	private int prescriptionID, quantity, refill, did, pid;
	private String dose;
	private boolean payStatus;
	
	public Prescription(){}

	public int getPrescriptionID() {
		return prescriptionID;
	}

	public void setPrescriptionID(int prescriptionID) {
		this.prescriptionID = prescriptionID;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDay) {
		this.startDate = startDay;
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

	public Date getExirationDate() {
		return exirationDate;
	}

	public void setExirationDate(Date exirationDate) {
		this.exirationDate = exirationDate;
	}

	public boolean getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(boolean payStatus) {
		this.payStatus = payStatus;
	}

	public static String getTableSchema() {
		return tableSchema;
	}

	@Override
	public String toString() {
		return "Prescription [startDate=" + startDate + ", thisDay=" + thisDay
				+ ", quantity=" + quantity + ", refill=" + refill + ", did="
				+ did + ", pid=" + pid + ", dose=" + dose + "]";
	}
}
