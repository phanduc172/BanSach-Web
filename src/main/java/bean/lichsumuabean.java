package bean;

public class lichsumuabean {
	private long MaChiTietHD;
	private long makh;
    private String hoten;
    private String tensach;
    private long gia;
    private long soluongmua;
    private String ngaymua;
	public lichsumuabean() {
		super();
	}
	public lichsumuabean(long MaChiTietHD, long makh, String hoten, String tensach, long gia, long soluongmua,
			String ngaymua) {
		super();
		this.MaChiTietHD = MaChiTietHD;
		this.makh = makh;
		this.hoten = hoten;
		this.tensach = tensach;
		this.gia = gia;
		this.soluongmua = soluongmua;
		this.ngaymua = ngaymua;
	}
	public long getMacthd() {
		return MaChiTietHD;
	}
	public void setMacthd(long MaChiTietHD) {
		this.MaChiTietHD = MaChiTietHD;
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
	public long getSoluongmua() {
		return soluongmua;
	}
	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}
	public String getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(String ngaymua) {
		this.ngaymua = ngaymua;
	}


}
