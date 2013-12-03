package phms_se.gui;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//NEW SCHEDULE JPANE
public class newSchedule {
	private static JLabel startL;
	private static JLabel endL;
	private static JLabel wageL;
	private static JLabel vacationL;
	private static JTextField vacation;
	private static JTextField start;
	private static JTextField end;
	private static JTextField wage;
	
	@SuppressWarnings("deprecation")
	public static boolean addNewSchedule() {
		
		start=new JTextField(10);
		end=new JTextField(10);
		wage=new JTextField(10);
		vacation= new JTextField(10);
		startL=new JLabel("Start Time:");
		endL=new JLabel("End Time:");
		vacationL=new JLabel("Vacation days:");
		wageL=new JLabel("Wage:");

	    JPanel myPanel = new JPanel();
	    myPanel.add(startL);
	    myPanel.add(start);
	    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	    myPanel.add(endL);
	    myPanel.add(end);
	    myPanel.add(Box.createHorizontalStrut(15));
	    myPanel.add(wageL);
	    myPanel.add(wage);
	    myPanel.add(Box.createHorizontalStrut(15));
	    myPanel.add(vacationL);
	    myPanel.add(vacation);

	    int result = JOptionPane.showConfirmDialog(null, myPanel, 
	               "Add new Schedule", JOptionPane.OK_CANCEL_OPTION);
	    if (result == JOptionPane.OK_OPTION && !start.getText().equals("")&&!end.getText().equals("")&&!wage.getText().equals("")&&!vacation.getText().equals("")) {
	       return true;
	    }else
	    	return false;
	}

	public static JTextField getStart() {
		return start;
	}

	public static JTextField getEnd() {
		return end;
	}
	public static JTextField getWage() {
		return wage;
	}
	public static JTextField getVacation() {
		return vacation;
	}
	
}
