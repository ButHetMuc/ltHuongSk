package modulo1_bai2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI_SoNguyenTo extends JFrame {
	
	private JTextField txtNhapSo;
	private JButton btnGenerate;
	private JTextArea areaBot;

	public GUI_SoNguyenTo () {
		setTitle("Primes");
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Box boxCenter = Box.createVerticalBox();
		
		JPanel pnTop = new JPanel();
		
		txtNhapSo = new JTextField();
		txtNhapSo.setPreferredSize(new Dimension(150, 27));
		btnGenerate = new JButton("Generate");	
		btnGenerate.setBackground(Color.WHITE);
		pnTop.add(txtNhapSo);
		pnTop.add(btnGenerate);
		
		boxCenter.add(pnTop);
		
		areaBot = new JTextArea(10, 10);
		areaBot.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		boxCenter.add(areaBot);
		
		this.add(boxCenter);
		
		AddEvents();
	}

	private void AddEvents() {
		// TODO Auto-generated method stub
		btnGenerate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) throws NumberFormatException {
				// TODO Auto-generated method stub
				int n;
				try {
					n = Integer.parseInt(txtNhapSo.getText());
					System.out.println(n);
					int k =2, i= 0;
					String strSNT = "";
					while(i<n) {
						while(KtSoNt(k)) {	
							strSNT += k+"\n";
							System.out.println(k);
							k++;
							i++;
						}
						k++;
					}
					areaBot.setText(strSNT);
				}catch (NumberFormatException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(
							null, "phai nhap so nguyen nha", "sai roi",JOptionPane.YES_OPTION);
					return;
				}
			}
		});
	}
	public boolean KtSoNt(int n) {
		if(n == 2 || n == 3)
			return true;
		for(int i= 2; i<= n/2;i++) {
			if(n%i ==0)
				return false;
		}
		return true;
	}
}
