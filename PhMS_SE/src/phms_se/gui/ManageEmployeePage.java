package phms_se.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class ManageEmployeePage extends JPanel {
	
private JLabel title;
private JLabel currentSel;
private JTextField nameText;
private JTextField DoBText;
private JTextField phoneText;
private JTextField addressText;
private JTextField positionText;
private JTextField salaryText;
private JLabel nameLabel;
private JLabel DoBLabel;
private JLabel phoneLabel;
private JLabel addressLabel;
private JLabel positionLabel;
private JLabel currentEmp;
private JLabel salaryLabel;
private JTable currentEmployees;
private JButton addNew;
private JButton remove;
private JButton back;
private JPanel subpanel;
private JPanel currentpanel;
private JPanel currentEmployeeP;
private JPanel buttonPanel;

	
	public ManageEmployeePage(Gui frame){
		GridBagConstraints c = new GridBagConstraints();	
		JLabel picLabel=new JLabel();
        picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phms_se/resources/img/bg.jpg")));
		this.add(picLabel);
		picLabel.setLayout(new GridBagLayout());
		
		this.title = new JLabel("Employee Information");
		c.insets= new Insets(0,0,50,0);
		title.setFont(new Font("Comic Sans",Font.BOLD, 28));
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=2;
		picLabel.add(title,c);
		
		
		this.subpanel = new JPanel();
		subpanel.setPreferredSize(new java.awt.Dimension(500, 300));
		c.gridx=1;
		c.gridy=1;
		c.gridwidth=1;
		c.gridheight=1;
		subpanel.setOpaque(false);		 
		Border border1 = BorderFactory.createLineBorder(Color.black);
		subpanel.setBorder(border1);
		c.insets= new Insets(0,0,0,0);
		picLabel.add(subpanel,c);
		
		
		this.currentpanel = new JPanel();
		currentpanel.setPreferredSize(new java.awt.Dimension(475, 285));
		currentpanel.setOpaque(false);		 
		Border border2 = BorderFactory.createLineBorder(Color.black);
		currentpanel.setBorder(border2);
		c.insets= new Insets(0,0,0,0);
		c.gridx=0;
		c.gridy=1;
		subpanel.add(currentpanel,c);
		
		
		
		this.currentEmployeeP=new JPanel();
		currentEmployeeP.setPreferredSize(new java.awt.Dimension(400, 260));
		c.gridx=0;
		c.gridy=1;
		currentEmployeeP.setOpaque(false);	
		currentEmployeeP.setLayout(new GridBagLayout());
		picLabel.add(currentEmployeeP,c);
		this.buttonPanel=new JPanel();
		c.gridx=1;
		c.gridy=2;
		buttonPanel.setOpaque(false);	
		buttonPanel.setLayout(new GridBagLayout());
		picLabel.add(buttonPanel,c);
		 this.addNew = new JButton("Add New Employee");
		 addNew.addActionListener(frame);
		 c.insets= new Insets(15,5,20,0);
		 c.gridx=1;
		 c.gridy=3;
		 c.gridheight=1;
		 buttonPanel.add(addNew, c);
		 
		 this.remove = new JButton("Remove Employee");
		 c.gridx=2;
		 c.gridy=3;
		 buttonPanel.add(remove, c);
		
		 this.back = new JButton("Return to Menu");
		 c.gridx=3;
		 c.gridy=3;
		 back.addActionListener(frame);
		 buttonPanel.add(back, c);
		
		this.currentEmp=new JLabel("Current Employees");
		currentEmp.setFont(new Font("Comic Sans",Font.BOLD, 18));
		c.insets= new Insets(0,0,10,0);
		c.gridx=0;
		c.gridy=0;
		c.gridheight=1;
		c.gridwidth=2;
		currentEmployeeP.add(currentEmp,c);
		
		 String[] dcolumnName={"Current Employees" };
		 Object[][] ddata={{""},{""},{""},{""},{""},{""},{""},{""}};
		 currentEmployees = new JTable(ddata, dcolumnName);
		 currentEmployees.setRowHeight(25);
		 currentEmployees.setPreferredSize(new Dimension(200,200 ));
		 c.insets= new Insets(0,0,0,0);
		 c.gridx=0;
		 c.gridy=1;
		 currentEmployeeP.add(currentEmployees,c);
		 currentEmployees.setGridColor(Color.black);
		 currentEmployees.setBackground(Color.decode("#CCEEEE"));
		 Border border = BorderFactory.createLineBorder(Color.black);
		 currentEmployees.setBorder(border);
		 
		 currentpanel.setLayout(new GridBagLayout());

		 this.currentSel = new JLabel("Current Selection");
		 currentSel.setFont(new Font("Comic Sans",Font.BOLD, 18));
		 c.gridx=0;
		 c.gridy=0;	
		 c.gridwidth=3;
		 c.insets= new Insets(0,0,30,0);
		 currentpanel.add(currentSel,c);
		 
		 this.nameLabel=new JLabel("Name:");
		 nameLabel.setFont(new Font("Comic Sans",Font.BOLD, 15));
		 c.gridx=-1;
		 c.gridy=1;
		 c.gridwidth=1;
		 c.gridheight=1;
		 c.insets= new Insets(0,0,10,0);
		 currentpanel.add(nameLabel,c);
		 
		 this.DoBLabel=new JLabel("Date of Birth:");
		 DoBLabel.setFont(new Font("Comic Sans",Font.BOLD, 15));
		 c.gridx=0;
		 c.gridy=2;
		
		 currentpanel.add(DoBLabel,c);
		 
		 this.phoneLabel=new JLabel("Phone Number:");
		 phoneLabel.setFont(new Font("Comic Sans",Font.BOLD, 15));
		 c.gridx=0;
		 c.gridy=3;
		
		 currentpanel.add(phoneLabel,c);

		 this.addressLabel=new JLabel("Address:");
		 addressLabel.setFont(new Font("Comic Sans",Font.BOLD, 15));
		 c.gridx=0;
		 c.gridy=4;
		 
		 currentpanel.add(addressLabel,c);

		 this.positionLabel=new JLabel("Position:");
		 positionLabel.setFont(new Font("Comic Sans",Font.BOLD, 15));
		 c.gridx=0;
		 c.gridy=5;
		 
		 currentpanel.add(positionLabel,c);

		 this.salaryLabel=new JLabel("Salary:");
		 salaryLabel.setFont(new Font("Comic Sans",Font.BOLD, 15));
		 c.gridx=0;
		 c.gridy=6;
		 currentpanel.add(salaryLabel,c);
		 this.nameText=new JTextField(15);
		 nameText.setFont(new Font("Comic Sans",Font.BOLD, 15));
		 c.gridx=1;
		 c.gridy=1;
		 c.gridwidth=2;
		 c.gridheight=1;
		 c.insets= new Insets(0,20,0,0);
		 currentpanel.add(nameText,c);
		 
		 this.DoBText=new JTextField(15);
		 DoBText.setFont(new Font("Comic Sans",Font.BOLD, 15));
		 c.gridx=1;
		 c.gridy=2;
		
		 currentpanel.add(DoBText,c);
		 
		 this.phoneText=new JTextField(15);
		 phoneText.setFont(new Font("Comic Sans",Font.BOLD, 15));
		 c.gridx=1;
		 c.gridy=3;
		
		 currentpanel.add(phoneText,c);

		 this.addressText=new JTextField(15);
		 addressText.setFont(new Font("Comic Sans",Font.BOLD, 15));
		 c.gridx=1;
		 c.gridy=4;
		 
		 currentpanel.add(addressText,c);

		 this.positionText=new JTextField(15);
		 positionText.setFont(new Font("Comic Sans",Font.BOLD, 15));
		 c.gridx=1;
		 c.gridy=5;
		 
		 currentpanel.add(positionText,c);

		 this.salaryText=new JTextField(15);
		 salaryText.setFont(new Font("Comic Sans",Font.BOLD, 15));
		 c.gridx=1;
		 c.gridy=6;
	
		 currentpanel.add(salaryText,c);
		 
		 
		

	}
	JButton getBack(){
		return this.back;
	}
	JButton getAdd(){
		return this.addNew;
	}
	public JTable getTable(){
		return this.currentEmployees;
	}
	
}
