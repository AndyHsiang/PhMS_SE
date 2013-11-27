package phms_se.gui;


import javax.swing.*;

import phms_se.database.bean.Drug;
import phms_se.database.bean.Employee;
import phms_se.database.bean.Patient;
import phms_se.database.bean.Prescription;
import phms_se.process.ManageDrug;
import phms_se.process.ManageEmployee;
import phms_se.process.ManagePatient;
import phms_se.process.ManagePrescription;
import phms_se.process.ManageSystem;
import phms_se.process.helper.Credentials;
import phms_se.process.helper.DeleteConfirmation;
import phms_se.process.helper.InputChecker;

import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

@SuppressWarnings("serial")
public class Gui extends JFrame implements ActionListener{
	public static Gui frame;
	private static Employee currentUser;
	private static Patient currentPatient;
	private static Drug currentDrug;
	private static Drug checkQuantity;
	private static Employee currentEmployee;
	private static Prescription currentPrescription;
	private JLabel picLabel;
	private JButton login;
	private JButton exit;
	private JTextField userField;
	private JPasswordField passField;
	private JLabel warning;
	static JPanel loginPanel;		
	private menuPanel menuP;
	private spatientPanel spatientP;
	private NewPatientPage newPatientP;
	private PatientProfilePage pProfileP;
	private FillPrescription fillP;
	private DrugInventoryPage drugP;
	private NewDrugPage nDrugP;
	private RestockPage restockP;
	private SystemsPage systemP;
	private DeleteConfirmation deleteP;
	private static ManageEmployeePage employeePage;
	private NewEmployeePage newEmployee;
	final static boolean shouldFill=true;
	final static boolean shouldWeightx=true;
	final static boolean RIGHT_TO_LEFT=false;

	public Gui(){
        
		picLabel=new JLabel();
        picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phms_se/resources/img/bg.jpg")));
		this.add(picLabel);
		picLabel.setLayout(new GridBagLayout());
					   
		loginPanel = new JPanel(new GridBagLayout());
		loginPanel.setPreferredSize(new java.awt.Dimension(800, 600));
		GridBagConstraints c = new GridBagConstraints();
		
		if (shouldFill){
			c.fill=GridBagConstraints.HORIZONTAL;
		}
		
		JLabel username;
		username = new JLabel("Username:");
		username.setFont(new Font("Comic Sans",Font.BOLD, 14));
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.insets= new Insets(0,20,0,20);
		c.gridy=0; 
		picLabel.add(username,c);
		JLabel password;
		password = new JLabel("Password:");
		password.setFont(new Font("Comic Sans",Font.BOLD, 14));
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.insets= new Insets(0,20,0,20);
		c.gridy=1;
		picLabel.add(password, c);
		loginPanel.setBackground(Color.gray);

		userField =new JTextField("",15);
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.insets= new Insets(0,0,0,0);
		c.gridy=0;
		picLabel.add(userField, c);
		passField =new JPasswordField("",10);
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=1;
		picLabel.add(passField, c);
		
		warning = new JLabel(" ");
		password.setFont(new Font("Comic Sans",Font.BOLD, 14));
		c.fill=GridBagConstraints.HORIZONTAL;
		c.insets= new Insets(0,0,0,0);
		c.gridx=0;
		c.gridy=5;
		c.gridwidth=2;
		picLabel.add(warning, c);
		warning.setForeground(Color.red);

		login = new JButton("Login");
		login.setFont(new Font("Comic Sans",Font.BOLD, 16));
		c.fill=GridBagConstraints.HORIZONTAL;
		c.ipady=20;
		c.insets= new Insets(10,0,0,0);
		c.gridwidth=2;
		c.gridx=0;
		c.gridy=3;
		picLabel.add(login,c);

		exit = new JButton ("Exit");
		exit.setFont(new Font("Comic Sans",Font.BOLD, 16));
		c.gridx=0;
		c.gridy=4;
		c.anchor=GridBagConstraints.LAST_LINE_END;
		picLabel.add(exit,c);
		
		login.addActionListener(this);
	    exit.addActionListener(this);
	    
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setPreferredSize(new Dimension(1280, 800));
	    pack();
	    setVisible(true); 		   
	}
		
	private void addFirstPage() {    	
		add(loginPanel);
		revalidate();
		repaint();
	}

	private void createPages() throws IOException {	    	
		this.menuP = new menuPanel(this);
		this.spatientP = new spatientPanel(this);
		this.newPatientP=new NewPatientPage(this);
		this.pProfileP=new PatientProfilePage(this);
		this.drugP=new DrugInventoryPage(this);
		this.restockP=new RestockPage(this);
		this.fillP=new FillPrescription(this);
		this.nDrugP=new NewDrugPage(this);
		this.systemP=new SystemsPage(this);
		this.employeePage=new ManageEmployeePage(this);
		this.newEmployee=new NewEmployeePage(this);
		checkQuantity=new Drug();
	}
	
	@SuppressWarnings("deprecation")
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login){
			warning.setText("");
			if (ManageSystem.login(userField.getText(), passField.getText())) {
				getContentPane().removeAll();
				getContentPane().add(menuP);
				revalidate();
				repaint();
			}else{
				warning.setText("Login Failed, check your credential. ");
			}
		}
		/**
		 * only manager can shut the system down
		 */
		if(e.getSource()==exit){
			if(Credentials.UserInputs()){
				String user=Credentials.getUser().getText();
				String pass=Credentials.getPass().getText();
                
                if(ManageSystem.shutDown(user, pass)){
                System.out.println("exiting the system ...");
                System.exit(0);
                }else{
                  System.out.println("Only manager may shutdown the system!");
			}
            }else{
              System.out.println("wrong input");
			}
		}
		if(e.getSource()==menuP.getPatientButton()){
			getContentPane().removeAll();
			getContentPane().add(spatientP);
			revalidate();
			repaint();
			}
		else if(e.getSource()==spatientP.getNewPatientButton()){
			getContentPane().removeAll();
			getContentPane().add(newPatientP);
			revalidate();
			repaint();
		}
else if(e.getSource()==pProfileP.getCheckOut()){
			ManagePatient.resetUnpaid(pProfileP);
			ManagePrescription.Checkout(currentPatient,pProfileP);
			getContentPane().removeAll();
			getContentPane().add(pProfileP);
			revalidate();
			repaint();

		}
		else if(e.getSource()==newPatientP.getSubmit()){
			if(ManagePatient.verifyNewPatient(newPatientP))
				if(ManagePatient.addNewPatient(newPatientP)){
					ManagePatient.clearNewPatient(newPatientP);
					getContentPane().removeAll();
					getContentPane().add(spatientP);
					revalidate();
					repaint();
				}
		}
		else if(e.getSource()==spatientP.getSearchButton()){
			String searchText=spatientP.getEnterPatient().getText();			
			currentPatient = ManagePatient.searchPatient(searchText);
			if(currentPatient!=null){
				ManagePatient.setPatientProfilePage(currentPatient, pProfileP);
				ManagePrescription.clearTable(pProfileP);
				ManagePrescription.displayPrescription(pProfileP);
                spatientP.getEnterPatient().setText("");
				getContentPane().removeAll();
				getContentPane().add(pProfileP);					
				revalidate();
				repaint();
			}else{
				spatientP.setWarningLabel("Patient not found.");
			}
		}
		else if(e.getSource()==pProfileP.getfillButton()){
			getContentPane().removeAll();
			getContentPane().add(fillP);
			revalidate();
			repaint();
		}
		else if(e.getSource()==menuP.getSystemButton()){
			
		    getContentPane().removeAll();
		    getContentPane().add(systemP);
		    revalidate();
		    repaint();
		}
		/**
		 * only manager can access the ManageEmployeePage
		 */
		else if(e.getSource()==menuP.getEmployee()){
			String user=null, pass=null;
            if(currentUser.getPosition().toLowerCase().equals("manager")){
              getContentPane().removeAll();
              getContentPane().add(employeePage);
              ManageEmployee.fillEmployeeTable(employeePage);
              revalidate();
              repaint();
            }else{
              if(Credentials.UserInputs()){
              user=Credentials.getUser().getText();
              pass=Credentials.getPass().getText();
              }else System.out.println("user not found ...");

              if(ManageSystem.canAccess(ManageSystem.checkPosition(user, pass),"employee")){
                  getContentPane().removeAll();
                  getContentPane().add(employeePage);					
                  ManageEmployee.fillEmployeeTable(employeePage);					
                  revalidate();
                  repaint();
              }else
                  System.out.println("check your login credential");
            }
        }
		/**
		 * manager and pharmacist can access the drug page
		 */
		else if(e.getSource()==menuP.getDrugButton()){
			ManageDrug.setLowInventoryWarning(drugP);
			String user=null, pass=null;	
    		String position = currentUser.getPosition().toLowerCase();
			if(position.equals("manager")||position.equals("pharmacist")){
				getContentPane().removeAll();
				getContentPane().add(drugP);
				revalidate();
				repaint();
			}else{
                if(Credentials.UserInputs()){
				user=Credentials.getUser().getText();
				pass=Credentials.getPass().getText();
                }
				if(ManageSystem.canAccess(ManageSystem.checkPosition(user, pass),"drug")){
					getContentPane().removeAll();
					getContentPane().add(drugP);
					revalidate();
					repaint();
				}else
					System.out.println("check your login credential");
            }
		}
    	else if (e.getSource()==drugP.getRestockButton()){
    		getContentPane().removeAll();
    		getContentPane().add(restockP);
    		revalidate();
    		repaint();
    	}
    	else if (e.getSource()==drugP.getAddButton()){
    		getContentPane().removeAll();
    		getContentPane().add(nDrugP);
    		revalidate();
    		repaint();
    	}
		
		else if(e.getSource()==spatientP.getBackButton()){
			spatientP.getEnterPatient().setText("");
			getContentPane().removeAll();
			getContentPane().add(menuP);
			revalidate();
			repaint();
			spatientP.setWarningLabel("");
		}
		else if(e.getSource()==drugP.getBackButton()){
			ManageDrug.clearDrugPage(drugP);
			getContentPane().removeAll();
			getContentPane().add(menuP);
			revalidate();
			repaint();
		}
		else if(e.getSource()==drugP.getSearch()){
			String drugName= drugP.getDName().getText();
			Drug drugFound=ManageDrug.searchDrug(drugName);
			if(drugFound != null){
			ManageDrug.setDrugInventory(drugFound, drugP);
			}
			else {
				drugP.setDName();
			}
		}
		else if(e.getSource()==newPatientP.getCancel()){
			ManagePatient.clearNewPatient(newPatientP);
			getContentPane().removeAll();
			getContentPane().add(spatientP);
			revalidate();
			repaint();
			spatientP.setWarningLabel("");
		}
		else if(e.getSource()==pProfileP.getExitButton()){
			currentPatient=null;
			ManagePatient.clearTable(pProfileP);
			ManagePatient.resetUnpaid(pProfileP);
			getContentPane().removeAll();
			getContentPane().add(spatientP);
			revalidate();
			repaint();
			spatientP.setWarningLabel("");
		}else if(e.getSource()==pProfileP.getRemove()){
			if(ManagePatient.deletePatient(currentPatient)){
				currentPatient=null;
				getContentPane().removeAll();
				getContentPane().add(spatientP);
				revalidate();
				repaint();
			}else
				System.out.println("unable to delete patient");
		
		}else if(e.getSource()==pProfileP.getModify()){
			ManagePatient.modifyPatient(pProfileP);
		}
		else if(e.getSource()==pProfileP.getRemovePrescription()){	
			if(DeleteConfirmation.Confirm(pProfileP)){
			ManagePrescription.removePrescription(deleteP);
			ManagePrescription.displayPrescription(pProfileP);
			getContentPane().removeAll();
			getContentPane().add(pProfileP);
			revalidate();
			repaint();}
		}
		else if(e.getSource()==pProfileP.getRefill()){	
			if(DeleteConfirmation.Confirm(pProfileP)){
			ManagePrescription.refillDrug(deleteP);
			ManagePrescription.displayPrescription(pProfileP);
			getContentPane().removeAll();
			getContentPane().add(pProfileP);
			revalidate();
			repaint();}
		}
		else if(e.getSource()==fillP.getCancelButton()){
			ManagePrescription.clearFillPrescription(fillP);
			getContentPane().removeAll();
			getContentPane().add(pProfileP);
			revalidate();
			repaint();
		}
		else if(e.getSource()==fillP.getSubmit()){
			if(ManagePrescription.verifyPrescription(fillP)){
			ManagePrescription.addPrescription(fillP);
			ManagePrescription.displayPrescription(pProfileP);
			checkQuantity.setDrugName(fillP.getDrugName().getText());
			ManagePrescription.clearFillPrescription(fillP);
			getContentPane().removeAll();
			getContentPane().add(pProfileP);
			revalidate();
			repaint();}
			ManageDrug.checkDrugWarnings(checkQuantity);
		}
		else if(e.getSource()==restockP.getCancelButton()){
			restockP.getDname().setText("");
			restockP.getQuantity().setText("");
			getContentPane().removeAll();
			getContentPane().add(drugP);
			revalidate();
			repaint();
		}
		else if(e.getSource()==restockP.getRestock()){
			Drug drugbean=ManageDrug.restock(restockP);
			ManageDrug.setDrugInventory(drugbean, drugP);
			drugP.getDName().setText(drugbean.getDrugName());
			restockP.getDname().setText("");
			restockP.getQuantity().setText("");
			getContentPane().removeAll();
			getContentPane().add(drugP);
			revalidate();
			repaint();
		}
		else if(e.getSource()==nDrugP.getCancelButton()){
			ManageDrug.clearNewDrugPage(nDrugP);
			getContentPane().removeAll();
			getContentPane().add(drugP);
			revalidate();
			repaint();
		}
		else if(e.getSource()==nDrugP.getSubmit()){
			ManageDrug.addNewDrug(nDrugP);
			ManageDrug.clearNewDrugPage(nDrugP);
			getContentPane().removeAll();
			getContentPane().add(drugP);
			revalidate();
			repaint();
		}
		else if(e.getSource()==systemP.getBackButton()){
			getContentPane().removeAll();
			getContentPane().add(menuP);
			revalidate();
			repaint();
		}
		/**
		 * only manager can shut down the system
		 */
		else if(e.getSource()==systemP.getSystemExitButton()){
			if(currentUser!=null){
              if(ManageSystem.shutDown(currentUser.getUsername(), currentUser.getPass())){
                System.out.println("exiting the system ...");
                System.exit(0);
              }
            } 
			if(Credentials.UserInputs()){
				String user=Credentials.getUser().getText();
				String pass=Credentials.getPass().getText();
                
                if(ManageSystem.shutDown(user, pass)){
                System.out.println("exiting the system ...");
                System.exit(0);
                }else{
                  System.out.println("Only manager may shutdown the system! check your credential...");
			}
			}else{
              System.out.println("shutdown canceled");
			} 
		}
		else if(e.getSource()==systemP.getLogout()){
			System.out.println("logout pressed");
			getContentPane().removeAll();
			getContentPane().add(picLabel);
            currentUser=null;
			userField.setText("");
			passField.setText("");
			revalidate();
			repaint();
		}
        
		else if(e.getSource()==employeePage.getBack()){			
			getContentPane().removeAll();
			getContentPane().add(menuP);
			revalidate();
			repaint();
		}
		else if(e.getSource()==employeePage.getRemove()){	
			if(DeleteConfirmation.Confirm(employeePage)){
			ManageEmployee.deleteEmployee(employeePage);
			ManageEmployee.fillEmployeeTable(employeePage);
			getContentPane().removeAll();
			getContentPane().add(employeePage);
			revalidate();
			repaint();}
		}
		else if(e.getSource()==employeePage.getAdd()){			
			getContentPane().removeAll();
			getContentPane().add(newEmployee);
			revalidate();
			repaint();
		}
		else if(e.getSource()==employeePage.getAddNewSchedule()){	
			if(newSchedule.addNewSchedule()){
				try {
					ManageEmployee.addNewSchedule();
				} catch (ParseException e1) {
					
					e1.printStackTrace();
				}
			}
			getContentPane().removeAll();
			getContentPane().add(employeePage);
			revalidate();
			repaint();
		}else if(e.getSource()==employeePage.getModify()){
			if(ManageEmployee.modifyEmployee(employeePage, currentEmployee))
				System.out.println("employee information updated");
			else
				System.out.println("unable to update employee information");
		}
		else if(e.getSource()==newEmployee.getCancel()){
			ManageEmployee.clearNewEmployee(newEmployee);
			getContentPane().removeAll();
			getContentPane().add(employeePage);
			revalidate();
			repaint();
		}
		else if(e.getSource()==newEmployee.getSubmit()){
			if(ManageEmployee.verifyNewEmployee(newEmployee)){
			ManageEmployee.addNewEmployee(newEmployee);
			ManageEmployee.fillEmployeeTable(employeePage);
			ManageEmployee.clearNewEmployee(newEmployee);
			getContentPane().removeAll();
			getContentPane().add(employeePage);
			revalidate();
			repaint();}
		}
    }

	public static Employee getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(Employee bean) {
		currentUser = bean;
	}

	public JLabel getWarning() {
		return warning;
	}

	/**
	 * @return the currentPatient
	 */
	public static Patient getCurrentPatient() {
		return currentPatient;
	}
	public static Drug setCurrentDrug(Drug bean) {
		return currentDrug;
	}
	public static void setCurrentPrescription(Prescription bean){
		currentPrescription=bean;
	}
	public static Prescription getCurrentPrescription(){
		return currentPrescription;
	}
	public static Employee getCurrentEmployee(){
		return currentEmployee;
	}
public static ManageEmployeePage getPage(){
	return employeePage;
}

	/**
	 * @param currentPatient the currentPatient to set
	 */
	public static void setCurrentPatient(Patient currentPatient) {
		Gui.currentPatient = currentPatient;
	}

	public static void main(String args[]) throws IOException{	   			
		frame = new Gui();
		frame.setLocationRelativeTo ( null );
		frame.createPages();
		frame.addFirstPage();
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}

	public static void setCurrentEmployee(Employee currentEmployee) {
		Gui.currentEmployee= currentEmployee;
	}

	public static Drug getCheckQuantity() {
		return checkQuantity;
	}

	public static void setCheckQuantity(Drug checkQuantity) {
		Gui.checkQuantity = checkQuantity;
	}			 
}

			


