package tuan4_bai1;

import java.io.Serializable;
import java.util.Objects;

public class Sach implements Serializable{
	private String maSach;
	private String tuaSach;
	private String tacGiaSach;
	private int namXuatBan;
	private String nhaXuatBan;
	private int soTrang;
	private double donGia;
	private String ISBN;
	public Sach(String maSach, String tuaSach, String tacGiaSach, int namXuatBan, String nhaXuatBan, int soTrang,
			double donGia, String iSBN) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGiaSach = tacGiaSach;
		this.namXuatBan = namXuatBan;
		this.nhaXuatBan = nhaXuatBan;
		this.soTrang = soTrang;
		this.donGia = donGia;
		ISBN = iSBN;
	}
	
	public Sach() {
		super();
	}
	
	public Sach(String maSach) {
		super();
		this.maSach = maSach;
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

	public String getTacGiaSach() {
		return tacGiaSach;
	}

	public void setTacGiaSach(String tacGiaSach) {
		this.tacGiaSach = tacGiaSach;
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

	public String getISBN() {
		return ISBN;
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

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
}
