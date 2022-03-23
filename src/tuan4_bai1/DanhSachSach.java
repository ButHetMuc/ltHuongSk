package tuan4_bai1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DanhSachSach implements Serializable {
	List<Sach> dsSach = new ArrayList<Sach>();
	
	public DanhSachSach() {
		
	}

	public DanhSachSach(List<Sach> dsSach) {
		super();
		this.dsSach = dsSach;
	}
	
	public boolean themSach(Sach s) {
		if(dsSach.contains(s))
			return false;
		return dsSach.add(s);
	}
	public boolean xoaSach(String maSach) {
		if(dsSach.size()==0)
			return false;
		Sach s = new Sach(maSach);
		if(dsSach.contains(s))
			return dsSach.remove(s);
		return false;
	}
	
	public int getSize() {
		return dsSach.size();
	}
}
