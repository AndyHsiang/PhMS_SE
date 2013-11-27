package phms_se.gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
@SuppressWarnings("serial")
public class DrugInventoryPage extends JPanel {
	private JLabel enterNameL;
	private JLabel LIWarning;
	private JTextField enterNameT;
	private JButton addNew;
	private JButton restock;
	private JButton remove;
	private JButton search;
	private JButton back;
	private JTable table;
	private JTable lowInventory;
	@SuppressWarnings("unused")
	private JLabel warning;
	private JTextArea general;
	private JTextArea effects;
	private JScrollPane i;
	private JScrollPane j;
	private JLabel generalL;
	private JLabel effectsL;
	DrugInventoryPage(Gui frame){
		
		GridBagConstraints c = new GridBagConstraints();
		JLabel picLabel=new JLabel();
        picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phms_se/resources/img/bg.jpg")));
		   this.add(picLabel);
		   picLabel.setLayout(new GridBagLayout());
			this.setLayout(new GridBagLayout());
			
			this.enterNameL = new JLabel ("Drug Name:");
			 enterNameL.setFont(new Font("Comic Sans",Font.BOLD, 15));
			 c.insets= new Insets(0,0,10,0);
			 c.gridx=0;
			 c.gridy=0;
			 c.gridwidth=4;
			 picLabel.add(enterNameL,c);
			 this.enterNameT= new JTextField(15);
			 c.insets= new Insets(0,0,25,0);
			 enterNameT.setFont(new Font("Comic Sans",Font.BOLD, 15));
			 c.gridx=0;
			 c.gridy=1;
			 c.gridwidth=4;
			 picLabel.add(enterNameT,c);
			 this.search = new JButton ("Search");
			 search.setPreferredSize(new Dimension(100, 20));
			 c.insets= new Insets(0,0,25,0);
			 c.gridx=3;
			 c.gridy=1;
			 c.gridwidth=4;
			 picLabel.add(search,c);
			 search.addActionListener(frame);
			
			 
			 String[] columnNames={"Drug Name", "Quantity", "Controlled Flag", "Price" };
				Object[][] data={{"Drug Name","Quantity","Controlled Flag","Price"},{0,0,0,0}};
				table = new JTable(data, columnNames);
				table.setPreferredSize(new Dimension(650,100 ));
				table.setRowHeight(50);
				c.insets= new Insets(0,0,20,0);
				c.gridx=0;
				c.gridy=2;
				c.gridwidth=4;
				picLabel.add(table,c);
				 table.setGridColor(Color.black);
				 table.setBackground(Color.decode("#CCEEEE"));
				 Border border = BorderFactory.createLineBorder(Color.black);
				 table.setBorder(border);
				 /*table.addMouseListener(new MouseAdapter(){
					 private void MouseClicked(final MouseEvent e){
						 if (e.getClickCount() != 0)
						 {
							
						 }
					 }
				 } */
				 
				
				 this.addNew = new JButton ("Add New");
				 addNew.addActionListener(frame);
				 addNew.setPreferredSize(new Dimension(120, 40));
				 c.insets= new Insets(10,10,15,0);
				 c.gridx=0;
				 c.gridy=5;
				 c.gridwidth=1;
				 picLabel.add(addNew,c);
				 
				 this.restock = new JButton ("Restock");
				 restock.addActionListener(frame);
				 restock.setPreferredSize(new Dimension(120, 40));
				 c.insets= new Insets(10,50,15,0);
				 c.gridx=1;
				 c.gridy=5;
				 c.gridwidth=1;
				 picLabel.add(restock,c);
				 
				 
				 this.remove = new JButton ("Remove");
				  remove.setPreferredSize(new Dimension(120, 40));
				 c.insets= new Insets(10,10,15,0);
				 c.gridx=0;
				 c.gridy=6;
				 c.gridwidth=1;
				 picLabel.add(remove,c);
				 
				 this.back = new JButton ("Back");
				  back.setPreferredSize(new Dimension(120, 40));
				 c.insets= new Insets(10,50,15,0);
				 c.gridx=1;
				 c.gridy=6;
				 c.gridwidth=1;
				 picLabel.add(back,c);
				 back.addActionListener(frame);
				 
				this.LIWarning = new JLabel ("<html>Low Inventory" + "<br>" +"   " +"Warning</html>");
				LIWarning.setFont(new Font("Comic Sans",Font.BOLD, 20));
					c.insets= new Insets(0,0,0,0);
					c.gridx=3;
					c.gridy=3;
					c.gridwidth=1;
					picLabel.add(LIWarning,c);
					
				 String[] dcolumnName={"Low Inventory Warning" };
				 Object[][] ddata={{""},{""},{""},{""},{""},{""},{""},{""}};
				 lowInventory = new JTable(ddata, dcolumnName);
				 lowInventory.setRowHeight(25);
				 lowInventory.setPreferredSize(new Dimension(200,200 ));
				 c.insets= new Insets(0,0,0,0);
				 c.gridx=3;
				 c.gridy=4;
				 c.gridheight=7;
				 picLabel.add(lowInventory,c);
				 lowInventory.setGridColor(Color.black);
				 lowInventory.setBackground(Color.decode("#CCEEEE"));
				 Border border1 = BorderFactory.createLineBorder(Color.black);
				 lowInventory.setBorder(border1);
				 
				 this.general= new JTextArea();
				 general.setColumns(15);
				 general.setRows(20);
				 general.setLineWrap(true);
				 i = new JScrollPane(general);
				 i.setPreferredSize(new Dimension(200, 100));
				 general.setWrapStyleWord(true);
				 general.setPreferredSize(new Dimension(170, 120));
				 c.insets = new Insets(0,0,0,0);
				 c.gridx=0;
				 c.gridy=4;
				 c.gridheight=1;
				 picLabel.add(i,c);
				 
				 this.effects= new JTextArea();
				 effects.setColumns(15);
				 effects.setRows(20);
				 effects.setLineWrap(true);
				 j = new JScrollPane(effects);
				 j.setPreferredSize(new Dimension(200, 100));
				 effects.setWrapStyleWord(true);
				 effects.setPreferredSize(new Dimension(170, 120));
				 c.insets = new Insets(0,0,0,0);
				 c.gridx=1;
				 c.gridy=4;
				 picLabel.add(j,c);
				 
				 this.effectsL = new JLabel("Side Effects:");
				 effectsL.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.insets = new Insets(0,0,0,0);
				 c.gridx=1;
				 c.gridy=3;
				 picLabel.add(effectsL,c);
				 
				 this.generalL = new JLabel("General Info:");
				 generalL.setFont(new Font("Comic Sans",Font.BOLD, 15));
				 c.insets = new Insets(0,0,0,0);
				 c.gridx=0;
				 c.gridy=3;
				 picLabel.add(generalL,c);
				
				
	}
	JButton getAddButton() {
		return this.addNew;
   }
	JButton getRestockButton() {
		return this.restock;
   }
	JButton getBackButton(){
		return this.back;
	}
	JButton getSearch(){
		return this.search;
	}
	public JTextField getDName(){
		return this.enterNameT;
	}
	public JTable getTable(){
		return this.table;
	}
	public JTable getLowInventoryTable(){
		return this.lowInventory;
	}

	public void setDName(){
		this.enterNameT.setText("Not Found");
	}
public void setGeneralText(String general){
	this.general.setText(general);
	
}
public void setEffectsText(String effects){
	this.effects.setText(effects);
}
}
