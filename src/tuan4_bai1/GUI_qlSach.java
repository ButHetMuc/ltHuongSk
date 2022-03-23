package tuan4_bai1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
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

public class GUI_qlSach extends JFrame {
	private JTextField txtMaSach;
	private JTextField txtTuaSach;
	private JTextField txtNamXuatBan;
	private JTextField txtSoTrang;
	private JTextField txtISBN;
	private JTextField txtTacGia;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoaRong;
	private JButton btnXoa;
	private JComboBox<String> cboSelectMa;
	private DefaultTableModel dftblSach;
	private JTable tblSach;
	private JTextField txtNhaxuatBan;
	private JTextField txtDonGia;
	private DanhSachSach listSach;

	public GUI_qlSach() {
		super("quan li sach");
		setSize(800,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		JPanel pnTop = new JPanel();
		JPanel pnMid = new JPanel();
		JPanel pnBot = new JPanel();
		this.add(pnTop);
		this.add(pnMid);
		this.add(pnBot);
		
		pnTop.setBorder(BorderFactory.createTitledBorder("record editer"));
		pnBot.setBorder(BorderFactory.createTitledBorder("danh sach"));
		
		FlowLayout layoutPnTop = (FlowLayout) pnTop.getLayout();
		layoutPnTop.setAlignment(FlowLayout.LEFT);
		FlowLayout layoutPnBot = (FlowLayout) pnTop.getLayout();
		layoutPnBot.setAlignment(FlowLayout.LEFT);
		
		JPanel pnTopR = new JPanel();
		//pnTopR.setBorder(BorderFactory.createLineBorder(Color.black));
		pnTopR.setLayout(new BoxLayout(pnTopR,BoxLayout.Y_AXIS));
		JPanel pnMaSach = new JPanel();
		JLabel lblMaSach = new JLabel("Ma sach");
		lblMaSach.setPreferredSize(new Dimension(115, 14));
		txtMaSach = new JTextField(25);
		//txtMaSach.setEditable(false);
		pnMaSach.add(lblMaSach);
		pnMaSach.add(txtMaSach);
		pnTopR.add(pnMaSach);
		
		JPanel pnTuaSach = new JPanel();
		JLabel lblTuaSach = new JLabel("Tua sach");
		lblTuaSach.setPreferredSize(new Dimension(115, 14));
		txtTuaSach = new JTextField(25);
		
		pnTuaSach.add(lblTuaSach);
		pnTuaSach.add(txtTuaSach);
		pnTopR.add(pnTuaSach);

		JPanel pnNamXuatBan = new JPanel();
		JLabel lblNamXuatBan = new JLabel("Nam xuat ban");
		lblNamXuatBan.setPreferredSize(new Dimension(115, 14));
		txtNamXuatBan = new JTextField(25);
		pnNamXuatBan.add(lblNamXuatBan);
		pnNamXuatBan.add(txtNamXuatBan);
		pnTopR.add(pnNamXuatBan);
		
		JPanel pnSoTrang = new JPanel();
		JLabel lblSoTrang = new JLabel("So trang");
		lblSoTrang.setPreferredSize(new Dimension(115, 14));
		txtSoTrang= new JTextField(25);
		pnSoTrang.add(lblSoTrang);
		pnSoTrang.add(txtSoTrang);
		pnTopR.add(pnSoTrang);
		
		JPanel pnISBN = new JPanel();
		JLabel lblISBN = new JLabel("international-ISBN");
		lblISBN.setPreferredSize(new Dimension(115, 14));
		txtISBN= new JTextField(25);
		pnISBN.add(lblISBN);
		pnISBN.add(txtISBN);
		pnTopR.add(pnISBN);
		
		JPanel pnTopL = new JPanel();
		//pnTopL.setBorder(BorderFactory.createLineBorder(Color.black));
		pnTopL.setLayout(new BoxLayout(pnTopL,BoxLayout.Y_AXIS));
		
		JPanel pnTacGia= new JPanel();
		JLabel lblTacGia= new JLabel("Tac gia");
		lblTacGia.setPreferredSize(new Dimension(115, 14));
		txtTacGia= new JTextField(25);
		pnTacGia.add(lblTacGia);
		pnTacGia.add(txtTacGia);
		pnTopL.add(pnTacGia);
		
		JPanel pnNhaXuatBan = new JPanel();
		JLabel lblNhaXuatBan= new JLabel("Nha xuat ban");
		lblNhaXuatBan.setPreferredSize(new Dimension(115, 14));
		txtNhaxuatBan= new JTextField(25);
		
		pnNhaXuatBan.add(lblNhaXuatBan);
		pnNhaXuatBan.add(txtNhaxuatBan);
		pnTopL.add(pnNhaXuatBan);

		JPanel pnDonGia= new JPanel();
		JLabel lblDonGia = new JLabel("Don gia");
		lblDonGia.setPreferredSize(new Dimension(115, 14));
		txtDonGia= new JTextField(25);
		pnDonGia.add(lblDonGia);
		pnDonGia.add(txtDonGia);
		pnTopL.add(pnDonGia);
//		
		
		pnTop.add(pnTopR);
		pnTop.add(pnTopL);
		
		btnThem = new JButton("Them");
		btnSua = new JButton("Sua");
		btnXoa = new JButton("Xoa");
		btnXoaRong = new JButton("Xoa rong");
		
		pnMid.add(btnThem);
		pnMid.add(btnSua);
		pnMid.add(btnXoa);
		pnMid.add(btnXoaRong);
		
		String[] arr = {"A001","A002","A003"};
		cboSelectMa = new JComboBox<String>(arr);
		pnMid.add(new JLabel("\t Tim theo ma:"));
		pnMid.add(cboSelectMa);
		
		pnBot.setLayout(new BorderLayout());
		
		
		String[] cols = {"Ma sach","Tua sach","Tac gia","Nam xuat ban","Nha xuat ban","So trang","Don gia","ISBN"};
		dftblSach = new DefaultTableModel(cols, 0);
		
		tblSach = new JTable(dftblSach);
		JScrollPane srctblSach = new JScrollPane(tblSach,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnBot.add(srctblSach,BorderLayout.CENTER);
		
		addEvents();
	}
	
	private void addEvents() {
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String maS = txtMaSach.getText();
				String tuaS = txtTuaSach.getText();
				String namXb = txtNamXuatBan.getText();
				String sotrang = txtSoTrang.getText();
				String isbn = txtISBN.getText();
				String tacgia = txtTacGia.getText();
				String nhaXb= txtNhaxuatBan.getText();
				String donGia = txtDonGia.getText();
				
				int namxb,soTr;
				double gia;
				
				if(maS.equals("")||tuaS.equals("")||
						namXb.equals("")||sotrang.equals("")||isbn.equals("")
						||tacgia.equals("")||nhaXb.equals("")||donGia.equals("")) {
					JOptionPane.showMessageDialog(null, "chua nhap du");
					return;
				}
				
				try {
					namxb = Integer.parseInt(namXb);
					soTr = Integer.parseInt(sotrang);
					gia = Double.parseDouble(donGia);
				} catch (NumberFormatException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "'nam xuat ban, so trang, don gia' phai la so!");
					return;
				}
				listSach = new DanhSachSach();
				Sach s = new Sach(maS, tuaS, tacgia, namxb, nhaXb, soTr, gia, isbn);
				if(listSach.themSach(s)) {
					JOptionPane.showMessageDialog(null, "them Sach thanh cong!");
				}
				else {
					JOptionPane.showMessageDialog(null, "co loi xay ra!");
					return;
				}
				Object[] sach = {s.getMaSach(),s.getTuaSach(),s.getTacGiaSach(),
						s.getNamXuatBan(),s.getNhaXuatBan(),s.getSoTrang(),s.getDonGia(),s.getISBN()};
				dftblSach.addRow(sach);
			}
		});
		
	}

	public static void main(String[] args) {
		GUI_qlSach gui = new GUI_qlSach();
		gui.setVisible(true);
	}
}
