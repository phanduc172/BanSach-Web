package bo;

import java.util.ArrayList;

import bean.xacnhanbean;
import dao.chitiethoadondao;

public class chitiethoadonbo {
	chitiethoadondao ctdao = new chitiethoadondao();
	public int ThemCTHD(String masach, long soluongmua, long mahoadon) throws Exception {
		return ctdao.Them(masach, soluongmua, mahoadon);
	}

	public int CapNhat(long machitiethoadon) throws Exception {
		return ctdao.CapNhat(machitiethoadon);
	}

	public ArrayList<xacnhanbean> gethoadonchuaxacnhan() throws Exception {
		return ctdao.gethoadonchuaxacnhan();
	}
}
