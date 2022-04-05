package quanLiSach_09_HoangVanCong;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachSach  implements Serializable {
	 private ArrayList<Sach> dsSach = new ArrayList<>();
	
	boolean themSach(Sach sach) {
		if(dsSach.contains(sach)) {
			return false;
		}else {
			return dsSach.add(sach);
		}
	}
	
	int getSize() {
		return dsSach.size();
	}
	
	
	boolean xoaSach(String maSach) {
		Sach sach = new Sach(maSach);
		return dsSach.remove(sach);
	}
	
	Sach timSach(String maSach) {
		int index = dsSach.indexOf(new Sach(maSach));
		if(index == -1) return null;
		return dsSach.get(index);
	}
	
	boolean capNhat(String maSachUpdate, Sach newSach) {
		int index = dsSach.indexOf(new Sach(maSachUpdate));
		if(index == -1) return false;
		
		dsSach.set(index, newSach);
		return true;
	}
	
	void clear() {
		dsSach = new ArrayList<>();
		return;
	}
	
	boolean contains(String maSach) {
		return dsSach.contains(new Sach(maSach));
	}

	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}

	
}
