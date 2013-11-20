package phms_se.database.bean;

import java.math.BigDecimal;

public class Drug {
	private final static String tableSchema ="DRUGNAME,DESCRIPTION,QUANTITY,CONTROLFLAG,SIDEEFFECT,INTERACTION, PRICE";
	private String drugName, description, sideEffect, interACtion;
	private int drugId, quantity;
	private boolean controlFlag;
	private BigDecimal price;
	
	//empty constructor
	public Drug(){
		
	}
	/** getter
	 * @return string representation of drug name
	 */
	public String getDrugName() {
		return drugName;
	}

	/** setter: sets the drug's name to drugName
	 * @param drugName
	 */
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	/** getter
	 * @return string representation of drug's description
	 */
	public String getDescription() {
		return description;
	}

	/** setter: sets the drug's description to description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** getter
	 * @return string representation of the drug's side effects
	 */
	public String getSideEffect() {
		return sideEffect;
	}
	public boolean getControlFlag(){
		return this.controlFlag;
	}

	/** setter: sets the drug's side effect to sideEffect
	 * @param sideEffect
	 */
	public void setSideEffect(String sideEffect) {
		this.sideEffect = sideEffect;
	}

	/** getter
	 * @return the drug's ID as int
	 */
	public int getDrugId() {
		return drugId;
	}

	/** setter: sets the drug's id to drugId
	 * @param drugId
	 */
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}

	/** getter
	 * @return quantity on hand for this drug object
	 */
	public int getQuantity() {
		return quantity;
	}

	/** setter: sets the drug's quantity to quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/** getter: to check whether current drug object is a controlled drug
	 * @return the value of the control flag.
	 */
	public boolean isControlFlag() {
		return controlFlag;
	}

	/** setter: sets the control flag of the drug to controlFlag
	 * @param controlFlag
	 */
	public void setControlFlag(boolean controlFlag) {
		this.controlFlag = controlFlag;
	}

	public String getInterACtion() {
		return interACtion;
	}
	
	public void setInterACtion(String interACtion) {
		this.interACtion = interACtion;
	}
	
	/** getter
	 * @return string representation of the table schema for the drug table in database
	 */
	public static String getTableSchema() {
		return tableSchema;
	}
    public BigDecimal getPrice(){
        return price;
}
    public void setPrice(BigDecimal price){
        this.price=price;
    }
}
