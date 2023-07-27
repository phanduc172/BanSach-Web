package dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import bean.sachbean;

public class sachdao {
	public ArrayList<sachbean> getsach() throws Exception {
		ArrayList<sachbean> ds = new ArrayList<sachbean>();

		//Kết nối vào csdl
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();

		String sql = "select * from sach";

		//B3 Tạp câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		//B4. Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		while(rs.next()) {
			String masach = rs.getString("masach");
			String tensach = rs.getString("tensach");
			String tacgia = rs.getString("tacgia");
			long gia = Long.parseLong(rs.getString("gia"));
			long soluong = Long.parseLong(rs.getString("soluong"));
			String anh = rs.getString("anh");
			String maloai = rs.getString("maloai");
			ds.add(new sachbean(masach, tensach, tacgia, gia, soluong, anh, maloai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
