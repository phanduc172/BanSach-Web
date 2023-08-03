package bo;

import java.util.ArrayList;

import bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao = new loaidao();
	ArrayList<loaibean> ds;

	public ArrayList<loaibean> getloai() throws Exception {
		ds = ldao.getloai();
		return ds;
	}

	public String timLoai(String maloai) throws Exception {
		for(loaibean l : ds)
			if(l.getMaloai().equals(maloai)) {
				return l.getTenloai();
			}
		return null;
	}

	public int themLoai(String maloai, String tenloai) throws Exception {
		for(loaibean l : ds)
			if(l.getMaloai().equals(maloai))
				return 0;
		return ldao.themLoai(maloai, tenloai);
	}

	public int xoaLoai(String maloai) throws Exception {
		return ldao.xoaLoai(maloai);
	}

	public int suaLoai(String maloai, String tenloaimoi) throws Exception {
		return ldao.suaLoai(maloai, tenloaimoi);
	}

}
