package phms_se.gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import phms_se.process.ManagePrescription;




@SuppressWarnings("serial")
public class PatientProfilePage extends JPanel{
	private JLabel pNameLabel;
	private JLabel pDobLabel;
	private JLabel pDoctorLabel;
	private JLabel phoneNumberLabel;
	private JLabel pAddressLabel;
	private JLabel stateL;
	private JLabel zipL;
	private JLabel cityL;
	private JTextField pName;
	private JTextField pDob;
	private JTextField pDoctor;
	private JTextField phoneNumber;
	private JTextField pAddress;
	private JTextField stateT;
	private JTextField zipT;
	private JTextField cityT;
	private JButton fillPrescription;
	private JButton removePrescription;
	private JButton exitProfile;
	private JButton modify;
	private JButton remove;
	private JScrollPane tablePane, expandList;
	private JButton checkOut;
	private JLabel prescriptionHistory;
	final JTable prescriptionTable;
	private JButton refillP;
	
	private JTextArea prescriptionList;
	private JPanel checkOutPane,listPane;
	private JLabel insuranceCoPay, subTotal, tax, total,
					coPayAmt, subAmt, taxAmt, totalAmt;
	private JRadioButton credit, cash, check;
	private ButtonGroup paymentMethod;
	
	
	PatientProfilePage(Gui frame){
		
		GridBagLayout checkOutLayout = new GridBagLayout();
		this.checkOutPane=new JPanel();
		checkOutPane.setLayout(checkOutLayout);
		GridBagConstraints cc = new GridBagConstraints();
		listPane=new JPanel(new FlowLayout());
		
		cc.insets= new Insets(0,10,10,0);
		prescriptionList=new JTextArea("unpaid prescription list");
		prescriptionList.setColumns(100);
		prescriptionList.setRows(100);
		prescriptionList.setLineWrap(true);
		expandList=new JScrollPane(prescriptionList);
		expandList.setPreferredSize(new Dimension(350,100));	
		cc.gridx=0;
		cc.gridy=2;
		cc.gridwidth=5;
		cc.gridheight=2;
		checkOutPane.add(expandList, cc);
		
		cc.insets= new Insets(0,0,0,0);
		insuranceCoPay=new JLabel("co pay");
		cc.gridx=4;
		cc.gridy=5;
		cc.gridwidth=1;
		cc.gridheight=1;
		checkOutPane.add(insuranceCoPay, cc);
		
		coPayAmt=new JLabel("$ 0");
		cc.gridx=5;
		cc.gridy=5;
		cc.gridwidth=1;
		cc.gridheight=1;
		checkOutPane.add(coPayAmt, cc);
		
		subTotal=new JLabel("subtotal");
		cc.gridx=4;
		cc.gridy=6;
		cc.gridwidth=1;
		cc.gridheight=1;
		checkOutPane.add(subTotal, cc);
		
		subAmt=new JLabel("$ 0");
		cc.gridx=5;
		cc.gridy=6;
		cc.gridwidth=1;
		cc.gridheight=1;
		checkOutPane.add(subAmt, cc);
		
		tax=new JLabel("tax");
		cc.gridx=4;
		cc.gridy=7;
		cc.gridwidth=1;
		cc.gridheight=1;
		checkOutPane.add(tax, cc);
		
		taxAmt=new JLabel("$ 0");
		cc.gridx=5;
		cc.gridy=7;
		cc.gridwidth=1;
		cc.gridheight=1;
		checkOutPane.add(taxAmt, cc);
		
		total=new JLabel("total");
		cc.gridx=4;
		cc.gridy=8;
		cc.gridwidth=1;
		cc.gridheight=1;
		checkOutPane.add(total, cc);
		
		totalAmt=new JLabel("$ 0");
		cc.gridx=5;
		cc.gridy=8;
		cc.gridwidth=1;
		cc.gridheight=1;
		checkOutPane.add(totalAmt, cc);
		
		cc.insets= new Insets(0,0,0,0);
		credit=new JRadioButton("Credit");
		cc.gridx=0;
		cc.gridy=5;
		cc.gridwidth=1;
		cc.gridheight=1;
		checkOutPane.add(credit, cc);
		
		cash=new JRadioButton("cash");
		cc.gridx=0;
		cc.gridy=6;
		cc.gridwidth=1;
		cc.gridheight=1;
		checkOutPane.add(cash, cc);
		
		check=new JRadioButton("check");
		cc.gridx=0;
		cc.gridy=7;
		cc.gridwidth=1;
		cc.gridheight=1;
		checkOutPane.add(check, cc);
		
		paymentMethod=new ButtonGroup();
		paymentMethod.add(credit);
		paymentMethod.add(cash);
		paymentMethod.add(check);
		
		prescriptionList.setFont(new Font("Comic Sans",Font.BOLD, 14));
		insuranceCoPay.setFont(new Font("Comic Sans",Font.BOLD, 14));
		subTotal.setFont(new Font("Comic Sans",Font.BOLD, 14));
		tax.setFont(new Font("Comic Sans",Font.BOLD, 14));
		total.setFont(new Font("Comic Sans",Font.BOLD, 14));
		credit.setFont(new Font("Comic Sans",Font.BOLD, 14));
		cash.setFont(new Font("Comic Sans",Font.BOLD, 14));
		check.setFont(new Font("Comic Sans",Font.BOLD, 14));
		prescriptionList.setOpaque(false);
		insuranceCoPay.setOpaque(false);
		expandList.setOpaque(false);
		subTotal.setOpaque(false);
		tax.setOpaque(false);
		total.setOpaque(false);
		credit.setOpaque(false);
		cash.setOpaque(false);
		check.setOpaque(false);
		checkOutPane.setOpaque(false);
		listPane.setOpaque(false);		
		
		GridBagConstraints c = new GridBagConstraints();
			JLabel picLabel=new JLabel();
            picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phms_se/resources/img/bg.jpg")));
			   this.add(picLabel);
			   picLabel.setLayout(new GridBagLayout());
				this.setLayout(new GridBagLayout());
				
				this.pNameLabel= new JLabel("Patient Name:");
				c.insets= new Insets(0,0,10,0);
				 c.gridx=0;
				 c.gridy=0;
				 c.gridwidth=1;
				 picLabel.add(pNameLabel,c);
				
				this.pDobLabel= new JLabel("DOB:");
					 c.gridy=1;
					 
					 picLabel.add(pDobLabel,c);
					 
			    this.pDoctorLabel= new JLabel("Primary Doctor:");
						 c.gridy=2;
						
						 picLabel.add(pDoctorLabel,c);
			    this.phoneNumberLabel= new JLabel("Phone Number:");
							c.gridy=3;
							
							 picLabel.add(phoneNumberLabel,c);
				this.pAddressLabel= new JLabel("Address:");
							c.gridy=4;								 
								 picLabel.add(pAddressLabel,c);
	
				this.pName= new JTextField("",15);
				c.gridy=0;
								 c.gridx=1;
								 picLabel.add(pName,c);
				this.pDob= new JTextField(15);
				c.gridy=1;
				c.gridx=1;
				 picLabel.add(pDob,c);
				 this.pDoctor= new JTextField(15);
					c.gridy=2;
					c.gridx=1;
					 picLabel.add(pDoctor,c);
					 this.phoneNumber= new JTextField(15);
						c.gridy=3;
						c.gridx=1;
						 picLabel.add(phoneNumber,c);
						 this.pAddress= new JTextField(15);
							c.gridy=4;
							c.gridx=1;
							 picLabel.add(pAddress,c);
				this.stateL = new JLabel("State:");
				c.gridy=5;
				c.gridx=0;
				picLabel.add(stateL,c);
				this.stateT = new JTextField(15);
				c.gridy=5;
				c.gridx=1;
				picLabel.add(stateT,c);
				this.zipL = new JLabel("Zip Code:");
				c.gridy=6;
				c.gridx=0;
				picLabel.add(zipL,c);
				this.zipT = new JTextField(15);
				c.gridy=6;
				c.gridx=1;
				picLabel.add(zipT,c);
				
				this.cityL = new JLabel("City:");
				c.gridy=7;
				c.gridx=0;
				picLabel.add(cityL,c);
				
				this.cityT = new JTextField(15);
				c.gridy=7;
				c.gridx=1;
				picLabel.add(cityT,c);
					
				this.prescriptionHistory = new JLabel("Prescription History");
				prescriptionHistory.setFont(new Font("Comic Sans",Font.BOLD, 28));
				c.insets= new Insets(0,0,40,0);
				c.gridx=2;
				c.gridy=1;
				c.gridheight=2;
				
				picLabel.add(prescriptionHistory,c);
				
	
				this.fillPrescription= new JButton("Fill Prescription");
				c.insets= new Insets(20,0,0,0);
				c.gridx=0;
				c.gridy=8;
				c.gridwidth=1;
				c.gridheight=1;
				fillPrescription.setPreferredSize(new Dimension(150, 35));
				picLabel.add(fillPrescription, c);
				fillPrescription.addActionListener(frame);
				this.modify= new JButton("Modify");
				c.insets= new Insets(20,0,0,0);
				c.gridx=1;
				c.gridy=8;
				c.gridwidth=1;
				modify.setPreferredSize(new Dimension(150, 35));
				modify.addActionListener(frame);
				picLabel.add(modify, c);
				this.remove= new JButton("Remove Patient");
				c.insets= new Insets(20,0,0,0);
				c.gridx=1;
				c.gridy=9;
				c.gridwidth=1;
				remove.setPreferredSize(new Dimension(150, 35));
				remove.addActionListener(frame);
				picLabel.add(remove, c);
				this.checkOut= new JButton("Checkout");
				checkOut.addActionListener(frame);
				c.insets= new Insets(20,0,0,0);
				c.gridx=1;
				c.gridy=10;
				c.gridwidth=1;
				checkOut.setPreferredSize(new Dimension(150, 35));
				checkOut.addActionListener(frame);
				picLabel.add(checkOut, c);
				this.removePrescription= new JButton("Remove Prescription");
				removePrescription.addActionListener(frame);
				c.gridy=9;
				c.gridx=0;
				c.gridwidth=1;
				removePrescription.setPreferredSize(new Dimension(150, 35));
				picLabel.add(removePrescription, c);
				this.exitProfile= new JButton("Exit Patient Profile");
				exitProfile.addActionListener(frame);
				exitProfile.setPreferredSize(new Dimension(150, 35));
				c.gridy=10;
				picLabel.add(exitProfile, c);
				this.refillP = new JButton ("Refill Prescription");
				refillP.addActionListener(frame);
				refillP.setPreferredSize(new Dimension(150, 35));
				c.gridy=11;
				picLabel.add(refillP,c);
			/*	
				this.drugHist=new JLabel("Drug History");
				c.insets= new Insets(0,100,0,0);
				drugHist.setFont(new Font("Comic Sans",Font.BOLD, 28));
				c.gridx=2;
				c.gridy=0;
				c.gridwidth=2;
				picLabel.add(drugHist,c);
				String[] dcolumnName={"Drug History" };
				Object[][] ddata={{1},{11},{1},{1},{1},{1},{1},{1}};
				drugHistory = new JTable(ddata, dcolumnName);
				drugHistory.setRowHeight(25);
				drugHistory.setPreferredSize(new Dimension(200,200 ));
				c.insets= new Insets(-25,100,0,0);
				c.gridy=1;
				c.gridheight=7;
				picLabel.add(drugHistory,c);
				 drugHistory.setBackground(Color.decode("#CCEEEE"));
				 Border border = BorderFactory.createLineBorder(Color.black);
				 drugHistory.setBorder(border);
				 */class MyTableModel extends AbstractTableModel{
					 private  String[] columnNames={"Prescription ID","Drug Name","Quantity","Dose","Date Filled","Start Date","Refills rm","paid"};
					 private Object[][] data={{"asdasdasd","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""}/*,{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""},{"","","","","","",""}*/};
					 public int getColumnCount() {
				            return columnNames.length;
				        }
					 	
				        public int getRowCount() {
				            return data.length;
				        }

				        public String getColumnName(int col) {
				            return columnNames[col];
				        }
				       public void setValueAt(Object value, int row, int column){
				        	data[row][column]= value;
				        	
				       }

				        public Object getValueAt(int row, int col) {
				            return data[row][col];
				        }
				 }
				
				    class MyRenderer implements TableCellRenderer {

				        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
				                boolean hasFocus, int row, int column) {
				            JTextField editor = new JTextField();
				            if (value != null) {
				                editor.setText(value.toString());
				            }
				         
				            //if(Gui.getCurrentPrescription().getPayStatus()){
				            editor.setFont(new Font("Comic Sans",Font.BOLD, 13));
				            if(!table.getValueAt(row,6).toString().equals("0")){
				            if(table.getValueAt(row,7).equals(true))
				            editor.setBackground(Color.green);
				            else if(table.getValueAt(row,7).equals(false))
				            	editor.setBackground(Color.red);}
				            else editor.setBackground(Color.GRAY);
				            
				            return editor;
				        }
				    }
			
					prescriptionTable = new JTable(new MyTableModel());
					prescriptionTable.getColumnModel().getColumn(7).setMinWidth(0);
					prescriptionTable.getColumnModel().getColumn(7).setMaxWidth(0);
					prescriptionTable.setPreferredSize(new Dimension(770,520 ));
					prescriptionTable.setRowHeight(20);
			
					prescriptionTable.setDefaultRenderer(Object.class, new MyRenderer());
					c.insets= new Insets(0,30,0,0);
					c.gridx=2;
					c.gridy=2;
					c.gridwidth=1;
					c.gridheight=4;
					//picLabel.add(table,c);
					prescriptionTable.setBackground(Color.decode("#CCEEEE"));
					 Border border2 = BorderFactory.createLineBorder(Color.black);
					 prescriptionTable.setBorder(border2);
					 this.tablePane=new JScrollPane(prescriptionTable);
					 tablePane.setPreferredSize(new Dimension(750,150 ));
					 picLabel.add(tablePane,c);
	
	c.insets= new Insets(20,20,0,0);
	c.gridx=2;
	c.gridy=4;
	c.gridwidth=50;
	c.gridheight=50;	
	picLabel.add(checkOutPane,c);
}
	   JButton getfillButton() {
			return this.fillPrescription;
	   }
	   JButton getExitButton(){
		   return this.exitProfile;
	   }
	public JTable getPrescriptionHistory(){
		return prescriptionTable;
	}
	public JTextField getpName() {
		return pName;
	}
	public JTextField getZipT(){
		return zipT;
	}
	public JTextField getCityT(){
		return cityT;
	}
	public JTextField getStateT(){
		return stateT;
	}
	public void setpName(JTextField pName) {
		this.pName = pName;
	}
	public JTextField getpDob() {
		return pDob;
	}
	public void setpDob(JTextField pDob) {
		this.pDob = pDob;
	}
	public JTextField getpDoctor() {
		return pDoctor;
	}
	public void setpDoctor(JTextField pDoctor) {
		this.pDoctor = pDoctor;
	}
	public JTextField getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(JTextField phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public JTextField getpAddress() {
		return pAddress;
	}
	public void setpAddress(JTextField pAddress) {
		this.pAddress = pAddress;
	}
	public JButton getRemove() {
		return remove;
	}
	public JButton getModify() {
		return modify;
	}
	public void setModify(JButton modify) {
		this.modify = modify;
	}
	public JButton getRemovePrescription() {
		return this.removePrescription;
	}
	public JButton getRefill(){
		return this.refillP;
	}
	 public JButton getCheckOut(){
		 return checkOut;
	 }
	public JTextArea getPrescriptionList() {
		return prescriptionList;
	}
	public void setPrescriptionList(JTextArea prescriptionList) {
		this.prescriptionList = prescriptionList;
	}
	public JLabel getInsuranceCoPay() {
		return insuranceCoPay;
	}
	public void setInsuranceCoPay(JLabel insuranceCoPay) {
		this.insuranceCoPay = insuranceCoPay;
	}
	public JLabel getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(JLabel subTotal) {
		this.subTotal = subTotal;
	}
	public JLabel getTax() {
		return tax;
	}
	public void setTax(JLabel tax) {
		this.tax = tax;
	}
	public JLabel getTotal() {
		return total;
	}
	public void setTotal(JLabel total) {
		this.total = total;
	}
	public JPanel getCheckOutPane() {
		return checkOutPane;
	}
	public JRadioButton getCredit() {
		return credit;
	}
	public JRadioButton getCash() {
		return cash;
	}
	public JRadioButton getCheck() {
		return check;
	}
	public JLabel getCoPayAmt() {
		return coPayAmt;
	}
	public void setCoPayAmt(JLabel coPayAmt) {
		this.coPayAmt = coPayAmt;
	}
	public JLabel getSubAmt() {
		return subAmt;
	}
	public void setSubAmt(JLabel subAmt) {
		this.subAmt = subAmt;
	}
	public JLabel getTaxAmt() {
		return taxAmt;
	}
	public void setTaxAmt(JLabel taxAmt) {
		this.taxAmt = taxAmt;
	}
	public JLabel getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(JLabel totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	   }
