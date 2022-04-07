package KT1_HoTenSinhVien_MSSV_de4;


public class NhanVien {

	private String maNV;
	private String hoTen;
	private String diaChi;
	private double heSoLuong;
	private String Email;
	
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}
	public NhanVien(String maNV) {
		this.maNV = maNV;
	}	
	
	public NhanVien(String maNV, String hoTen, String diaChi, double heSoLuong, String email) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.heSoLuong = heSoLuong;
		Email = email;
	}
	
	
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public double getHeSoLuong() {
		return heSoLuong;
	}
	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
		return result;
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
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", heSoLuong=" + heSoLuong
				+ ", Email=" + Email + "]";
	}
	
	
	
}
