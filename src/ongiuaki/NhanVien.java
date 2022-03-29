package ongiuaki;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable{
	private String maNv;
	private String hoNv;
	private String tenNv;
	private int tuoiNv;
	private boolean gioiTinhNv;
	private int phongBanNv;
	private double luongNv;
	
	
	
	public NhanVien() {
		super();
	}

	public NhanVien(String maNv, String hoNv, String tenNv, int tuoiNv, boolean gioiTinhNv, int phongBanNv,
			double luongNv) {
		super();
		this.maNv = maNv;
		this.hoNv = hoNv;
		this.tenNv = tenNv;
		this.tuoiNv = tuoiNv;
		this.gioiTinhNv = gioiTinhNv;
		this.phongBanNv = phongBanNv;
		this.luongNv = luongNv;
	}

	public NhanVien(String maNv) {
		super();
		this.maNv = maNv;
	}

	public String getMaNv() {
		return maNv;
	}

	public void setMaNv(String maNv) {
		this.maNv = maNv;
	}

	public String getHoNv() {
		return hoNv;
	}

	public void setHoNv(String hoNv) {
		this.hoNv = hoNv;
	}

	public String getTenNv() {
		return tenNv;
	}

	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}

	public int getTuoiNv() {
		return tuoiNv;
	}

	public void setTuoiNv(int tuoiNv) {
		this.tuoiNv = tuoiNv;
	}

	public boolean isNvNu() {
		return gioiTinhNv;
	}

	public void setGioiTinhNv(boolean gioiTinhNv) {
		this.gioiTinhNv = gioiTinhNv;
	}

	public int getPhongBanNv() {
		return phongBanNv;
	}

	public void setPhongBanNv(int phongBanNv) {
		this.phongBanNv = phongBanNv;
	}

	public double getLuongNv() {
		return luongNv;
	}

	public void setLuongNv(double luongNv) {
		this.luongNv = luongNv;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNv, other.maNv);
	}
	
	

}
