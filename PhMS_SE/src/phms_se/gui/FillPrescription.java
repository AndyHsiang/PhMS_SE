package phms_se.gui;
import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")
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
	private JButton cancel;
	private JButton submit;
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

				 this.fillDateTL = new JLabel ("Fill Date:");
				 fillDateTL.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.insets= new Insets(0,0,20,0);
				 c.gridx=0;
				 c.gridy=4;
				 c.gridwidth=1;
				 picLabel.add(fillDateTL,c);
				 this.fillDateT= new JTextField(15);
				 c.insets= new Insets(0,0,20,0);
				 fillDateT.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.gridx=2;
				 c.gridy=4;
				 c.gridwidth=1;
				 picLabel.add(fillDateT,c);
				 
				 this.expirationTL = new JLabel ("Expiration:");
				 expirationTL.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.insets= new Insets(0,0,20,0);
				 c.gridx=0;
				 c.gridy=5;
				 c.gridwidth=1;
				 picLabel.add(expirationTL,c);
				 this.expirationT= new JTextField(15);
				 c.insets= new Insets(0,0,20,0);
				 expirationT.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.gridx=2;
				 c.gridy=5;
				 c.gridwidth=1;
				 picLabel.add(expirationT,c);
				 
				 this.submit = new JButton ("Submit");
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
				 
			
	   
	}
	JButton getCancelButton(){
		return this.cancel;
	}
}
