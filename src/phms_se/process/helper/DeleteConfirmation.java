package phms_se.process.helper;

import javax.swing.JOptionPane;

import phms_se.gui.ManageEmployeePage;

public class DeleteConfirmation {
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
}}
