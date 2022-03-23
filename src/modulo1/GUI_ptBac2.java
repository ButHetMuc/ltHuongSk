package modulo1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_ptBac2 extends JFrame {
	private JTextField txtNhapA;
	private JTextField txtNhapB;
	private JTextField txtNhapC;
	private JTextField txtKq;
	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;

	public GUI_ptBac2() {
		setTitle("but pro 123 567 ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,300);
		setLocationRelativeTo(null);
		
		JLabel lblTitle = new JLabel("GIAI PHUONG TRINH BAC 2");
		lblTitle.setFont(new Font(null, Font.BOLD, 15));
		JPanel pnTitle = new JPanel();
		pnTitle.setBackground(Color.PINK);
		pnTitle.add(lblTitle);
		this.add(pnTitle,BorderLayout.NORTH);
		
		Box boxCenter = Box.createVerticalBox();
		
		JPanel pnA = new JPanel();
		JLabel lblnhapA = new JLabel("nhap a:");
		pnA.add(lblnhapA);
		txtNhapA = new JTextField(15);
		pnA.add(txtNhapA);
		boxCenter.add(pnA);
		
		JLabel lblnhapB = new JLabel("nhap b:");
		JPanel pnB = new JPanel();
		pnB.add(lblnhapB);
		txtNhapB = new JTextField(15);
		pnB.add(txtNhapB);
		boxCenter.add(pnB);
		
		JLabel lblnhapC = new JLabel("nhap c:");
		JPanel pnC = new JPanel();
		pnC.add(lblnhapC);
		txtNhapC = new JTextField(15);
		pnC.add(txtNhapC);
		boxCenter.add(pnC);
		
		JLabel lblKetqua = new JLabel("nhap a:");
		JPanel pnKetQua = new JPanel();
		pnKetQua.add(lblKetqua);
		txtKq = new JTextField(15);
		txtKq.disable();
		pnKetQua.add(txtKq);
		boxCenter.add(pnKetQua);
		this.add(boxCenter,BorderLayout.CENTER);
		
		JPanel pnSouth = new JPanel();
		btnGiai = new JButton("Giai luon");
		btnGiai.setBackground(Color.WHITE);
		pnSouth.add(btnGiai);
		
		btnXoa = new JButton("xoa rong nha");
		btnXoa.setBackground(Color.WHITE);
		pnSouth.add(btnXoa);
		
		btnThoat = new JButton("Thoat luon");
		btnThoat.setBackground(Color.WHITE);
		pnSouth.add(btnThoat);
		
		pnSouth.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.BLACK),"chon tac vu" ));
		
		this.add(pnSouth,BorderLayout.SOUTH);
		
		addEvents();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int kq = JOptionPane.showConfirmDialog(null, "chac khong",
						"xac nhan thoat",JOptionPane.YES_NO_OPTION);
				if(kq == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtNhapA.setText("");
				txtNhapB.setText("");
				txtNhapC.setText("");
				txtKq.setText("");
			}
		});
		btnGiai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) throws NumberFormatException  {
				// TODO Auto-generated method stub
				int soA, soB, soC;
				if(txtNhapA.getText().equals("")|| txtNhapB.getText().equals("")|| txtNhapC.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "chua nhap du du lieu");
					return;
				}
					
				try {
					soA = Integer.parseInt(txtNhapA.getText());
					soB = Integer.parseInt(txtNhapB.getText());
					soC = Integer.parseInt(txtNhapC.getText());
					if(soA == 0) {
						JOptionPane.showMessageDialog(
								null, "A phai khac 0", "sai roi",JOptionPane.OK_OPTION);
						return;
					}
					int delta = soB*soB - (4*(soA*soC));
					System.out.println(delta);
					if(delta < 0) {
			
						txtKq.setText("Phuong trinh vo nghiem");
						return;
					}
					else if(delta == 0) {
						String nghiemX = ("-"+ String.valueOf(soB)+ "/" + String.valueOf(2*soA));
						txtKq.setText("Phuong trinh co nghiem kep x1 = x2 = "+nghiemX);
						return;
					}
					else {
						String nghiemX1 = ("-"+ String.valueOf(soB - Math.sqrt(delta))+ "/" + String.valueOf(2*soA));
						String nghiemX2 = ("-"+ String.valueOf(soB + Math.sqrt(delta))+ "/" + String.valueOf(2*soA));
						txtKq.setText("x1= "+ nghiemX1 + "   x2= " +nghiemX2);
						return;
					}
					
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(
							null, "hong duoc nhap chu", "sai roi", JOptionPane.OK_OPTION);
				}
				
			}
		});
	}
}
