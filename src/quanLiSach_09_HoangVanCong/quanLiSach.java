package quanLiSach_09_HoangVanCong;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.MetalComboBoxButton;
import javax.swing.table.DefaultTableModel;

import tuan2.bai1.NhanVien;

public class quanLiSach extends JFrame {
	
	private static String filePath = "src\\quanLiSach_09_HoangVanCong\\DanhMucSach.txt";
	
	private JPanel pnCenter;
	
	private JTextField txtMa = new JTextField(20);
	private JTextField txtTuaSach= new JTextField(20);
	private JTextField txtNamXuatBan= new JTextField(20);
	private JTextField txtSoTrang= new JTextField(20);
	private JTextField txtIsbn= new JTextField(20);
	private JTextField txtTacGia= new JTextField(20);
	private JTextField txtNhaXuatBan= new JTextField(20);
	private JTextField txtDonGia= new JTextField(20);
	
	private JButton btnThem = new JButton("Thêm");
	private JButton btnXoaTrong = new JButton("Xóa trống");
	private JButton btnXoa = new JButton("Xóa");
	private JButton btnSua = new JButton("Sửa");
	private JButton btnLuu = new JButton("Lưu");
	
	private DefaultComboBoxModel<String> modelComboBox = new DefaultComboBoxModel<>();
	private JComboBox<String> cbListMaSach = new JComboBox<>(modelComboBox);
	
	private DefaultTableModel modelDS = new DefaultTableModel(new String[] {"Mã sách","Tựa sách","Tác giả","Năm xuất bản","Nhà xuất bản","Số trang","�?ơn giá","Isbn"},0);
	private JTable tbDS = new JTable(modelDS);
	private DanhSachSach listSach = new DanhSachSach();
	

	public quanLiSach() {
		
		createGUI();
		docDuLieuTuArrayList();
		renderComboBox(listSach);
		handleEvent();
	}
	
	private void createGUI() {
		setTitle("Quản lí sách");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setLocationRelativeTo(null);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel pnTop = new JPanel();
		pnTop.setBorder(new TitledBorder("Records editor"));
		pnCenter = new JPanel();
		JPanel pnBot = new JPanel();
		add(pnTop);
		add(pnCenter);
		add(pnBot);
		
		pnTop.setLayout(new BorderLayout());
		JPanel pnTopLeft = new JPanel();
		JPanel pnTopRight = new JPanel();
		pnTop.add(pnTopLeft,BorderLayout.WEST);
		pnTop.add(pnTopRight,BorderLayout.EAST);
		pnTopLeft.setLayout(new BoxLayout(pnTopLeft, BoxLayout.Y_AXIS));
		pnTopRight.setLayout(new BoxLayout(pnTopRight, BoxLayout.Y_AXIS));
		
		JPanel pnMa = new JPanel();
		JPanel pnTuaSach = new JPanel();
		JPanel pnNamXuatBan = new JPanel();
		JPanel pnSoTrang = new JPanel();
		JPanel pnISBM = new JPanel();
		JPanel pnTacGia = new JPanel();
		JPanel pnNhaXuatBan = new JPanel();
		JPanel pnDonGia = new JPanel();
		pnTopLeft.add(pnMa);
		pnTopLeft.add(pnTuaSach);
		pnTopLeft.add(pnNamXuatBan);
		pnTopLeft.add(pnSoTrang);
		pnTopLeft.add(pnISBM);
		pnTopRight.add(pnTacGia);
		pnTopRight.add(pnNhaXuatBan);
		pnTopRight.add(pnDonGia);

		
		JLabel lbl = new JLabel("Mã sách");
		lbl.setPreferredSize(new Dimension(100, 14));
		pnMa.add(lbl);
		pnMa.add(txtMa);
		
		pnTuaSach.add(new JLabel("Tựa sách"));
		pnTuaSach.add(txtTuaSach);
		
		pnNamXuatBan.add(new JLabel("Năm xuất bản"));
		pnNamXuatBan.add(txtNamXuatBan);
		
		pnSoTrang.add(new JLabel("Số trang"));
		pnSoTrang.add(txtSoTrang);
		
		pnISBM.add(new JLabel("ISMB"));
		pnISBM.add(txtIsbn);
		
		pnTacGia.add(new JLabel("Tác giả"));
		pnTacGia.add(txtTacGia);
		
		pnNhaXuatBan.add(new JLabel("Nhà xuất bản"));
		pnNhaXuatBan.add(txtNhaXuatBan);

		pnDonGia.add(new JLabel("�?ơn giá"));
		pnDonGia.add(txtDonGia);
		
		pnCenter.add(btnThem);
		pnCenter.add(btnXoaTrong);
		pnCenter.add(btnSua);
		pnCenter.add(btnXoa);
		pnCenter.add(btnLuu);
		pnCenter.add(new JLabel("Tìm theo mã sách"));
		pnCenter.add(cbListMaSach);
		
		pnBot.setLayout(new BorderLayout());
		pnBot.setBorder(new TitledBorder("Danh sách các cuốn sách"));
		pnBot.add(new JScrollPane(tbDS),BorderLayout.CENTER);
		
		// non editable
		tbDS.setDefaultEditor(Object.class, null);
		
	}
	
	private void handleEvent() {
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ma = txtMa.getText();
				String tua = txtTuaSach.getText();
				String nam = txtNamXuatBan.getText();
				String soTrang = txtSoTrang.getText();
				String isbn = txtIsbn.getText();
				String tacGia = txtTacGia.getText();
				String nhaXuatBan = txtNhaXuatBan.getText();
				String donGia = txtDonGia.getText();
				
				String strPattern;
				Pattern  pattern;
				Matcher matcher;
				boolean result = false;
				
				int namXuatBanInt;
				int soTrangInt;
				double donGiaDouble;
				
				
				
				if(ma.equals("") || tua.equals("") || isbn.equals("") || tacGia.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng đi�?n đầy đủ thông tin");
					return;
				}
				else {
					
				 // check Mã sách
					if(listSach.contains(ma)) {
						JOptionPane.showMessageDialog(null, "Má sách đã tồn tại");
						return;
					}else {
						strPattern = "^" + tua.charAt(0) + "\\d{3}";
						pattern = Pattern.compile(strPattern);
						matcher = pattern.matcher(ma);
						result = matcher.matches();
						if(!result) {
							JOptionPane.showMessageDialog(null, "Mã chưa hợp lệ, vui lòng thử lại");
							return;
						}
					}
					
					// check tựa sách
					strPattern = "^([A-Z][a-z\\']+)(\\s[A-Z\\'][a-z\\']+)*";
					pattern = Pattern.compile(strPattern);
					matcher = pattern.matcher(tua);
					result = matcher.matches();
					if(!result) {
						JOptionPane.showMessageDialog(null, "Tựa không hợp lệ, vui lòng thử lại");
						return;
					}
					
					// check tác giả
					result = pattern.matcher(tacGia).matches();
					if(!result) {
						JOptionPane.showMessageDialog(null, "Tác giả không hợp lệ, vui lòng thử lại");
						return;
					}
					
					// check ISBN
					strPattern = "\\d+(-\\d+){3,4}";
					result = isbn.matches(strPattern);
					if(!result) {
						JOptionPane.showMessageDialog(null, "Mã ISBN không hợp lệ");
						return;
					}
					
					try {
						namXuatBanInt = Integer.parseInt(nam);
						if(namXuatBanInt <= 0) {
							JOptionPane.showMessageDialog(null, "Số năm xuất bản không hợp lệ");							
							return;
						}
						
					}catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Số năm xuất bản không hợp lệ");
						return;
					}
					
					try {
						soTrangInt = Integer.parseInt(soTrang);
						if(soTrangInt <=0) {
							JOptionPane.showMessageDialog(null, "Số trang không hợp lệ");
							return;
						}
						
					}catch (Exception e3) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Số trang không hợp lệ");
						return;
					}
					
					try {
						donGiaDouble = Double.parseDouble(donGia);
						if(donGiaDouble <0) {
							JOptionPane.showMessageDialog(null, "�?ơn giá không hợp lệ");
							return;
						}
						
					}catch (Exception e3) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "�?ơn giá không hợp lệ");
						return;
					}
					
					
				
				}
				
				
				
				//all good
				boolean result2 = listSach.themSach(new Sach(ma,tua,tacGia,namXuatBanInt,nhaXuatBan,soTrangInt,donGiaDouble,isbn));
				if(result2) {
					modelDS.addRow(new Object[] {ma,tua,tacGia,namXuatBanInt,nhaXuatBan,soTrangInt,donGiaDouble,isbn});
					JOptionPane.showMessageDialog(null, "Thêm thành công");
				}else {
					JOptionPane.showMessageDialog(null, "Thêm thất bại, vui lòng thử lại");
					return;
				}
				
				renderComboBox(listSach);
			}
		});
		
		// Lưu xuống file
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LuuTru l = new LuuTru();
				try {
					l.luuFile(listSach, filePath);
					JOptionPane.showMessageDialog(null, "Lưu thành công");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lưu xuống file thất bại, vui lòng thử lại");
					return;
				}
			}
		});
		
		// Xóa row
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tbDS.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng ch�?n sách cần xóa");
					return;
				}
				
				if(!listSach.xoaSach(tbDS.getValueAt(row, 0).toString())) {
					JOptionPane.showMessageDialog(null, "Xóa thất bại, vui lòng thử lại");
					return;
				}
				modelDS.removeRow(row);
				JOptionPane.showMessageDialog(null, "Xóa thành công");
				return;
			}
		});
		// Xóa trống component nhập
		btnXoaTrong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtMa.setText("");
				txtTuaSach.setText("");
				txtNamXuatBan.setText("");
				txtSoTrang.setText("");
				txtIsbn.setText("");
				txtTacGia.setText("");
				txtNhaXuatBan.setText("");
				txtDonGia.setText("");
			}
		});
	
		// Cập nhật sách
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row = tbDS.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng ch�?n sách cần sửa");
					return;
				}
				String maSachEdit = tbDS.getValueAt(row, 0).toString();
				
				String ma = txtMa.getText();
				String tua = txtTuaSach.getText();
				String nam = txtNamXuatBan.getText();
				String soTrang = txtSoTrang.getText();
				String isbn = txtIsbn.getText();
				String tacGia = txtTacGia.getText();
				String nhaXuatBan = txtNhaXuatBan.getText();
				String donGia = txtDonGia.getText();
				
				int namXuatBanInt;
				int soTrangInt;
				double donGiaDouble;
				
				
				
				if(ma.equals("") || tua.equals("") || isbn.equals("") || tacGia.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng đi�?n đầy đủ thông tin");
					return;
				}
				else {
				 // handle more
					
					if(!maSachEdit.equals(ma)) {
						if(listSach.contains(ma)) {
							JOptionPane.showMessageDialog(null, "Má sách đã tồn tại");
							return;
						}
					}
					
					try {
						namXuatBanInt = Integer.parseInt(nam);
						if(namXuatBanInt <= 0) {
							JOptionPane.showMessageDialog(null, "Số năm xuất bản không hợp lệ");							
							return;
						}
						
					}catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Số năm xuất bản không hợp lệ");
						return;
					}
					
					try {
						soTrangInt = Integer.parseInt(soTrang);
						if(soTrangInt <=0) {
							JOptionPane.showMessageDialog(null, "Số trang không hợp lệ");
							return;
						}
						
					}catch (Exception e3) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "Số trang không hợp lệ");
						return;
					}
					
					try {
						donGiaDouble = Double.parseDouble(donGia);
						if(donGiaDouble <0) {
							JOptionPane.showMessageDialog(null, "�?ơn giá không hợp lệ");
							return;
						}
						
					}catch (Exception e3) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "�?ơn giá không hợp lệ");
						return;
					}
					
				}
				
				//all good
				boolean result = listSach.capNhat(maSachEdit, new Sach(ma,tua,tacGia,namXuatBanInt,nhaXuatBan,soTrangInt,donGiaDouble,isbn));
				if(result) {
					modelDS.removeRow(row);
					modelDS.insertRow(row, new Object[] {ma,tua,tacGia,namXuatBanInt,nhaXuatBan,soTrangInt,donGiaDouble,isbn});
					
					JOptionPane.showMessageDialog(null, "Cập nhật thành công");
				}else {
					JOptionPane.showMessageDialog(null, "Cập nhật thất bại, vui lòng thử lại");
					return;
				}
				
			}
		});
	
		// Click ch�?n các phần tử trên table
		tbDS.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tbDS.getSelectedRow();
				if(row != -1) {
					txtMa.setText(tbDS.getValueAt(row, 0).toString());
					txtTuaSach.setText(tbDS.getValueAt(row, 1).toString());
					txtTacGia.setText(tbDS.getValueAt(row, 2).toString());
					txtNamXuatBan.setText(tbDS.getValueAt(row, 3).toString());
					txtNhaXuatBan.setText(tbDS.getValueAt(row, 4).toString());
					txtSoTrang.setText(tbDS.getValueAt(row, 5).toString());
					txtDonGia.setText(tbDS.getValueAt(row, 6).toString());
					txtIsbn.setText(tbDS.getValueAt(row, 7).toString());
				}
				
			}
			
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
			
		});
	
		// Click ch�?n 1 phần tử trong comboBox
		cbListMaSach.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object objSelected = cbListMaSach.getSelectedItem();
				if(objSelected == null) return;
				
				String strSelected = objSelected.toString();
				if(strSelected.equals("")) {
					return;
				}
				
				Sach sach = listSach.timSach(strSelected);
				if(sach != null) {
					modelDS.setRowCount(0);
					modelDS.addRow(new Object[] {sach.getMaSach(),sach.getTuaSach(), sach.getTacGia(),sach.getNamXuatBan(), sach.getNhaXuatBan(), sach.getSoTrang(), sach.getDonGia(), sach.getIsbn()});					
				}
			
			}
		});
	}
	
	private void docDuLieuTuArrayList() {
		LuuTru l = new LuuTru();
		
		try {
			listSach = (DanhSachSach) l.docFile(filePath);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy file");
			return;
		}
		
		for(Sach s: listSach.getDsSach()) {
			modelDS.addRow(new Object[] {s.getMaSach(),s.getTuaSach(), s.getTacGia(), s.getNamXuatBan(), s.getNhaXuatBan(), s.getSoTrang(),s.getDonGia(),s.getIsbn()});
		}
	}
	
	// get and render các mã sách vào combobox
	private void renderComboBox(DanhSachSach ds) {
		modelComboBox.removeAllElements();		
		
		String[] listItem = new String[ds.getSize()];
		int i =0;
		for(Sach sach: ds.getDsSach()) {
			listItem[i++] = sach.getMaSach();
		}
		for(String item: listItem) {
			modelComboBox.addElement(item);
		}
	}
	
	
	
	public static void main(String[] args) {
		new quanLiSach().setVisible(true);
	}

}
