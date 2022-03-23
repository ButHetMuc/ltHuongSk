package rd_chkDemo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class CheckBoxRadioDemo extends JFrame {
	private JCheckBox chkItalic;
	private JRadioButton radRight;
	private JRadioButton radLeft;
	private JLabel lblHello;
	

	public CheckBoxRadioDemo() {
		setTitle("checkbox radio");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Box boxCenter = Box.createVerticalBox();
		//Box boxc = new Box(BoxLayout.X_AXIS);
		JPanel pnItems = new JPanel();
		boxCenter.add(pnItems);
		
		chkItalic = new JCheckBox("Italic");
		pnItems.add(chkItalic);
		
		radLeft = new JRadioButton("Left");
		radRight = new JRadioButton("Right");
		
		ButtonGroup grRadio = new ButtonGroup();
		grRadio.add(radLeft);
		grRadio.add(radRight);
		pnItems.add(radLeft);
		pnItems.add(radRight);
		
		//pnTextAlign = new JPanel();
		lblHello = new JLabel("Hello World");
		//pnTextAlign.add(lblHello);
		
		//boxCenter.add(pnTextAlign);
		//boxCenter.add(lblHello);
		this.add(lblHello, BorderLayout.SOUTH);
		this.add(boxCenter);
		
		AddEvents();
		
	}

	private void AddEvents() {
		chkItalic.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				Font f = lblHello.getFont();
				lblHello.setFont(
						new Font(f.getName(), f.getStyle() ^ Font.ITALIC, f.getSize()));;
			}
		});
		
		radLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("abc");
				lblHello.setHorizontalAlignment(JLabel.LEFT);
			}
		});
		radRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lblHello.setHorizontalAlignment(JLabel.RIGHT);
			}
		});
	}
}
