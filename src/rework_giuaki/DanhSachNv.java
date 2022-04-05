package rework_giuaki;

import java.util.ArrayList;
import java.util.List;

import thiGiuaKi.DsNhanVien;

public class DanhSachNv {
	
	private List<NhanVien> listNhanVien = new ArrayList<NhanVien>();
	

	public DanhSachNv() {
		super();
	}

	public DanhSachNv(List<NhanVien> listNhanVien) {
		super();
		this.listNhanVien = listNhanVien;
	}
	
	
	
	public List<NhanVien> getListNhanVien() {
		return listNhanVien;
	}

	public void setListNhanVien(List<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}

	public int getSize() {
		return listNhanVien.size();
	}
	
	public boolean themNhanVien(NhanVien nv) {
		if(listNhanVien.contains(nv)) 
			return false;
		return listNhanVien.add(nv);	
	}
	public boolean xoaNhanVien(String ma) {
		if(listNhanVien.size() == 0)
			return false;
		NhanVien nv = new NhanVien(ma);
		if(listNhanVien.contains(nv))
			listNhanVien.remove(nv);
		return true;
	}
	public NhanVien timNhanVien(String ma) {
		NhanVien nv = new NhanVien(ma);
		int index = listNhanVien.indexOf(nv);
		if(index == -1 )
			return null;	
		return listNhanVien.get(index);

	}
	

}
