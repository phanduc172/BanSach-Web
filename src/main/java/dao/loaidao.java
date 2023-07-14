package dao;

import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai() throws Exception {
		ArrayList<loaibean> ds = new ArrayList<loaibean>();
		//Tạo thủ công 4 loại
		ds.add(new loaibean("tin","Công nghệ thông tin"));
		ds.add(new loaibean("toan","Toán học"));
		ds.add(new loaibean("ly","Vật lý"));
		ds.add(new loaibean("su","Lịch sử"));
		return ds;
	}
}
