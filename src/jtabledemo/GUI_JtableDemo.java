package jtabledemo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class GUI_JtableDemo extends JFrame {
	private JTextField txtHo;
	private JTextField txtTen;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnThoat;
	private DefaultTableModel modelDS;
	private JTable tblDS;
	private JButton btnSua;

	public GUI_JtableDemo() {
		super("edit table");
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel pnTop = new JPanel();
		pnTop.setLayout(new BoxLayout(pnTop, BoxLayout.Y_AXIS));
		
		JPanel pnHo = new JPanel();
		JLabel lblHo = new JLabel("Ho:");
		txtHo = new JTextField(15);
		pnHo.add(lblHo);
		pnHo.add(txtHo);
		
		pnTop.add(pnHo);
		this.add(pnTop,BorderLayout.NORTH);
	
		JPanel pnTen = new JPanel();
		JLabel lblTen= new JLabel("Ten:");
		txtTen= new JTextField(15);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnTop.add(pnTen);
		
		JPanel pnChucNang = new JPanel();
		btnThem = new JButton("Them");
		btnXoa = new JButton("Xoa");
		btnThoat = new JButton("Thoat");
		btnSua= new JButton("Sua");
		
		pnChucNang.add(btnThem);
		pnChucNang.add(btnXoa);
		pnChucNang.add(btnThoat);
		pnChucNang.add(btnSua);
		
		pnTop.add(pnChucNang);
		
		String[] cols_dskh = {"Ho","Ten"};
		modelDS = new DefaultTableModel(cols_dskh, 0);
		tblDS = new JTable(modelDS);
		JScrollPane scrTableDS = new JScrollPane(tblDS);
		scrTableDS.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrTableDS.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(scrTableDS,BorderLayout.CENTER);
		
		addEvents();
		
	}

	private void addEvents() {
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "chac khong","xac nhan", JOptionPane.OK_CANCEL_OPTION);
				if(i == JOptionPane.OK_OPTION) {
					System.exit(0);
					return;
				}
			}
		});
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ho = txtHo.getText();
				String ten = txtTen.getText();
				
				if(ho.equals("") || ten.equals("")) {
					JOptionPane.showMessageDialog(null, "thieu thong tin");
					return;
				}
				
				Object[] row = {ho,ten};
				modelDS.addRow(row);
				
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tblDS.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "chua chon dong de xoa");
					return;
				}
				int i = JOptionPane.showConfirmDialog(
						null, "chac khong","xac nhan", JOptionPane.YES_NO_OPTION);
				
			}
		});
		tblDS.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//String ho = tblDS.getco
				
			}
		});
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUI_JtableDemo guiEditTable = new GUI_JtableDemo();
		guiEditTable.setVisible(true);
	}
	
}
