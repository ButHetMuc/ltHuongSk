package thiGiuaKi;

import java.io.Serializable;
import java.util.ArrayList;

public class DsNhanVien implements Serializable {
	
	ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
	
	public DsNhanVien() {
		
	}
	public DsNhanVien(ArrayList<NhanVien> dsnv) {
		super();
		this.dsnv = dsnv;
	}

	public ArrayList<NhanVien> getDsnv() {
		return dsnv;
	}

	public void setDsnv(ArrayList<NhanVien> dsnv) {
		this.dsnv = dsnv;
	}
	
	public boolean themNhanVien(NhanVien nv){
		if(dsnv.contains(nv)) 
			return false;
		return dsnv.add(nv);
	}
	public boolean xoaNhanVien (String maNv){
		if(dsnv.size()== 0)
			return false;
		NhanVien nv = new NhanVien(maNv);
		if(dsnv.contains(nv)) 
			return	dsnv.remove(nv);			
		return false;
	}
	public NhanVien timNhanVien(String maNv) {
		int index = dsnv.indexOf(new NhanVien(maNv));
		if(index == -1)
			return null;
		return dsnv.get(index);
	}
	public int getSize() {
		return dsnv.size();
	}
}
