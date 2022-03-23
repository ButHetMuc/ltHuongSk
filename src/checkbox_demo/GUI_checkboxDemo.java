package checkbox_demo;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_checkboxDemo extends JFrame {
	
	private JTextField txtText;
	private JCheckBox chkBold;
	private JCheckBox chkItalic;

	public GUI_checkboxDemo() {
		setTitle("JCheckbox demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setSize(300,200);
		setLocationRelativeTo(null);
		
		Box boxCenter = Box.createVerticalBox();
		
		JPanel pnText = new JPanel();
		txtText = new JTextField(15);
		txtText.setText("What is your name?");
		
		pnText.add(txtText);
		boxCenter.add(pnText);
		
		JPanel pnChk = new JPanel();
		chkBold = new JCheckBox("Bold");
		chkItalic = new JCheckBox("Italic");
		pnChk.setAlignmentX(CENTER_ALIGNMENT);
		pnChk.add(chkBold);
		pnChk.add(chkItalic);
		
		boxCenter.add(pnChk);
		this.add(boxCenter);
		
		AddEvents();
		
	}

	private void AddEvents() {
		chkBold.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Font f = txtText.getFont();
				txtText.setFont(new Font(f.getName(), f.getStyle() ^ Font.BOLD, f.getSize()));
			}
		});
		chkItalic.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Font f = txtText.getFont();
				txtText.setFont(new Font(f.getName(), f.getStyle()^ Font.ITALIC, f.getSize()));
			}
		});
	}
	
}
