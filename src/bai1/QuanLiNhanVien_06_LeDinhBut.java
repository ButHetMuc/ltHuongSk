package bai1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class QuanLiNhanVien_06_LeDinhBut extends JFrame {

	private JLabel lblTitle;
	private JTextField txfHo;
	private JTextField txfMa;
	private JTextField txfTuoi;
	private JTextField txfTen;
	private JTextField txfTienLuong;
	private JCheckBox chkPhai;

	private DefaultTableModel dtfNhanVien;
	private JTable tbNhanVien;
	private DanhSachNhanVien listNV = new DanhSachNhanVien();

	private JTextField txfTimKiem;
	private JButton btnTimKiem;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnLuu;

	public QuanLiNhanVien_06_LeDinhBut() {
		this.setTitle("^.^");
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		createGUI();

		listNV.themNhanVien(new NhanVien("111", "Trá»�ng", "BÃºt", true, 21, 20000));
		listNV.themNhanVien(new NhanVien("222", "Minh", "Minh", true, 21, 20000));
		listNV.themNhanVien(new NhanVien("333", "Há»“", "Ná»¯", false, 21, 20000));
		listNV.themNhanVien(new NhanVien("444", "HoÃ ng", "Nhi", false, 21, 20000));

		DocDuLieuTuArrayListVaoModel();

	}

	public void createGUI() {
		setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.X_AXIS));

		setLayout(new BorderLayout());

		add(pnNorth, BorderLayout.NORTH);
		add(pnSouth, BorderLayout.SOUTH);

		JPanel pnTitle = new JPanel();
		JPanel pnHoVaTen = new JPanel();
		JPanel pnMa = new JPanel();
		JPanel pnTuoiVaPhai = new JPanel();
		JPanel pnLuong = new JPanel();
		JPanel pnTimKiem = new JPanel();
		JPanel pnBtns = new JPanel();

		pnNorth.add(pnTitle);
		pnNorth.add(pnMa);
		pnNorth.add(pnHoVaTen);
		pnNorth.add(pnTuoiVaPhai);
		pnNorth.add(pnLuong);
		pnSouth.add(pnTimKiem);
		pnSouth.add(pnBtns);

		lblTitle = new JLabel("ThÃ”NG TIN NHÃ‚N VIÃŠN");
		lblTitle.setFont(new Font(lblTitle.getFont().getName(), Font.PLAIN, 20));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setForeground(Color.blue);
		pnTitle.add(lblTitle);
		pnMa.add(new JLabel("MÃ£:"));
		pnMa.add(txfMa = new JTextField(50));
		pnHoVaTen.add(new JLabel("Há»�:"));
		pnHoVaTen.add(txfHo = new JTextField(25));
		pnHoVaTen.add(new JLabel("TÃªn:"));
		pnHoVaTen.add(txfTen = new JTextField(20));
		pnTuoiVaPhai.add(new JLabel("Tuá»•i:"));
		pnTuoiVaPhai.add(txfTuoi = new JTextField(40));
		pnTuoiVaPhai.add(new JLabel("PhÃ¡i:"));
		pnTuoiVaPhai.add(chkPhai = new JCheckBox("Nam/Ná»¯"));

		String[] cols = { "MÃ£ NV", "Há»�", "TÃªn", "PhÃ¡i", "Tuá»•i", "Tiá»�n LÆ°Æ¡ng" };
		dtfNhanVien = new DefaultTableModel(cols, 0);
		tbNhanVien = new JTable(dtfNhanVien);
		add(new JScrollPane(tbNhanVien), BorderLayout.CENTER);

		pnTimKiem.add(new JLabel("Nháº­p mÃ£ sá»‘ cáº§n tÃ¬m:"));
		pnTimKiem.add(txfTimKiem = new JTextField(10));
		pnTimKiem.add(btnTimKiem = new JButton("TÃ¬m"));
		pnTimKiem.setBorder(BorderFactory.createLineBorder(Color.black));
		pnBtns.add(btnThem = new JButton("ThÃªm"));
		pnBtns.add(btnXoaTrang = new JButton("XÃ³a tráº¯ng"));
		pnBtns.add(btnXoa = new JButton("XÃ³a"));
		pnBtns.add(btnLuu = new JButton("LÆ°u"));
		pnBtns.setBorder(BorderFactory.createLineBorder(Color.black));

	}

	private void DocDuLieuTuArrayListVaoModel() {
		// TODO Auto-generated method stub
		for (int i = 0; i < listNV.getSize(); i++) {
			NhanVien nv = listNV.getElement(i);
			dtfNhanVien.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.isPhai() ? "Nam" : "Ná»¯",
					nv.getTuoiNV(), nv.getTienLuong() + "$" });
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new QuanLiNhanVien_06_LeDinhBut().setVisible(true);

	}

}
