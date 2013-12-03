package phms_se.process.helper;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//CREDENTIALS CHECKER
public class Credentials {
	private static JTextField user;
	private static JPasswordField pass;
	
	@SuppressWarnings("deprecation")
	public static boolean UserInputs() {
		
		user = new JTextField(15);
	    pass = new JPasswordField(15);

	    JPanel myPanel = new JPanel();
	    myPanel.add(new JLabel("Username:"));
	    myPanel.add(user);
	    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	    myPanel.add(new JLabel("Password:"));
	    myPanel.add(pass);

	    int result = JOptionPane.showConfirmDialog(null, myPanel, 
	               "Restricted Access: credential verification", JOptionPane.OK_CANCEL_OPTION);
	    if (result == JOptionPane.OK_OPTION && !user.getText().equals("")&&pass.getText()!=null) {
	       return true;
	    }else
	    	return false;
	}

	public static JTextField getUser() {
		return user;
	}

	public static JTextField getPass() {
		return pass;
	}
}
