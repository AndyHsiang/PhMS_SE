package phms_se.process;

import java.math.BigDecimal;
import java.util.ArrayList;

import phms_se.gui.DrugInventoryPage;
import phms_se.gui.Gui;
import phms_se.gui.NewDrugPage;
import phms_se.gui.RestockPage;
import phms_se.process.helper.HelperMethods;
import phms_se.database.bean.Drug;
import phms_se.database.DatabaseProcess;


/**
 * @author Andy
 */
//MANAGE DRUG PROCCESS
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

public static Drug restock(RestockPage rstock){
				Drug d = new Drug();
				d.setDrugName(rstock.getDname().getText());
				int AddQuantity = rstock.getDquant();
				d=(Drug)DatabaseProcess.getRow(d);
				d.setQuantity(d.getQuantity()+AddQuantity);
				DatabaseProcess.modifyRow(d, "quantity");
				return d;
				
				
			}
	public static void setLowInventoryWarning(DrugInventoryPage drugInv){
		clearLowInventoryTable(Gui.getDrugPage());
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
	public static boolean checkDrugWarnings(Drug bean){
		bean=(Drug)DatabaseProcess.getRow(bean);
		String status = "";
		System.out.println(bean.getDrugName());
		String conflictDrug=ManagePrescription.checkInteraction(bean.getDrugName(), bean.getInterACtion());
		if(bean.getQuantity()<1000){
			status = "low";
			if(bean.getControlFlag()){
				status = "low and control";
				//add code here if it also has interaction
				if(conflictDrug!=null){
					status="low and control and interaction";
				}
			}else if(conflictDrug!=null){
				status = "low and interaction";
			}
		}else if(bean.getControlFlag()){
			status = "control";
			if(conflictDrug!=null)
				status = "control and interaction";
		}else if(conflictDrug!=null){
			status = "interaction";
		}
		
		if(status.equals("low")){
			HelperMethods.warning(bean.getDrugName()+" is running low\nQuantity remaining: "+bean.getQuantity());
		}else if(status.equals("control")){
			HelperMethods.warning(bean.getDrugName()+" is a controlled substance");
		}else if(status.equals("interaction")){
			HelperMethods.warning(bean.getDrugName()+" will interact with \n"+conflictDrug);
		}else if(status.equals("low and control")){
			HelperMethods.warning(bean.getDrugName()+" is running low\nQuantity remaining: "+bean.getQuantity()
			+"\n\n"+bean.getDrugName()+" is a controlled substance");
		}else if(status.equals("low and interaction")){
			HelperMethods.warning(bean.getDrugName()+" is running low\nQuantity remaining: "+bean.getQuantity()
					+"\n\n"+bean.getDrugName()+" is interacting with : "+conflictDrug);
		}else if(status.equals("control and interaction")){
			HelperMethods.warning(bean.getDrugName()+" is a controlled substance"
					+"\n\n"+bean.getDrugName()+" is interacting with : "+conflictDrug);
		}else if(status.equals("low and control and interaction")){
			HelperMethods.warning(bean.getDrugName()+" is running low\nQuantity remaining: "+bean.getQuantity()
					+"\n\n"+bean.getDrugName()+" is a controllled substance"
					+"\n\n"+bean.getDrugName()+" is interacting with : "+conflictDrug);
		}
		System.out.println(status);
		return true;
	}
	/**
	 * @param drugName
	 * @param quantity
	 */
	public static void lowStockWarning(String drugName, int quantity){
		System.out.println(drugName+" is running low\ncurrent quantity on hand: "+quantity);
	}
	public static void clearDrugPage(DrugInventoryPage drugP){
		for(int i=0;i<2;i++){
			drugP.getTable().setValueAt("Drug Name",0,0);
			drugP.getTable().setValueAt("Quantity",0,1);
			drugP.getTable().setValueAt("Controlled Flag",0,2);
			drugP.getTable().setValueAt("Price",0,3);
			drugP.getTable().setValueAt("",1,0);
			drugP.getTable().setValueAt("",1,1);
			drugP.getTable().setValueAt("",1,2);
			drugP.getTable().setValueAt("",1,3);
		}
		drugP.getDName().setText("");
		drugP.setGeneralText("");
		drugP.setEffectsText("");
	}
	public static void clearNewDrugPage(NewDrugPage newDrug){
		newDrug.getdName().setText("");
		newDrug.getdGeneral().setText("");
		newDrug.getdSide().setText("");
		newDrug.getdQuantity().setText("");
		
	}
	public static void clearLowInventoryTable(DrugInventoryPage drugP){
		int rows= drugP.getLowInventoryTable().getRowCount();
		for(int i=0;i<rows;i++){
			drugP.getLowInventoryTable().setValueAt("",i,0);
		}
	}
}
