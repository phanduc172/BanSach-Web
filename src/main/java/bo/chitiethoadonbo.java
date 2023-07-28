package bo;

import dao.chitiethoadondao;

public class chitiethoadonbo {
	chitiethoadondao ctdao = new chitiethoadondao();
	public int ThemCTHD(String masach, long soluongmua, long mahoadon) throws Exception {
		return ctdao.Them(masach, soluongmua, mahoadon);
	}
}
