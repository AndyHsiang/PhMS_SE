package phms_se.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//SYSTEMS PAGE
@SuppressWarnings("serial")
public class SystemsPage extends JPanel {

private JButton back;
private JButton systemExit;
private JButton logout;
SystemsPage(Gui frame){

GridBagConstraints c = new GridBagConstraints();
JLabel picLabel=new JLabel();
picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phms_se/resources/img/bg.jpg")));
   this.add(picLabel);
   picLabel.setLayout(new GridBagLayout());
this.setLayout(new GridBagLayout());
this.back=new JButton("Back");
back.addActionListener(frame);
c.insets= new Insets(0,0,0,40);
c.gridx=0;
c.gridy=0;
c.gridwidth=1;
back.setPreferredSize(new Dimension(150, 80));

picLabel.add(back,c);
this.systemExit=new JButton("System Exit");
systemExit.addActionListener(frame);
c.insets= new Insets(0,0,0,0);
c.gridx=1;
c.gridy=0;
c.gridwidth=1;
systemExit.setPreferredSize(new Dimension(150, 80));
picLabel.add(systemExit,c);
this.logout=new JButton("Logout");
c.insets= new Insets(0,40,0,0);
c.gridx=2;
c.gridy=0;
c.gridwidth=1;
logout.setPreferredSize(new Dimension(150, 80));
picLabel.add(logout,c);
logout.addActionListener(frame);

}
JButton getBackButton() {
		return this.back;
}
JButton getSystemExitButton(){
	   return this.systemExit;
}
public JButton getLogout() {
	return logout;
}
}
