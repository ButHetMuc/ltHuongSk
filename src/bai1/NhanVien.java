package bai1;

import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String hoNV;
	private String tenNV;
	private boolean phai;
	private int tuoiNV;
	private double tienLuong;
	
	public NhanVien() {
		super();
	}
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	public NhanVien(String maNV, String hoNV, String tenNV, boolean phai, int tuoiNV, double tienLuong) {
		super();
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.phai = phai;
		this.tuoiNV = tuoiNV;
		this.tienLuong = tienLuong;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoNV() {
		return hoNV;
	}
	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public boolean isPhai() {
		return phai;
	}
	public void setPhai(boolean phai) {
		this.phai = phai;
	}
	public int getTuoiNV() {
		return tuoiNV;
	}
	public void setTuoiNV(int tuoiNV) {
		this.tuoiNV = tuoiNV;
	}
	public double getTienLuong() {
		return tienLuong;
	}
	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
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
		return Objects.equals(maNV, other.maNV);
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoNV=" + hoNV + ", tenNV=" + tenNV + ", phai=" + phai + ", tuoiNV="
				+ tuoiNV + ", tienLuong=" + tienLuong + "]";
	}
	
	public Object toArray() {
		Object[] arr = {this.maNV, this.hoNV, this.tenNV, this.tuoiNV, this.tienLuong};
		return arr;
	}

}
