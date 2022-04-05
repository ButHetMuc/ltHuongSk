package rework_giuaki;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Gui_NhanVien extends JFrame {
	
	private JTextField txtMaNv;
	private JTextField txtHoNv;
	private JTextField txtTenNv;
	private JTextField txtLuongNv;
	private DefaultTableModel modelKhachHang;
	private JTable tblNhanVien;
	private DanhSachNv dsnv;
	

	public Gui_NhanVien() {
		setTitle("le dinh but");
		setSize(700,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addControls();
		addEvents();
		
	}

	private void addControls() {
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		
		JLabel lblMa,lblHo,lblTen,lblPhai,lblPhongban,lblTienluong;
		lblMa = new JLabel("Ma");
		lblHo = new JLabel("Ho");
		lblTen = new JLabel("Ten");
		lblPhai = new JLabel("Phai");
		lblPhongban = new JLabel("Phong ban");
		lblTienluong = new JLabel("Tien luong");
		
		lblMa.setPreferredSize(lblTienluong.getPreferredSize());
		lblHo.setPreferredSize(lblTienluong.getPreferredSize());
		lblTen.setPreferredSize(lblTienluong.getPreferredSize());
		lblPhai.setPreferredSize(lblTienluong.getPreferredSize());
//		lbMa.setPreferredSize(lblTienluong.getPreferredSize());
		
		txtMaNv = new JTextField(40);
		txtHoNv = new JTextField(40);
		txtTenNv = new JTextField(40);
		txtLuongNv = new JTextField(40);
		
		
		JPanel pnTop = new JPanel();
		pnTop.setLayout(new BoxLayout(pnTop,BoxLayout.Y_AXIS));
		pnTop.add(createTfPanel(lblMa, txtMaNv));
		pnTop.add(createTfPanel(lblHo, txtHoNv));
		pnTop.add(createTfPanel(lblTen, txtTenNv));
		pnTop.add(createTfPanel(lblTienluong, txtLuongNv));
		
		this.add(pnTop);
		
		JPanel pnMid = new JPanel();
		 
		JPanel pnBot = new JPanel();
		pnBot.setLayout(new BorderLayout());
		
		String[] cols = {"abc","x","x","safd","sad"};
		modelKhachHang = new DefaultTableModel(cols,0);
		tblNhanVien = new JTable(modelKhachHang);
		JScrollPane scrtblNhanVien = new JScrollPane(tblNhanVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		pnBot.add(scrtblNhanVien,BorderLayout.CENTER);
		this.add(pnBot);
		
		docFile();
		
	}
	
	private void docFile() {
		DocLuuFile file = new DocLuuFile();
		try {
			dsnv = (DanhSachNv) file.docFile("src\\rework_giuaki\\data.txt");
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showMessageDialog(getContentPane(), "khong tim thay file");
			e.printStackTrace();
			return;
		}
		for(NhanVien nv: dsnv.getListNhanVien()) {
			Object[] row  = {nv.getMaNv(),nv.getHoNv(),nv.getTenNv(),nv.getPhongBan(),nv.getLuongNv()};
			modelKhachHang.addRow(row);
		}
	}
	private boolean ghiFile(DanhSachNv ds,String filePath) {
		DocLuuFile file = new DocLuuFile();
		try {
			file.luuFile(ds, "src\\rework_giuaki\\data.txt");
			JOptionPane.showMessageDialog(getContentPane(), "luu thanh cong");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(getContentPane(), "co loi xay ra");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	private JPanel createTfPanel(JLabel lbl,JTextField txt) {
		JPanel pn = new JPanel();
		pn.add(lbl);
		pn.add(txt);
		return pn;
	}
	
	private void addEvents() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new Gui_NhanVien().setVisible(true);
		
	}

}
