package phms_se.gui;
import java.awt.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("serial")
//MAIN NAVIGATION PAGE
public class menuPanel extends JPanel{
	
	private JButton patient;
	private JButton employee;
	private JLabel menu;
	private JButton drug;
	private JButton system;
	private JPanel borderMenu;
	
	menuPanel(Gui frame) throws IOException{
		
		GridBagConstraints c = new GridBagConstraints();	
		JLabel picLabel=new JLabel();
        picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phms_se/resources/img/bg.jpg")));
		this.add(picLabel);
		picLabel.setLayout(new GridBagLayout());
		c.insets = new Insets(0,10,10,10);
		c.gridy=1;
		
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.blue);
		this.patient = new JButton ("Patient");
		patient.setPreferredSize(new Dimension(170, 120));
		picLabel.add(patient,c);
		patient.addActionListener(frame);
		this.employee = new JButton ("Employee");
		employee.setPreferredSize(new Dimension(170, 120));
		employee.addActionListener(frame);
		picLabel.add(employee,c);
		this.drug = new JButton ("Drug Inventory");
		drug.setPreferredSize(new Dimension(170, 120));
		picLabel.add(drug,c);
		drug.addActionListener(frame);
		this.system= new JButton("System");
		system.addActionListener(frame);
		system.setPreferredSize(new Dimension(170, 120));
		picLabel.add(system,c);
		this.borderMenu=new JPanel();
		this.menu= new JLabel("Main Menu");
		menu.setFont(new Font("Comic Sans",Font.BOLD, 48));
		menu.setForeground(Color.BLACK);
		c.insets = new Insets(0,10,100,0);
		c.gridx=1;
		c.gridy=0;
		c.gridwidth=2;
		borderMenu.setOpaque(false);
		
		picLabel.add(borderMenu,c);
		borderMenu.add(menu);
	}
			
		JButton getPatientButton() {
			return this.patient;
		}		   
		JButton getDrugButton(){
			return this.drug;
		}
		JButton getSystemButton(){
			return this.system;
		}

		public JButton getEmployee() {
			return employee;
		}
}