package modulo2_bai2_jlist;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI_jlist extends JFrame {
	private JButton btnToDenSoChan;
	private JButton btnToDenSoNT;
	private JButton btnToDenSoLe;
	private JButton btnKhongToDen;
	private JButton btnXoaSoToDen;
	private JButton btnTinhTong;

	public GUI_jlist() {
		super("thao tac tren jlist");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,400);
		
		addControls();
		addEvents();
	}
	private void addControls() {
		// TODO Auto-generated method stub
		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
		pnBox.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.pink), "chon chuc nang"));
		
		btnToDenSoChan = new JButton("to den so chan");
		btnToDenSoLe = new JButton("to den so le");
		btnToDenSoNT = new JButton("to den so NT");
		btnKhongToDen = new JButton("bo to den");
		btnXoaSoToDen = new JButton("xoa so to den");
		btnTinhTong = new JButton("tinh tong");
		//pnBox.setAlignmentY(TOP_ALIGNMENT);
		
		pnBox.add(btnToDenSoChan);
		pnBox.add(btnToDenSoLe);
		pnBox.add(btnToDenSoNT);
		pnBox.add(btnKhongToDen);
		pnBox.add(btnXoaSoToDen);
		pnBox.add(btnTinhTong);
		
		btnToDenSoLe.setPreferredSize(new Dimension(btnToDenSoChan.getPreferredSize()));
		
		this.add(pnBox,BorderLayout.WEST);
		this.add(new JButton("sdfas"),BorderLayout.NORTH);
		this.add(new JButton("sdfas"),BorderLayout.CENTER);
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		
	}


}
