package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.lichsumuabean;
import bean.loaibean;

public class test {
	public List<lichsumuabean> getLichSuMua() throws SQLException {
		ArrayList<lichsumuabean> lsm = new ArrayList<lichsumuabean>();

		//Kết nối vào csdl
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();;

		String sql = "select * from VLichSuMua";

		//B3 Tạp câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);

		//B4. Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();

		while(rs.next()) {
			long macthd = rs.getLong(1);
			long makh = rs.getLong(2);
			String hoten = rs.getString(3);
			String tensach = rs.getString(4);
			long gia = rs.getLong(5);
			long soluongmua = rs.getLong(6);
			String ngaymua = rs.getString(7);
			lsm.add(new lichsumuabean(makh, macthd, hoten, tensach, gia, soluongmua, ngaymua) );
		}
		rs.close();
		kn.cn.close();
		return lsm;
	}

	public static void main(String[] args) {
		lichsumuabean ls = new lichsumuabean();
		List<lichsumuabean> lsm = new ArrayList<lichsumuabean>();
		for (lichsumuabean lichsumuabean : lsm) {
			System.out.println(ls.getHoten() + "-" + ls.getNgaymua());
		}
	}

}


