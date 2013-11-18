package phms_se.process;

import phms_se.gui.DrugInventoryPage;
import phms_se.database.bean.Drug;
import phms_se.database.DatabaseProcess;


/**
 * @author Andy
 */
public class ManageDrug {
	/**
	 * @param drugName
	 * @return
	 */
	public static Drug searchDrug(String drugName){
		
		Drug sDrug = new Drug();
		sDrug.setDrugName(drugName);
		sDrug=(Drug)DatabaseProcess.getRow(sDrug);
		if(sDrug!=null)
			return sDrug;
		else return null;
	}
	
	public static void setDrugInventory(Drug bean, DrugInventoryPage drugInv){
		String name=bean.getDrugName();
		drugInv.getTable().setValueAt(name, 1, 0);
		
		int quantity=bean.getQuantity();
		drugInv.getTable().setValueAt(quantity, 1, 1);
		
		String general=bean.getDescription();
		drugInv.setGeneralText(general);
		
		String effects=bean.getSideEffect();
		drugInv.setEffectsText(effects);
		
		boolean flag=bean.getControlFlag();
		drugInv.getTable().setValueAt(flag, 1, 2);

		
	}
	/**
	 * @param drug
	 * @return
	 */
	public static boolean addNewDrug(Drug drug){
		return false;
	}
	/**
	 * @param drugName
	 * @return
	 */
	public static boolean removeDrug(String drugName){
		return false;
	}
	/**
	 * @param DrugId
	 */
	public static void restock(int DrugId){
		
	}
	/**
	 * @param drugName
	 * @param quantity
	 */
	public static void lowStockWarning(String drugName, int quantity){
		System.out.println(drugName+" is running low\ncurrent quantity on hand: "+quantity);
	}
}
