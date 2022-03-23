package jcomboboxDemo;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JcomboBoxDemo extends JFrame {
	
	private JLabel lblText;
	private JComboBox cboSelect;

	public JcomboBoxDemo() {
		setTitle("JcomboBox demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		  lblText = new JLabel("co 1 con cho dang gam cuc xuong");
		  lblText.setFont(new Font("serif", Font.PLAIN, 14));
		  add(lblText, BorderLayout.CENTER);
		  
		  
		  Object[] type =  {"Serif","SansSerif","Monospaced"};
		  cboSelect = new JComboBox(type);
		  add(cboSelect,BorderLayout.SOUTH);
		  AddEvents();
		  
	}

	private void AddEvents() {
		// TODO Auto-generated method stub
		cboSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String fName =(String)cboSelect.getSelectedItem();
				lblText.setFont(new Font(fName, lblText.getFont().getStyle(),lblText.getFont().getSize()));
			}
		});
		
	}

}
