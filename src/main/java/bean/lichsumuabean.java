package bean;

public class lichsumuabean {
	private long makh;
    private long macthd;
    private String hoten;
    private String tensach;
    private long gia;
    private long soluongmua;
    private String ngaymua;

	public long getMakh() {
		return makh;
	}

	public void setMakh(long makh) {
		this.makh = makh;
	}

	public lichsumuabean() {
		super();
	}

	public lichsumuabean(long makh, long macthd, String hoten, String tensach, long gia, long soluongmua,
			String ngaymua) {
		super();
		this.makh = makh;
		this.macthd = macthd;
		this.hoten = hoten;
		this.tensach = tensach;
		this.gia = gia;
		this.soluongmua = soluongmua;
		this.ngaymua = ngaymua;
	}

	public long getMacthd() {
		return macthd;
	}
	public void setMacthd(long macthd) {
		this.macthd = macthd;
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
