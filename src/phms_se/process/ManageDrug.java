package phms_se.process;

import java.math.BigDecimal;
import java.util.ArrayList;

import phms_se.gui.DrugInventoryPage;
import phms_se.gui.Gui;
import phms_se.gui.NewDrugPage;
import phms_se.gui.RestockPage;
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

		BigDecimal price=bean.getPrice();
		String price2=price+"$";
		drugInv.getTable().setValueAt(price2, 1, 3);
	}
	/**
	 * @param drug
	 * @return
	 */
	public static boolean addNewDrug(NewDrugPage newDrug){
		Drug newd = new Drug();
		String quantity = newDrug.getdQuantity().getText();
		int quant = Integer.parseInt(quantity);
		String cont = newDrug.getdControlled().getText();
		String t= "true";
		boolean controlledt=false;	
		controlledt=cont.equals(t);
		
		newd.setDrugName(newDrug.getdName().getText());
		newd.setDescription(newDrug.getdGeneral().getText());
		newd.setQuantity(quant);
		newd.setControlFlag(controlledt);
		newd.setSideEffect(newDrug.getdSide().getText());
		newd.setInterACtion("?");
		
		if(DatabaseProcess.insert(newd)){
			Gui.setCurrentDrug(newd);
			return true;
		}
		return false;}
	/**
	 * @param drugName
	 * @return
	 */
	public static boolean removeDrug(Drug bean){
		Drug d = new Drug();
		String name = bean.getDrugName();
		d.setDrugName(name);
		d=(Drug)DatabaseProcess.getRow(d);
			return DatabaseProcess.delete(d);
		}
	/**
	 * @param DrugId
	 */

public static void restock(RestockPage rstock){
				Drug d = new Drug();
				d.setDrugName(rstock.getDname().getText());
				int AddQuantity = rstock.getDquant();
				d=(Drug)DatabaseProcess.getRow(d);
				d.setQuantity(d.getQuantity()+AddQuantity);
				DatabaseProcess.modifyRow(d, "quantity");
				//not sure what to put as the field
				
			}
	public static void setLowInventoryWarning(DrugInventoryPage drugInv){
		String drugName="";
		String drugCount="";
		ArrayList<String> drug= null;
		drug=DatabaseProcess.getDrugCount();
		int i=0; 
		int j=0;
		while(i<drug.size()){
			drugName=drug.get(i);
			drugCount=drug.get(i+1);
			if(Integer.parseInt(drugCount)<1000){
				drugInv.getLowInventoryTable().setValueAt(drugName,j,0);j++;
			}i=i+2;
		}
	}
	/**
	 * @param drugName
	 * @param quantity
	 */
	public static void lowStockWarning(String drugName, int quantity){
		System.out.println(drugName+" is running low\ncurrent quantity on hand: "+quantity);
	}
}
