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
		kn.KetNoi();

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

	public int themLoai(String maloai, String tenloai) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "insert into loai(maloai, tenloai) values (?,?)";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1, maloai);
	    cmd.setString(2, tenloai);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int xoaLoai(String maloai) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "delete from loai where maloai = ? ";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1, maloai);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int suaLoai(String maloai, String tenloaimoi) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "update loai set tenloai= ? where maloai = ? ";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1,tenloaimoi);
	    cmd.setString(2,maloai);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

}
