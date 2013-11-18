package phms_se.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class NewEmployeePage extends JPanel {
	private JLabel nameL;
	private JLabel usernameL;
	private JLabel passL;
	private JLabel confirmPassL;
	private JLabel DoBL;
	private JLabel phoneL;
	private JLabel addressL;
	private JLabel emailL;
	private JLabel positionL;
	private JTextField nameT;
	private JTextField usernameT;
	private JTextField passT;
	private JTextField confirmPassT;
	private JTextField DoBT;
	private JTextField phoneT;
	private JTextField addressT;
	private JTextField emailT;
	private JTextField positionT;
	private JButton submit;
	private JButton cancel;
	
	
	public NewEmployeePage(Gui frame){
		GridBagConstraints c = new GridBagConstraints();
		JLabel picLabel=new JLabel();
        picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phms_se/resources/img/bg.jpg")));
		this.add(picLabel);
		picLabel.setLayout(new GridBagLayout());
		this.setLayout(new GridBagLayout());
			
		this.nameL = new JLabel ("Name:");
		nameL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
		picLabel.add(nameL,c);
		this.nameT= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		nameT.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=0;
		c.gridwidth=1;
		picLabel.add(nameT,c);
		this.usernameL = new JLabel ("Username:");
		usernameL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=1;
		picLabel.add(usernameL,c);
		this.usernameT= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		usernameT.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=1;
		c.gridwidth=1;
		picLabel.add(usernameT,c);
		this.passL = new JLabel ("Password:");
		passL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=1;
		picLabel.add(passL,c);
		this.passT= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		passT.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=2;
		c.gridwidth=1;
		picLabel.add(passT,c);
		this.confirmPassL = new JLabel ("Confirm Password:");
		confirmPassL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=3;
		c.gridwidth=1;
		picLabel.add(confirmPassL,c);
		this.confirmPassT= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		confirmPassT.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=3;
		c.gridwidth=1;
		picLabel.add(confirmPassT,c);

		this.DoBL = new JLabel ("Date of Birth:");
		DoBL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=4;
		c.gridwidth=1;
		picLabel.add(DoBL,c);
		this.DoBT= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		DoBT.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=4;
		c.gridwidth=1;
		picLabel.add(DoBT,c);
				 
		this.phoneL = new JLabel ("Phone Number:");
		phoneL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=5;
		c.gridwidth=1;
		picLabel.add(phoneL,c);
		this.phoneT= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		phoneT.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=5;
		c.gridwidth=1;
		picLabel.add(phoneT,c);
		
		this.addressL = new JLabel ("Address:");
		addressL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=6;
		c.gridwidth=1;
		picLabel.add(addressL,c);
		this.addressT= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		addressT.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=6;
		c.gridwidth=1;
		picLabel.add(addressT,c);
		
		this.emailL = new JLabel ("E-Mail:");
		emailL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=7;
		c.gridwidth=1;
		picLabel.add(emailL,c);
		this.emailT= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		emailT.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=7;
		c.gridwidth=1;
		picLabel.add(emailT,c);
		
		this.positionL = new JLabel ("Position:");
		positionL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.insets= new Insets(0,0,20,0);
		c.gridx=0;
		c.gridy=8;
		c.gridwidth=1;
		picLabel.add(positionL,c);
		this.positionT= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		positionT.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=8;
		c.gridwidth=1;
		picLabel.add(positionT,c);
				 
		this.submit = new JButton ("Submit");
		submit.setPreferredSize(new Dimension(100, 40));
		submit.addActionListener(frame);
		c.insets= new Insets(0,0,0,0);
		c.gridx=0;
		c.gridy=9;
		picLabel.add(submit,c);
				 
		this.cancel = new JButton ("Cancel");
		cancel.setPreferredSize(new Dimension(100, 40));
		cancel.addActionListener(frame);
		c.insets= new Insets(0,0,0,0);
		c.gridx=2;
		c.gridy=9;
		picLabel.add(cancel,c);   
	}
	JButton getCancel(){
		return this.cancel;
	}
	JButton getSubmit(){
		return this.submit;
	}
}