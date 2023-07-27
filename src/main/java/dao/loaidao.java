package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.loaibean;

public class loaidao {
	public ArrayList<loaibean> getloai() throws Exception {
		ArrayList<loaibean> ds = new ArrayList<loaibean>();

		//Kết nối vào csdl
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();;

		String sql = "select * from loai";

		//B3 Tạp câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		//B4. Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		while(rs.next()) {
			String maloai = rs.getString("maloai");
			String tenloai = rs.getString("tenloai");
			ds.add(new loaibean(maloai,tenloai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
