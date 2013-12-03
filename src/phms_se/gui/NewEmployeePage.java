package phms_se.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
@SuppressWarnings("serial")
//NEW EMPLOYEE PAGE
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
	private JLabel warning;
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
	private JComboBox day;
	private JComboBox month;
	private JComboBox year;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		/*this.DoBT= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		DoBT.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=4;
		c.gridwidth=1;
		picLabel.add(DoBT,c);*/
		String[] monthBox = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		this.month=new JComboBox(monthBox);
		c.insets= new Insets(0,0,20,100);
		c.gridx=2;
		c.gridy=4;
		c.gridwidth=1;
		picLabel.add(month,c);
		String[] dayBox={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		this.day=new JComboBox(dayBox);
		c.insets= new Insets(0,35,20,0);
		c.gridx=2;
		c.gridy=4;
		c.gridwidth=1;
		picLabel.add(day,c);
		String[] yearBox = new String[100];
		
		for(int i=0,years=2013;i<100;i++){
			
			yearBox[i]=""+years;
			years--;
		}
		
		this.year=new JComboBox(yearBox);
		c.insets= new Insets(0,130,20,0);
		c.gridx=2;
		c.gridy=4;
		c.gridwidth=1;
		picLabel.add(year,c);		 
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
		this.warning=new JLabel("");
		c.gridx=0;
		c.gridy=10;
		c.gridwidth=3;
		warning.setForeground(Color.red);
		picLabel.add(warning,c);
		
	}
	public void presetText(){
		
	}
	public JTextField getPassword(){
		String pass=passT.getText();
		String confirmedPass=confirmPassT.getText();
		if(pass.equals(confirmedPass)){
			return passT;
		}else return null;
	}
	public JTextField getEmpName(){
		return nameT;	
		}
		public JTextField getEmpUsername(){
			return usernameT;
			
		}
	
		public JTextField getEmpPhone(){
			return phoneT;
			
		}public JTextField getEmpAddress(){
			return addressT;
			
		}public JTextField getEmpEmail(){
			return emailT;
		}public JTextField getEmpPosition(){
			return positionT;
		}
		public JTextField getConfirmPassword(){
			return confirmPassT;
		}
		public JTextField getPasswordForClear(){
			return passT;
		}
		
	JButton getCancel(){
		return this.cancel;
	}
	JButton getSubmit(){
		return this.submit;
	}@SuppressWarnings("rawtypes")
	public JComboBox getYear(){
		return year;
	}@SuppressWarnings("rawtypes")
	public JComboBox getMonth(){
		return month;
	}
	@SuppressWarnings("rawtypes")
	public JComboBox getDay(){
		return day;
	}
	public String getDob(){
		String year= getYear().getSelectedItem().toString();
		System.out.println(year);
		String month=getMonth().getSelectedItem().toString();
		String day=getDay().getSelectedItem().toString();
		
		switch(month){
		 case "January": month="01";break;
		 case "February": month="02";break;
		 case "March": month="03";break;
		 case "April": month="04";break;
		 case "May": month="05";break;
		 case "June": month="06";break;
		 case "July": month="07";break;
		 case "August": month="08";break;
		 case "September": month="09";break;
		 case "October": month="10";break;
		 case "November": month="11";break;
		 case "December": month="12";break;}
		 String DoB= year+"-"+day +"-"+ month;
	return DoB;
}
	public JLabel getWarning(){
		return warning;
	}
}