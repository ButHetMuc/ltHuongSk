package thiGiuaKi;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable {
	private String maNV;
	private String tenNV;
	private String hoNV;
	private int tuoiNV;
	private boolean gioiTinh;
	private double tienLuong;
	
	public NhanVien(String maNV, String tenNV, String hoNV, int tuoiNV,boolean gioiTinh, double tienLuong) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.hoNV = hoNV;
		this.tuoiNV = tuoiNV;
		this.gioiTinh = gioiTinh;
		this.tienLuong = tienLuong;
	}

	public NhanVien() {
		super();
	}

	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
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
	
	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
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
}
