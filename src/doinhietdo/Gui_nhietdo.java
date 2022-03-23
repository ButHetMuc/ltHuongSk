package doinhietdo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Gui_nhietdo extends JFrame {
	private JTextField txtDof;
	private JLabel lblDoC;

	public Gui_nhietdo() {
		setTitle("Doi do F sang do C");
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pnTop  = new JPanel();
		JLabel lblDoF = new JLabel("Nhap do F: ");
		txtDof = new JTextField(5);
		pnTop.add(lblDoF);
		pnTop.add(txtDof);
		
		add(pnTop,BorderLayout.NORTH);
		
		//JPanel pnBot = new JPanel();
		lblDoC = new JLabel("do C: ");
		lblDoC.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDoC,BorderLayout.SOUTH);
		
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		txtDof.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				// TODO Auto-generated method stub
				int doC,doF;
				
				try {
					doF = Integer.parseInt(txtDof.getText());
					doC = (doF - 32 )* 5/9;
					lblDoC.setText("do C: " + doC);
				}catch(NumberFormatException nex)	{
					nex.printStackTrace();
					JOptionPane.showMessageDialog(
							null, "nhap sai roi ban oi", "sai roi", JOptionPane.OK_OPTION);
					lblDoC.setText("");
					return;
				}
			}
		});
	}
}
