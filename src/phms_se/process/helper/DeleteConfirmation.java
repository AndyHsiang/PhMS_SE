package phms_se.process.helper;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import phms_se.gui.ManageEmployeePage;
import phms_se.gui.PatientProfilePage;

public class DeleteConfirmation {
	private static JPanel MyPanel;
	private static JTextField prescID;
	private static JLabel prescIDL;
	public static boolean Confirm(ManageEmployeePage manEmp) {
		String name = manEmp.getNameText().getText();
	int n = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you would like to delete " + name,
            "Confirmation",
            JOptionPane.YES_NO_OPTION);
	 if (n == JOptionPane.YES_OPTION) {
         return true;
       }
       else {
          return false;
       }
}

	public static boolean Confirm(PatientProfilePage pProfileP) {
		prescIDL=new JLabel("Prescription ID");
        prescID = new JTextField(10);
        MyPanel = new JPanel();
        MyPanel.add(prescIDL);
        MyPanel.add(prescID);
        
	int n = JOptionPane.showConfirmDialog(
            null,MyPanel,
            "Remove Prescription", JOptionPane.YES_NO_OPTION);
	 if (n == JOptionPane.YES_OPTION) {
         return true;
       }
       else {
          return false;
       }
}
	public static JTextField getPrescriptionID(){
		return prescID;
	}
}