package rework_giuaki;

import java.util.Objects;

public class NhanVien {
	private String maNv;
	private String tenNv;
	private String hoNv;
	private boolean gioiTinh;
	private int phongBan;
	private double luongNv;
	
	public NhanVien() {
		super();
	}

	public NhanVien(String maNv, String tenNv, String hoNv, boolean gioiTinh, int phongBan, double luongNv) {
		super();
		this.maNv = maNv;
		this.tenNv = tenNv;
		this.hoNv = hoNv;
		this.gioiTinh = gioiTinh;
		this.phongBan = phongBan;
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

	public String getTenNv() {
		return tenNv;
	}

	public void setTenNv(String tenNv) {
		this.tenNv = tenNv;
	}

	public String getHoNv() {
		return hoNv;
	}

	public void setHoNv(String hoNv) {
		this.hoNv = hoNv;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public int getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(int phongBan) {
		this.phongBan = phongBan;
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

	@Override
	public String toString() {
		return "NhanVien" + maNv  + tenNv +  hoNv + gioiTinh
			 + phongBan  + luongNv ;
	}
}
