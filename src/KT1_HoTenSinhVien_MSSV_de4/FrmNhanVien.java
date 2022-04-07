package KT1_HoTenSinhVien_MSSV_de4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;



public class FrmNhanVien extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtHeSoLuong;
	private JTextField txtEmail;
	
	private JButton btnThem;
	private JTable table;
	private JButton btnXoaRong;


	private DefaultTableModel tableModel;
	private JLabel lblEmail;

	public FrmNhanVien() {
		setTitle("Kiểm tra biểu thức chính quy");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
	}

	private void buildUI() {

		// Phần North
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 180));
		pnlNorth.setBorder(BorderFactory.createTitledBorder("Thông tin"));
		pnlNorth.setLayout(null); // Absolute layout

		JLabel lblMaNV, lblHoTen, lblDiaChi, lblTuoi, lblNhaXB;
		pnlNorth.add(lblMaNV = new JLabel("Mã Nhân Viên: "));
		pnlNorth.add(lblHoTen = new JLabel("Họ Tên: "));
		pnlNorth.add(lblDiaChi = new JLabel("địa chỉ: "));
		pnlNorth.add(lblTuoi = new JLabel("Hệ số lương: "));
		pnlNorth.add(lblEmail = new JLabel("Email: "));
		
		pnlNorth.add(txtMa = new JTextField());
		pnlNorth.add(txtTen = new JTextField());
		pnlNorth.add(txtDiaChi = new JTextField());
		pnlNorth.add(txtHeSoLuong = new JTextField());
		pnlNorth.add(txtEmail = new JTextField());
		

		int w1 = 100, w2 = 300, h = 20;
		lblMaNV.setBounds(20, 20, w1, h);
		txtMa.setBounds(120, 20, 200, h);

		lblHoTen.setBounds(20, 45, w1, h);
		txtTen.setBounds(120, 45, w2, h);
		lblDiaChi.setBounds(450, 45, w1, h);
		txtDiaChi.setBounds(570, 45, w2, h);

		lblTuoi.setBounds(20, 70, w1, h);
		txtHeSoLuong.setBounds(120, 70, w2, h);
		lblEmail.setBounds(450, 70, w1, h);
		txtEmail.setBounds(570, 70, w2, h);

		// Phần Center
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.add(btnThem = new JButton("Thêm - kiểm tra dữ liệu ..."));
		pnlCenter.add(btnXoaRong = new JButton("Xóa rỗng"));

		// Phần South
		JScrollPane scroll;
		String[] headers = "MaNhanVien;HoTenNV;HeSoLuong;DiaChi; Email".split(";");

		tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));
	
		btnThem.addActionListener(this);		
		btnXoaRong.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ma = txtMa.getText();
		String ten = txtTen.getText();
		String diaChi = txtDiaChi.getText();
		String hsLuong = txtHeSoLuong.getText();
		String email = txtEmail.getText();
		
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			if(kiemTraDuLieu()) {
				tableModel.addRow(new Object[] {ma,ten,diaChi,hsLuong,email});
			}
			
		}
		
		if(o.equals(btnXoaRong))
			clearTextfields();
	}

	

	private void clearTextfields() {
		txtMa.setText("");
		txtTen.setText("");
		txtDiaChi.setText("");
		txtHeSoLuong.setText("");
		txtEmail.setText("");
	
		txtMa.setEditable(true);
		txtMa.requestFocus();
	}
	
	private boolean kiemTraDuLieu() {
		String ma = txtMa.getText();
		String ten = txtTen.getText();
		String diaChi = txtDiaChi.getText();
		String hsLuong = txtHeSoLuong.getText();
		String email = txtEmail.getText();
		
		if(ma.equals("")) {
			JOptionPane.showMessageDialog(null, "ma khong duoc bo trong");
			
			txtMa.requestFocus();
			return false;
		}
		else {
			if(!ma.matches("^NV(BH||KT)\\d{3}")) {
				JOptionPane.showMessageDialog(null, "ma bat dau bang NV, theo sau là 2 ký tự cho biết loại nhân \r\n"
						+ "viên (BH-bán hàng; KT-kỷ thuật) và sau cùng là 3 ký số. ");
				txtMa.selectAll();
				txtMa.requestFocus();
				return false;
			}
		}
		
		if(ten.equals("")||!ten.matches("[a-zA-Z\\d]+( [a-zA-Z\\d])*")) {
			JOptionPane.showMessageDialog(null, "ten co thể gồm nhiều từ ngăn cách bởi khoảng trắng, \r\n"
					+ "có thể chứa số nhưng KHÔNG ký tự đặc biệt");
			txtTen.selectAll();
			txtTen.requestFocus();
			return false;
		}
		if(diaChi.equals("")||!diaChi.matches("[a-zA-Z\\d]+( [a-zA-Z\\d])*")) {
			JOptionPane.showMessageDialog(null, "dia chi co thể gồm nhiều từ ngăn cách bởi khoảng trắng, \r\n"
					+ "có thể chứa số nhưng KHÔNG ký tự đặc biệt");
			txtDiaChi.selectAll();
			txtDiaChi.requestFocus();
			return false;
		}
	
		
		if(hsLuong.equals("")) {
			JOptionPane.showMessageDialog(null, "luong khong duoc bo trong");
			
			txtHeSoLuong.requestFocus();
			return false;
		}
		else {
			try {
				double hs = Double.parseDouble(hsLuong);
				if(hs<1.68||hs>5.9) {
					JOptionPane.showMessageDialog(null, "Hệ số Lương Nhân Viên từ 1.68 - 5.9 mới hợp lệ");
					txtHeSoLuong.selectAll();
					txtHeSoLuong.requestFocus();
					return false;
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "hs luong phai la so");
				txtHeSoLuong.selectAll();
				txtHeSoLuong.requestFocus();
				return false;
			}
		}
		if(email.equals("")||!email.matches("^[a-zA-Z][._\\da-zA-Z]*@(yahoo||google||iuh||hotmail)")) {
			JOptionPane.showMessageDialog(null, "email khong hop le");
			txtEmail.selectAll();
			txtEmail.requestFocus();
			return false;
		}
		
		return true;
	}
}
