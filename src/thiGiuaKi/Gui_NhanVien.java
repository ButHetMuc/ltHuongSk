package thiGiuaKi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Gui_NhanVien extends JFrame {
	private JTextField txtMaNV;
	private JTextField txtHoNV;
	private JTextField txtTenNV;
	private JTextField txtTuoiNV;
	private JTextField txtLuongNV;
	private JCheckBox chkGioiTinh;
	private DefaultTableModel modelDsNv;
	private JTable tblDSNV;
	private JTextField txtMaSo;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnLuu;
	private DsNhanVien listNhanVien = new DsNhanVien();
	public Gui_NhanVien() {
		super("^-^");
		setSize(600,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		addControls();
		addEvents();
	}

	private void addControls() {
	
		JPanel pnTop = new JPanel();
		pnTop.setLayout(new BoxLayout(pnTop,BoxLayout.Y_AXIS));
		
		JLabel lblTitle = new JLabel("THONG TIN NHAN VIEN");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pnTop.add(lblTitle);
		
		
		JPanel pnMaNV = new JPanel();
		FlowLayout LayoutpnMaNV = (FlowLayout) pnMaNV.getLayout();
		LayoutpnMaNV.setAlignment(FlowLayout.LEFT);
		JLabel lblMaNV = new JLabel("Ma nhan vien:");
		lblMaNV.setPreferredSize(new Dimension(100, 14));
		txtMaNV = new JTextField(50);
		
		pnMaNV.add(lblMaNV);
		pnMaNV.add(txtMaNV);
		pnTop.add(pnMaNV);
		

		JPanel pnHoTenNV = new JPanel();
		FlowLayout layoutPnHoTen = (FlowLayout) pnHoTenNV.getLayout();
		layoutPnHoTen.setAlignment(FlowLayout.LEFT);
		JLabel lblHoNV = new JLabel("Ho: ");
		lblHoNV.setPreferredSize(new Dimension(100,14));
		txtHoNV = new JTextField(20);

		JLabel lblTenNV = new JLabel("Ten nhan vien: ");
		txtTenNV = new JTextField(18);
		pnHoTenNV.add(lblHoNV);
		pnHoTenNV.add(txtHoNV);
		pnHoTenNV.add(lblTenNV);
		pnHoTenNV.add(txtTenNV);
		pnTop.add(pnHoTenNV);
		
		JPanel pnTuoiNV = new JPanel();
		FlowLayout layoutPnTuoi = (FlowLayout)pnTuoiNV.getLayout();
		layoutPnTuoi.setAlignment(FlowLayout.LEFT);
		JLabel lblTuoiNV = new JLabel("Tuoi: ");
		lblTuoiNV.setPreferredSize(new Dimension(100,14));
		txtTuoiNV = new JTextField(41);
		JLabel lblGioiTinhNV = new JLabel("phai");
		chkGioiTinh = new JCheckBox("nu\t");
		
		pnTuoiNV.add(lblTuoiNV);
		pnTuoiNV.add(txtTuoiNV);
		pnTuoiNV.add(lblGioiTinhNV);
		pnTuoiNV.add(chkGioiTinh);
		pnTop.add(pnTuoiNV);
		
		JPanel pnLuongNV = new JPanel();
		FlowLayout layoutPnLuong = (FlowLayout)pnLuongNV.getLayout();
		layoutPnLuong.setAlignment(FlowLayout.LEFT);
		JLabel lblLuongNV = new JLabel("Luong: ");
		lblLuongNV.setPreferredSize(new Dimension(100,14));
		txtLuongNV = new JTextField(50);
		pnLuongNV.add(lblLuongNV);
		pnLuongNV.add(txtLuongNV);
		pnTop.add(pnLuongNV);
	
		this.add(pnTop,BorderLayout.NORTH);
		
		String[] cols = {"mã nv","họ","Tên","Phái","Tuổi","Tiền lương"};
		modelDsNv = new DefaultTableModel(cols,0);
		tblDSNV = new JTable(modelDsNv);
		JScrollPane scrTblNhanVien = new JScrollPane(
				tblDSNV, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(scrTblNhanVien,BorderLayout.CENTER);
		
		JPanel pnBot = new JPanel();
		JPanel pnBotRight = new JPanel();
		FlowLayout layoutPnBotR = (FlowLayout)pnBotRight.getLayout();
		layoutPnBotR.setAlignment(FlowLayout.LEFT);
		pnBotRight.setPreferredSize(new Dimension(270, 0));
		JPanel pnBotLeft = new JPanel();
		JSplitPane spl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnBotRight, pnBotLeft);
		pnBot.add(spl);
		
		pnBotRight.add(new JLabel("nhập mã số cần tìm:"));
		txtMaSo = new JTextField(5);
		btnTim = new JButton("Tìm");
		
		pnBotRight.add(txtMaSo);
		pnBotRight.add(btnTim);
		
	
		btnThem = new JButton("Them");
		btnXoaTrang = new JButton("Xoa trang");
		btnXoa = new JButton("Xoa");
		btnLuu = new JButton("Luu");
		
		pnBotLeft.add(btnThem);
		pnBotLeft.add(btnXoaTrang);
		pnBotLeft.add(btnXoa);
		pnBotLeft.add(btnLuu);
		
		
		this.add(spl,BorderLayout.SOUTH);
		
		docDuLieuVaotbl();
	}



	private void docDuLieuVaotbl() {
		Save s = new Save();
		try {
			listNhanVien = (DsNhanVien) s.readFile("data.txt");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "không tìm được file");
		}
		
		for( NhanVien nv: listNhanVien.dsnv ) {
			modelDsNv.addRow(new Object[] {nv.getMaNV(),nv.getHoNV(),nv.getTenNV(),
					nv.getTuoiNV(),nv.isGioiTinh()?"nu":"nam",nv.getTienLuong()} );
		}
	}

	private void addEvents() {
		btnXoaTrang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtMaNV.setText("");
				txtHoNV.setText("");
				txtTenNV.setText("");
				txtTuoiNV.setText("");
				txtLuongNV.setText("");
				chkGioiTinh.setSelected(false);
			}
		});
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String maNv = txtMaNV.getText();
				String hoNv = txtHoNV.getText();
				String tenNv = txtTenNV.getText();
				String tuoiNv = txtTuoiNV.getText();
				boolean isFeMale = chkGioiTinh.isSelected();
				String luongNv = txtLuongNV.getText(); 
				
				int tuoi =0;
				double luong =0;
				
				if(maNv.equals("") || hoNv.equals("") || tenNv.equals("")|| 
						tuoiNv.equals("")|| luongNv.equals("")) {
					JOptionPane.showMessageDialog(null, "chua nhap du du lieu");
					return;
				}
				try {
					tuoi = Integer.parseInt(tuoiNv);
					luong = Double.parseDouble(luongNv);
				} catch (NumberFormatException ex) {
					// TODO: handle exception
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "tuổi hoặc lương phải nhập số");
					return;
				}
				
				if(tuoi<18) {
					JOptionPane.showMessageDialog(null, "xin thông báo bạn chưa đủ tuổi");
					return;
				}
				if(luong<=0) {
					JOptionPane.showMessageDialog(null, "lương bị âm?");
					return;
				}
				
				NhanVien nv = new NhanVien(maNv, tenNv, hoNv, tuoi, isFeMale, luong);
				if(listNhanVien.themNhanVien(nv))
					JOptionPane.showMessageDialog(null, "them thanh cong");
				else {
					JOptionPane.showMessageDialog(null, "that bai");
					return;
				}
				Object[] row = {nv.getMaNV(),nv.getHoNV(),nv.getTenNV(),nv.getTuoiNV(),nv.isGioiTinh()?"nu":"nam",nv.getTienLuong()};
				modelDsNv.addRow(row);
				return;
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tblDSNV.getSelectedRow();
				if(index == -1)
					return;
				String ma = (String) tblDSNV.getValueAt(index, 0);
				if(listNhanVien.xoaNhanVien(ma)) {
					modelDsNv.removeRow(index);
					JOptionPane.showMessageDialog(null, "xóa thành công");
					return;
				}		
			}
		});
		
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Save save = new Save();
				try {
					save.saveFile(listNhanVien, "data.txt");
					JOptionPane.showMessageDialog(null, "lưu thành công");
					
				} catch (IOException ie) {
					ie.printStackTrace();
					
				}
			}
		});
		
	}
	public static void main(String[] args) {
		Gui_NhanVien guiNv = new Gui_NhanVien();
		guiNv.setVisible(true);
		
	}
}
