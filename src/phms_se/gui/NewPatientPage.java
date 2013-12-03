package phms_se.gui;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
//NEW PATIENT PAGE
public class NewPatientPage extends JPanel {
	private JTextField fName;
	private JTextField lName;
	private JTextField doctor;
	private JTextField phone;
	private JTextField address;
	private JLabel first;
	private JLabel last;
	private JLabel DoBL;
	private JLabel doctorL;
	private JLabel phoneL;
	private JLabel addressL;
	private JLabel warning;
	private JButton cancel;
	private JButton submit;
	private JLabel stateL;
	private JLabel zipL;
	private JLabel cityL;
	private JTextField stateT;
	private JTextField zipT;
	private JTextField cityT;
	@SuppressWarnings("rawtypes")
	private JComboBox day;
	@SuppressWarnings("rawtypes")
	private JComboBox month;
	@SuppressWarnings("rawtypes")
	private JComboBox year;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		/*this.DoB= new JTextField(15);
		c.insets= new Insets(0,0,20,0);
		DoB.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridx=2;
		c.gridy=2;
		c.gridwidth=1;
		picLabel.add(DoB,c);*/
		String[] monthBox = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		this.month=new JComboBox(monthBox);
		c.insets= new Insets(0,0,20,100);
		c.gridx=2;
		c.gridy=2;
		c.gridwidth=1;
		picLabel.add(month,c);
		String[] dayBox={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		this.day=new JComboBox(dayBox);
		c.insets= new Insets(0,35,20,0);
		c.gridx=2;
		c.gridy=2;
		c.gridwidth=1;
		picLabel.add(day,c);
		String[] yearBox = new String[100];
		
		for(int i=0,years=2013;i<100;i++){
			
			yearBox[i]=""+years;
			years--;
		}
//		System.out.println(yearBox[2]);
		this.year=new JComboBox(yearBox);
		c.insets= new Insets(0,130,20,0);
		c.gridx=2;
		c.gridy=2;
		c.gridwidth=1;
		picLabel.add(year,c);
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
		this.stateL = new JLabel("State:");
		stateL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridy=6;
		c.gridx=0;
		picLabel.add(stateL,c);
		this.stateT = new JTextField(15);
		stateT.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridy=6;
		c.gridx=2;
		picLabel.add(stateT,c);
		this.zipL = new JLabel("Zip Code:");
		zipL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridy=7;
		c.gridx=0;
		picLabel.add(zipL,c);
		this.zipT = new JTextField(15);
		zipT.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridy=7;
		c.gridx=2;
		picLabel.add(zipT,c);
		
		this.cityL = new JLabel("City:");
		cityL.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridy=8;
		c.gridx=0;
		picLabel.add(cityL,c);
		
		this.cityT = new JTextField(15);
		cityT.setFont(new Font("Comic Sans",Font.BOLD, 15));
		c.gridy=8;
		c.gridx=2;
		picLabel.add(cityT,c);
				 
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
    public JTextField getZip(){
    	return zipT;
    }
    public JTextField getCity(){
    	return cityT;
    }
    public JTextField getState(){
    	return stateT;
    }
	public JTextField getfName() {
		return fName;
	}

	public JTextField getlName() {
		return lName;
	}

	/*public JTextField getDoB() {
		return DoB;
	}*/

	public JTextField getDoctor() {
		return doctor;
	}

	public JTextField getPhone() {
		return phone;
	}@SuppressWarnings("rawtypes")
	public JComboBox getYear(){
		return year;
	}@SuppressWarnings("rawtypes")
	public JComboBox getMonth(){
		return month;
	}@SuppressWarnings("rawtypes")
	public JComboBox getDay(){
		return day;
	}
	public String getDob(){
		String year= getYear().getSelectedItem().toString();
		//System.out.println(year);
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

	public JTextField getAddress() {
		return address;
	}

	public JButton getCancel() {
		return cancel;
	}

	public JButton getSubmit() {
		return submit;
	}
	public JLabel getWarning(){
		return warning;
	}
	
}
