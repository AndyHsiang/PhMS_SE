package phms_se.gui;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class NewPatientPage extends JPanel {
	private JTextField fName;
	private JTextField lName;
	private JTextField DoB;
	private JTextField doctor;
	private JTextField phone;
	private JTextField address;
	private JLabel first;
	private JLabel last;
	private JLabel DoBL;
	private JLabel doctorL;
	private JLabel phoneL;
	private JLabel addressL;
	private JButton cancel;
	private JButton submit;
	
	NewPatientPage(Gui frame){
		
		GridBagConstraints c = new GridBagConstraints();
		JLabel picLabel=new JLabel();
        picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phms_se/resources/img/bg.jpg")));
		this.add(picLabel);
		picLabel.setLayout(new GridBagLayout());
		this.setLayout(new GridBagLayout());
			
		this.first = new JLabel ("First Name:");
		first.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
		picLabel.add(first,c);
		this.fName= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		fName.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=0;
		c.gridwidth=1;
		picLabel.add(fName,c);
		this.last = new JLabel ("Last Name:");
		last.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=1;
		picLabel.add(last,c);
		this.lName= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		lName.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=1;
		c.gridwidth=1;
		picLabel.add(lName,c);
		this.DoBL = new JLabel ("Date of Birth:");
		DoBL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=1;
		picLabel.add(DoBL,c);
		this.DoB= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		DoB.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=2;
		c.gridwidth=1;
		picLabel.add(DoB,c);
		this.doctorL = new JLabel ("Primary Doctor:");
		doctorL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=3;
		c.gridwidth=1;
		picLabel.add(doctorL,c);
		this.doctor= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		doctor.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=3;
		c.gridwidth=1;
		picLabel.add(doctor,c);

		this.phoneL = new JLabel ("Phone Number:");
		phoneL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=4;
		c.gridwidth=1;
		picLabel.add(phoneL,c);
		this.phone= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		phone.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=4;
		c.gridwidth=1;
		picLabel.add(phone,c);
				 
		this.addressL = new JLabel ("Address:");
		addressL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=5;
		c.gridwidth=1;
		picLabel.add(addressL,c);
		this.address= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		address.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=5;
		c.gridwidth=1;
		picLabel.add(address,c);
				 
		this.submit = new JButton ("Submit");
		submit.setPreferredSize(new Dimension(100, 40));
		submit.addActionListener(frame);

		c.insets= new Insets(0,0,0,0);
		c.gridx=0;
		c.gridy=6;
		picLabel.add(submit,c);
				 
		this.cancel = new JButton ("Cancel");
		cancel.setPreferredSize(new Dimension(100, 40));
		cancel.addActionListener(frame);
		c.insets= new Insets(0,0,0,0);
		c.gridx=2;
		c.gridy=6;
		picLabel.add(cancel,c);   
	}
    
    public void presetText(){
      
    }
	public JTextField getfName() {
		return fName;
	}

	public JTextField getlName() {
		return lName;
	}

	public JTextField getDoB() {
		return DoB;
	}

	public JTextField getDoctor() {
		return doctor;
	}

	public JTextField getPhone() {
		return phone;
	}

	public JTextField getAddress() {
		return address;
	}

	public JButton getCancel() {
		return cancel;
	}

	public JButton getSubmit() {
		return submit;
	}
}
