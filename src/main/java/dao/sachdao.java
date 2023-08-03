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

	public int themSach(String masach, String tensach, String tacgia, long gia, long soluong, String anh, String maloai) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "insert into sach(masach,tensach,tacgia,gia,soluong,anh,maloai) values (?,?,?,?,?,?,?)";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1, masach);
	    cmd.setString(2, tensach);
	    cmd.setString(3, tacgia);
	    cmd.setLong(4,gia);
	    cmd.setLong(5, soluong);
	    cmd.setString(6, anh);
	    cmd.setString(7, maloai);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int xoaSach(String masach) throws Exception {
	    KetNoidao kn = new KetNoidao();
	    kn.KetNoi();
	    String sql = "delete from sach where masach = ?";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1, masach);
	    int kq = cmd.executeUpdate();
	    cmd.close();
	    kn.cn.close();
	    return kq;
	}


	public int suaSach(String masach, String tensach, String tacgia, long gia, long soluong, String anh, String maloai) throws Exception {
	    KetNoidao kn = new KetNoidao();
	    kn.KetNoi();
	    String sql = "update sach set tensach=?, tacgia=?, gia=?, soluong=?, anh=?, maloai=? where masach=?";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1, tensach);
	    cmd.setString(2, tacgia);
	    cmd.setLong(3, gia);
	    cmd.setLong(4,soluong);
	    cmd.setString(5, anh);
	    cmd.setString(6, maloai);
	    cmd.setString(7, masach);
	    int kq = cmd.executeUpdate();
	    cmd.close();
	    kn.cn.close();
	    return kq;
	}

}
