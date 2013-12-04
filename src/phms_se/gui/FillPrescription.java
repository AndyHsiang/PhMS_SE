package phms_se.gui;
import java.awt.*;

import javax.swing.*;
@SuppressWarnings("serial")
//FILL PRESCRIPTION PAGE
public class FillPrescription extends JPanel {
	private JTextField dNameT;
	private JTextField prescriberT;
	private JTextField quantityT;
	private JTextField refillCountT;
	private JTextField fillDateT;
	private JTextField expirationT;
	private JLabel dNameL;
	private JLabel prescriberL;
	private JLabel quantityTL;
	private JLabel refillCountTL;
	private JLabel fillDateTL;
	private JLabel expirationTL;
	private JLabel warning;
	private JButton cancel;
	private JButton submit;
	@SuppressWarnings("rawtypes")
	private JComboBox fillday;
	@SuppressWarnings("rawtypes")
	private JComboBox fillmonth;
	@SuppressWarnings("rawtypes")
	private JComboBox fillyear;
	@SuppressWarnings("rawtypes")
	private JComboBox day;
	@SuppressWarnings("rawtypes")
	private JComboBox month;
	@SuppressWarnings("rawtypes")
	private JComboBox year;
	FillPrescription(Gui frame){
		
		GridBagConstraints c = new GridBagConstraints();
		JLabel picLabel=new JLabel();
        picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phms_se/resources/img/bg.jpg")));
		   this.add(picLabel);
		   picLabel.setLayout(new GridBagLayout());
			this.setLayout(new GridBagLayout());
			
			this.dNameL = new JLabel ("Drug Name:");
			 dNameL.setFont(new Font("Comic Sans",Font.BOLD, 15));
			 c.insets= new Insets(0,0,20,0);
			 c.gridx=0;
			 c.gridy=0;
			 c.gridwidth=1;
			 picLabel.add(dNameL,c);
			 this.dNameT= new JTextField(15);
			 c.insets= new Insets(0,0,20,0);
			 dNameT.setFont(new Font("Comic Sans",Font.BOLD, 15));
			 c.gridx=2;
			 c.gridy=0;
			 c.gridwidth=1;
			 picLabel.add(dNameT,c);
				 this.prescriberL = new JLabel ("Prescriber");
				 prescriberL.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.insets= new Insets(0,0,20,0);
				 c.gridx=0;
				 c.gridy=1;
				 c.gridwidth=1;
				 picLabel.add(prescriberL,c);
				 this.prescriberT= new JTextField(15);
				 c.insets= new Insets(0,0,20,0);
				 prescriberT.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.gridx=2;
				 c.gridy=1;
				 c.gridwidth=1;
				 picLabel.add(prescriberT,c);
				 this.quantityTL = new JLabel ("Quantity:");
				 quantityTL.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.insets= new Insets(0,0,20,0);
				 c.gridx=0;
				 c.gridy=2;
				 c.gridwidth=1;
				 picLabel.add(quantityTL,c);
				 this.quantityT= new JTextField(15);
				 c.insets= new Insets(0,0,20,0);
				 quantityT.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.gridx=2;
				 c.gridy=2;
				 c.gridwidth=1;
				 picLabel.add(quantityT,c);
				 this.refillCountTL = new JLabel ("Refill Count:");
				 refillCountTL.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.insets= new Insets(0,0,20,0);
				 c.gridx=0;
				 c.gridy=3;
				 c.gridwidth=1;
				 picLabel.add(refillCountTL,c);
				 this.refillCountT= new JTextField(15);
				 c.insets= new Insets(0,0,20,0);
				 refillCountT.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.gridx=2;
				 c.gridy=3;
				 c.gridwidth=1;
				 picLabel.add(refillCountT,c);
				 
				 
				 
				 
				 
				 
				 String[] monthBox = {"January","February","March","April","May","June","July","August","September","October","November","December"};
					this.fillmonth=new JComboBox(monthBox);
					c.insets= new Insets(0,0,20,100);
					c.gridx=2;
					c.gridy=4;
					c.gridwidth=1;
					picLabel.add(fillmonth,c);
					String[] dayBox={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
					this.fillday=new JComboBox(dayBox);
					c.insets= new Insets(0,35,20,0);
					c.gridx=2;
					c.gridy=4;
					c.gridwidth=1;
					picLabel.add(fillday,c);
					String[] yearBox = new String[100];
					
					for(int i=0,years=2013;i<100;i++){
						
						yearBox[i]=""+years;
						years--;
					}
	String[] ExpyearBox = new String[100];
					
					for(int i=0,years=2013;i<12;i++){
						
						ExpyearBox[i]=""+years;
						years++;
					}

					this.fillyear=new JComboBox(yearBox);
					c.insets= new Insets(0,130,20,0);
					c.gridx=2;
					c.gridy=4;
					c.gridwidth=1;
					picLabel.add(fillyear,c);
				 
				 
				 

				 this.fillDateTL = new JLabel ("Fill Date:");
				 fillDateTL.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.insets= new Insets(0,0,20,0);
				 c.gridx=0;
				 c.gridy=4;
				 c.gridwidth=1;
				 picLabel.add(fillDateTL,c);
				
				 
				 this.expirationTL = new JLabel ("Expiration:");
				 expirationTL.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.insets= new Insets(0,0,20,0);
				 c.gridx=0;
				 c.gridy=5;
				 c.gridwidth=1;
				 picLabel.add(expirationTL,c);
					this.month=new JComboBox(monthBox);
					c.insets= new Insets(0,0,20,100);
					c.gridx=2;
					c.gridy=5;
					c.gridwidth=1;
					picLabel.add(month,c);
					this.day=new JComboBox(dayBox);
					c.insets= new Insets(0,35,20,0);
					c.gridx=2;
					c.gridy=5;
					c.gridwidth=1;
					picLabel.add(day,c);
				

					this.year=new JComboBox(ExpyearBox);
					c.insets= new Insets(0,130,20,0);
					c.gridx=2;
					c.gridy=5;
					c.gridwidth=1;
					picLabel.add(year,c);
				 
				 
				 this.submit = new JButton ("Submit");
				 submit.addActionListener(frame);
				  submit.setPreferredSize(new Dimension(100, 40));

				 c.insets= new Insets(0,0,0,0);
				 c.gridx=0;
				 c.gridy=6;
				 picLabel.add(submit,c);
				 
				 this.cancel = new JButton ("Cancel");
				 cancel.addActionListener(frame);
				  cancel.setPreferredSize(new Dimension(100, 40));

				 c.insets= new Insets(0,0,0,0);
				 c.gridx=2;
				 c.gridy=6;
				 picLabel.add(cancel,c);
				 this.warning= new JLabel("");
				 warning.setForeground(Color.red);
				 c.gridx=0;
				 c.gridy=7;
				 c.gridwidth=3;
				 picLabel.add(warning,c);
	}
	JButton getCancelButton(){
		return this.cancel;
	}
	public JTextField getDrugName(){
		
		return this.dNameT;
	}
	public JTextField getPrescriber(){
		return this.prescriberT;
	}
	public JTextField getQuantity(){
		return this.quantityT;
	}
	public JTextField getRefillCount(){
		return this.refillCountT;
	}
	
	
	public JButton getSubmit(){
		return this.submit;
	}
	public JLabel getWarning(){
		return warning;
	}
	public String getFillDate(){
		String year= getFillYear().getSelectedItem().toString();
		//System.out.println(year);
		String month=getFillMonth().getSelectedItem().toString();
		String day=getFillDay().getSelectedItem().toString();
		
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
	public String getExpiration(){
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
@SuppressWarnings("rawtypes")
public JComboBox getYear(){
	return year;
}@SuppressWarnings("rawtypes")
public JComboBox getMonth(){
	return month;
}@SuppressWarnings("rawtypes")
public JComboBox getDay(){
	return day;
}
@SuppressWarnings("rawtypes")
public JComboBox getFillYear(){
	return fillyear;
}@SuppressWarnings("rawtypes")
public JComboBox getFillMonth(){
	return fillmonth;
}@SuppressWarnings("rawtypes")
public JComboBox getFillDay(){
	return fillday;
}
}
