package phms_se.gui;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;


@SuppressWarnings("serial")
public class RestockPage extends JPanel {
	private JTextField drugNameT;
	private JTextField quantityT;
	private JLabel drugNameLabel;
	private JLabel quantityLabel;
	private JButton restock;
	private JButton cancel;
	public RestockPage(Gui frame) {
		GridBagConstraints c = new GridBagConstraints();
		JLabel picLabel=new JLabel();
        picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phms_se/resources/img/bg.jpg")));
		   this.add(picLabel);
		   picLabel.setLayout(new GridBagLayout());
			this.setLayout(new GridBagLayout());
			this.drugNameLabel= new JLabel("Drug Name:");
			drugNameLabel.setFont(new Font("Comic Sans",Font.BOLD, 15));
			c.insets= new Insets(5,15,0,0);
			picLabel.add(drugNameLabel,c);
			this.drugNameT=new JTextField(15);
			c.gridx=1;
			drugNameT.setFont(new Font("Comic Sans",Font.BOLD, 15));
			picLabel.add(drugNameT,c);
			this.quantityLabel=new JLabel("Quantity:");
			c.gridx=0;
			c.gridy=1;
			quantityLabel.setFont(new Font("Comic Sans",Font.BOLD, 15));
			picLabel.add(quantityLabel, c);
			this.quantityT=new JTextField(15);
			c.gridx=1;
			c.gridy=1;
			quantityT.setFont(new Font("Comic Sans",Font.BOLD, 15));
			picLabel.add(quantityT,c);
			this.restock=new JButton("Restock");
			c.insets= new Insets(20,15,0,0);
			c.gridx=0;
			c.gridy=2;
			c.gridwidth=1;
			restock.setPreferredSize(new Dimension(155, 35));
			picLabel.add(restock,c);
			this.cancel=new JButton("Cancel");
			cancel.addActionListener(frame);
			c.gridx=1;
			c.gridy=2;
			c.gridwidth=1;
			c.insets= new Insets(20,30,0,0);
			cancel.setPreferredSize(new Dimension(155, 35));
			picLabel.add(cancel,c);
			
	}
	JButton getCancelButton(){
		return this.cancel;
	}

}
