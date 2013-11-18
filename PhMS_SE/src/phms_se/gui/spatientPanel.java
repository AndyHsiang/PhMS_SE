package phms_se.gui;
import java.awt.*;

import javax.swing.*;
@SuppressWarnings("serial")
public class spatientPanel extends JPanel{
	private JButton newPatient;
	private JButton back;
	private JButton search;
	private JLabel searchPatient;
	private JTextField enterPatient;
	private JLabel warning;
	
	spatientPanel(Gui frame){
		GridBagConstraints c = new GridBagConstraints();
		JLabel picLabel=new JLabel();
        picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phms_se/resources/img/bg.jpg")));
		this.add(picLabel);
		picLabel.setLayout(new GridBagLayout());
		this.setLayout(new GridBagLayout());

		this.searchPatient = new JLabel ("Search Patient:");
		searchPatient.setFont(new Font("Comic Sans",Font.BOLD, 20));
		c.insets= new Insets(0,0,18,0);
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=2;
		picLabel.add(searchPatient,c);
		this.enterPatient= new JTextField(15);
		c.insets= new Insets(0,0,0,0);
		enterPatient.setFont(new Font("Comic Sans",Font.BOLD, 14));
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=2;
		picLabel.add(enterPatient,c);
			
		this.search = new JButton ("Search");
		c.insets= new Insets(0,10,0,0);
		c.gridwidth=1;
		c.gridx=2;
		c.gridy=1;
		picLabel.add(search,c);
		search.addActionListener(frame);
		this.newPatient = new JButton ("New Patient");
		c.insets= new Insets(12,0,0,0);
		c.gridx=1;
		c.gridy=2;
		picLabel.add(newPatient,c);
		newPatient.addActionListener(frame);
		this.back = new JButton ("Back");
		c.gridx=0;
		c.gridy=2;
		picLabel.add(back,c);
		back.addActionListener(frame);
		
		//stuff
		this.warning = new JLabel (" ");
		c.insets = new Insets(20,0,0,0);
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=2;
		picLabel.add(warning,c);
		warning.setForeground(Color.red);
	}
	JButton getNewPatientButton() {
		return this.newPatient;
   }	
	JButton getSearchButton(){
		return this.search;
	}
	JButton getBackButton(){
		return this.back;
	}
	public JTextField getEnterPatient() {
		return enterPatient;
	}
	public void setEnterPatient(JTextField enterPatient) {
		this.enterPatient = enterPatient;
	}
	public void setWarningLabel(String label){
		this.warning.setText(label);
		
	}
}

