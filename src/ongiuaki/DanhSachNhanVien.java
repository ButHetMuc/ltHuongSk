package ongiuaki;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DanhSachNhanVien implements Serializable {
	
	private List<NhanVien > dsnv = new ArrayList<NhanVien>();

	public DanhSachNhanVien() {
		super();
	}

	public DanhSachNhanVien(List<NhanVien> dsnv) {
		super();
		this.dsnv = dsnv;
	}
	
	public List<NhanVien> getDsnv() {
		return dsnv;
	}

	public void setDsnv(List<NhanVien> dsnv) {
		this.dsnv = dsnv;
	}
	
	public int getSize() {
		return dsnv.size();
	}

	public boolean themNhanVien(NhanVien nv) {
		if(dsnv.contains(nv))
			return false;
		else
			dsnv.add(nv);
		return true;
	}
	public boolean xoaNhanVien(String maNv) {
		if(dsnv.size() == 0)
			return false;
		NhanVien nv = new NhanVien(maNv);
		if(dsnv.contains(nv))
			return dsnv.remove(nv);
		return false;
	}
	public boolean suaNhanVien(NhanVien nv ) {
		int index = dsnv.indexOf(nv);	
		if(index == -1)
			return false;
		dsnv.set(index, nv);
		return true;	
	}
	public NhanVien timNhanVien (String maNv) {
		if(dsnv.size() ==0)
			return null;
		NhanVien nv = new NhanVien(maNv);
		int index = dsnv.indexOf(nv);
		if(index == -1)
			return null;
		return dsnv.get(index);
	}
}
