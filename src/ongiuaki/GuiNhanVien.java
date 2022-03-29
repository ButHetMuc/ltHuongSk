package ongiuaki;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class GuiNhanVien extends JFrame {
	
	private JTextField txtMaNv;
	private JTextField txtHoNv;
	private JTextField txtTenNv;
	private JTextField txtTuoiNv;
	private JTextField txtTienLuongNv;
	private JComboBox cboGioiTinh;
	private JComboBox cboPhongBan;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JButton btnLuu;
	private DefaultTableModel modeltblNhanVien;
	private JTable tblNhanVien;
	private JRadioButton rdNu;
	private DanhSachNhanVien dsnv = new DanhSachNhanVien();
	private JButton btnTim;
	private JTextField txtTim;

	public GuiNhanVien() {
		
		setTitle("le dinh but");
		setSize(700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		addControls();
		addEvents();
	}
	
	private void addControls() {
		
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth,BoxLayout.Y_AXIS));
		
		JLabel lblMaNv,lblHoNv,lblTenNv,lblTuoiNv,lblGioiTinh,lblTienLuong,lblPhongBan;
		
		lblMaNv = new JLabel("Mã nhân viên");
		lblHoNv = new JLabel("Họ");
		lblTenNv = new JLabel("Tên nhân viên");
		lblTuoiNv = new JLabel("Tuổi");
		lblGioiTinh = new JLabel("Phái");
		lblTienLuong = new JLabel("Tiền lương");
		lblPhongBan = new JLabel("Phòng ban");
		
		lblMaNv.setPreferredSize(lblTenNv.getPreferredSize());
		lblHoNv.setPreferredSize(lblTenNv.getPreferredSize());
		lblTuoiNv.setPreferredSize(lblTenNv.getPreferredSize());
		lblTienLuong.setPreferredSize(lblTenNv.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblTenNv.getPreferredSize());
		
		txtMaNv = new JTextField(50);
		txtHoNv = new JTextField(50);
		txtTenNv = new JTextField(50);
		txtTuoiNv = new JTextField(50);
		txtTienLuongNv = new JTextField(50);
		
		JPanel pnGtPb = new JPanel();
//		String[] arrGt = {"Nam","Nữ"};
		String[] arrPb = {"1. Phòng tổ chức","2. Phòng kĩ thuật","3. Phòng nhân sự","4. Phòng tài vụ"};
//		cboGioiTinh = new JComboBox(arrGt);
		rdNu = new JRadioButton("Nữ");
		cboPhongBan = new JComboBox(arrPb);
		cboPhongBan.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		pnGtPb.add(lblGioiTinh);
		pnGtPb.add(rdNu);
		pnGtPb.add(lblPhongBan);
		pnGtPb.add(cboPhongBan);
		
		pnNorth.add(createTfPanel(lblMaNv, txtMaNv));
		pnNorth.add(createTfPanel(lblHoNv, txtHoNv));
		pnNorth.add(createTfPanel(lblTenNv, txtTenNv));
		pnNorth.add(createTfPanel(lblTuoiNv, txtTuoiNv));
		pnNorth.add(pnGtPb);
		pnNorth.add(createTfPanel(lblTienLuong, txtTienLuongNv));
		this.add(pnNorth/*,BorderLayout.NORTH*/);
		
		btnThem = new JButton("Thêm");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		btnXoaTrang= new JButton("Xóa trắng");
		btnLuu = new JButton("Lưu");
		btnTim = new JButton("Tìm theo mã");
		txtTim = new JTextField(10);
		
		JPanel pnButton = new JPanel();
		pnButton.add(btnThem);
		pnButton.add(btnSua);
		pnButton.add(btnXoa);
		pnButton.add(btnXoaTrang);
		pnButton.add(btnLuu);
		pnButton.add(btnTim);
		pnButton.add(txtTim);
		
		
		this.add(pnButton/*,BorderLayout.CENTER*/);
		
		JPanel pnBot = new JPanel();
		pnBot.setLayout(new BorderLayout());
		
		String[] cols = {"Mã","Họ","Tên","Tuổi","giới tính","phòng ban","tiền lương"};
		modeltblNhanVien = new DefaultTableModel(cols, 0);
		tblNhanVien = new JTable(modeltblNhanVien);
		JScrollPane scrtblNhanVien = new JScrollPane(tblNhanVien,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnBot.add(scrtblNhanVien,BorderLayout.CENTER);
		
		this.add(pnBot/*,BorderLayout.SOUTH*/);
		
		docFile();
		
	}

	private void docFile()  {
		FileNhanVien f = new FileNhanVien();
		try {
			dsnv = (DanhSachNhanVien) f.docFile("src\\ongiuaki\\data1.txt");
		} catch (ClassNotFoundException | IOException e) {		
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "không tìm thầy file");
		}
		
		for(NhanVien nv : dsnv.getDsnv()) {
			Object[] row = {nv.getMaNv(),nv.getHoNv(),nv.getTenNv(),nv.getTuoiNv(),nv.isNvNu()?"Nu":"Nam",nv.getPhongBanNv(),nv.getLuongNv()};
			modeltblNhanVien.addRow(row);
		}
		return;
	}

	private void addEvents() {
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				String maNv = txtMaNv.getText();
				String hoNv = txtHoNv.getText();
				String tenNv = txtTenNv.getText();
				String tuoiNv = txtTuoiNv.getText();
				String luongNv = txtTienLuongNv.getText() ;
				int phongBannv = cboPhongBan.getSelectedIndex();
				boolean isNu = rdNu.isSelected();
				if(!checkData())
					return;
				NhanVien nv = new NhanVien(maNv, hoNv, tenNv,Integer.parseInt(tuoiNv) , isNu,phongBannv ,Double.parseDouble(luongNv));
				
				if(dsnv.themNhanVien(nv)) 
					JOptionPane.showMessageDialog(null, "thêm thành công");
				else {
					JOptionPane.showMessageDialog(null, "có lỗi xảy ra");
					return;
				}
				String pBan="";
				switch (nv.getPhongBanNv()) {
				case 0:  pBan ="Phòng tổ chức";
						break;
				case 1:  pBan ="Phòng kĩ thuật";
						break;
				case 2:  pBan ="Phòng nhân sự";
						break;
				case 3:  pBan ="Phòng tài vụ";
						break;					
				}
				Object[] row = {nv.getMaNv(),nv.getHoNv(),nv.getTenNv(),nv.getTuoiNv(),nv.isNvNu()?"Nữ":"Nam",pBan,nv.getLuongNv()};
				modeltblNhanVien.addRow(row);
				return;
			}
		});
		
		btnXoaTrang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtMaNv.setText("");
				txtHoNv.setText("");
				txtTenNv.setText("");
				txtTuoiNv.setText("");
				txtTienLuongNv.setText("");
				rdNu.setSelected(false);
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblNhanVien.getSelectedRow();
				if(index == -1)
					return;
				String ma = (String) tblNhanVien.getValueAt(index, 0);
				if(dsnv.xoaNhanVien(ma)) {
					modeltblNhanVien.removeRow(index);
					tblNhanVien.clearSelection();
					JOptionPane.showMessageDialog(null, "xoa thanh cong");
					return;
				}
			}
		});
		
		btnTim.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ma = txtTim.getText();
				if(ma.equals("")) {
					JOptionPane.showMessageDialog(null, "nhap ma vao o tim kiem");
					return;
				}
				NhanVien nv = new NhanVien(ma);
				if(dsnv.getDsnv().contains(nv)) {
					Object[] row = {nv.getMaNv(),nv.getHoNv(),nv.getTenNv(),nv.getTuoiNv(),nv.isNvNu()?"Nữ":"Nam",nv.getPhongBanNv(),nv.getLuongNv()};
					modeltblNhanVien.setRowCount(0);
					modeltblNhanVien.addRow(row);
					return;
				}
				else {
					JOptionPane.showMessageDialog(null, "khong tim thay nhan vien nao");
					return;
				}
			}
		});
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileNhanVien fileNV = new FileNhanVien();
				try {
					fileNV.luuFile(dsnv, "src\\ongiuaki\\data1.txt");
					JOptionPane.showMessageDialog(null, "lưu thành công");
					return;
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "có lỗi xảy ra");
					return;
				}
				
			}
		});
		
	}
	public boolean checkData() {
		String maNv = txtMaNv.getText();
		String hoNv = txtHoNv.getText();
		String tenNv = txtTenNv.getText();
		String tuoiNv = txtTuoiNv.getText();
		String luongNv = txtTienLuongNv.getText();
		int phongBannv = cboPhongBan.getSelectedIndex();
		boolean isNu = rdNu.isSelected();
		
	if(maNv.equals("")) {
		JOptionPane.showMessageDialog(null, "mã không được bỏ trống");
		txtMaNv.selectAll();
		txtMaNv.requestFocus();
		return false;
		}
	if(hoNv.equals("")) {
		JOptionPane.showMessageDialog(null, "Họ không được bỏ trống");
		txtHoNv.selectAll();
		txtHoNv.requestFocus();
		return false;
		}
	if(tenNv.equals("")) {
		JOptionPane.showMessageDialog(null, "tên không được bỏ trống");
		txtTenNv.selectAll();
		txtTenNv.requestFocus();
		return false;
		}
	
	try {
		int tuoi = Integer.parseInt(tuoiNv);
		if(tuoi<17) {
			JOptionPane.showMessageDialog(null, "tuổi phải >= 18");
			return false;
		}
	} catch (NumberFormatException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null,"tuổi phải là số và không được bỏ trống");
		return false;
	}
	try {
		double luong = Double.parseDouble(luongNv);
		if(luong<0) {
			JOptionPane.showMessageDialog(null, "Lương phải >0");
			return false;
		}
	} catch (NumberFormatException e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null,"lương phải là số và không được bỏ trống");
		return false;
	}
	return true;
	
	}
	
	private JPanel createTfPanel(JLabel lbl, JTextField tf) {
		JPanel pn = new JPanel();
		pn.add(lbl);
		pn.add(tf);
		return pn;
	}

	public static void main(String[] args) {
		new GuiNhanVien().setVisible(true);
	}
}
