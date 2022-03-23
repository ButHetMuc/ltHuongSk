package bai1;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class DanhSachNhanVien {
	ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
	
	public boolean themNhanVien(NhanVien nv) {
		if(dsNhanVien.contains(nv)) return false;
		return dsNhanVien.add(nv);
	}
	
	public boolean xoaNhanVien(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(dsNhanVien.contains(nv)) return dsNhanVien.remove(nv);
		return false;
	}
	
	public NhanVien timKiem(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		int index = dsNhanVien.indexOf(nv);
		if(index != -1) return dsNhanVien.get(index);
		return null;
	}
	
//	public Object[][] toArray() {
//		for(NhanVien nv: dsNhanVien) {
//			
//		}
//	}
	public int getSize() {
		
		return dsNhanVien.size();
	}
	
	public NhanVien getElement(int index) {
		if(index != -1) return dsNhanVien.get(index);
		return null;
		
		
	}
	

}
