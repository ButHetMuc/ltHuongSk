package quanLiSach_09_HoangVanCong;

import java.io.Serializable;
import java.util.Objects;

public class Sach implements Serializable {
	private String maSach;
	private String tuaSach;
	private String tacGia;
	private int namXuatBan;
	private String nhaXuatBan;
	private int soTrang;
	private double donGia;
	private String isbn;
	
	
	
	public Sach() {
		super();
	}
	public Sach(String maSach) {
		super();
		this.maSach = maSach;
	}
	public Sach(String maSach, String tuaSach, String tacGia, int namXuatBan, String nhaXuatBan, int soTrang,
			double donGia, String isbn) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.namXuatBan = namXuatBan;
		this.nhaXuatBan = nhaXuatBan;
		this.soTrang = soTrang;
		this.donGia = donGia;
		this.isbn = isbn;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTuaSach() {
		return tuaSach;
	}
	public void setTuaSach(String tuaSach) {
		this.tuaSach = tuaSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public String getNhaXuatBan() {
		return nhaXuatBan;
	}
	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSach);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}
	
	

}
