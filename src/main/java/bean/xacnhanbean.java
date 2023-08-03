package bean;

public class xacnhanbean {
	private long makh;
	private String hoten;
	private String tensach;
	private long gia;
	private long MaChiTietHD;
	private long SoLuongMua;
	private long Thanhtien;
	private boolean damua;
	public xacnhanbean() {
		super();
	}
	public xacnhanbean(long makh, String hoten, String tensach, long gia, long maChiTietHD, long soLuongMua,
			long thanhtien, boolean damua) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.tensach = tensach;
		this.gia = gia;
		MaChiTietHD = maChiTietHD;
		SoLuongMua = soLuongMua;
		Thanhtien = thanhtien;
		this.damua = damua;
	}
	public long getMakh() {
		return makh;
	}
	public void setMakh(long makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	public long getMaChiTietHD() {
		return MaChiTietHD;
	}
	public void setMaChiTietHD(long maChiTietHD) {
		MaChiTietHD = maChiTietHD;
	}
	public long getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public long getThanhtien() {
		return Thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		Thanhtien = thanhtien;
	}
	public boolean isDamua() {
		return damua;
	}
	public void setDamua(boolean damua) {
		this.damua = damua;
	}

}
