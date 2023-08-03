package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.xacnhanbean;

public class chitiethoadondao {
	public int Them(String masach, long soluongmua, long mahoadon) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "INSERT INTO ChiTietHoaDon(MaSach,SoLuongMua,MaHoaDon,damua) VALUES(?,?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1,masach);
		cmd.setLong(2,soluongmua);
		cmd.setLong(3,mahoadon);
		cmd.setBoolean(4,false);

		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public int CapNhat(long machitiethoadon) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "update ChiTietHoaDon set damua = 1  where MaChiTietHD = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1,machitiethoadon);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public ArrayList<xacnhanbean> gethoadonchuaxacnhan() throws Exception {
		ArrayList<xacnhanbean> ds = new ArrayList<xacnhanbean>();
		//Kết nối vào csdl
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select * from VXacNhan";
		//B3 Tạo câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		//B4. Thực hiện câu lệnh
		ResultSet rs = cmd.executeQuery();
		while(rs.next()) {
			long makh = rs.getLong("makh");
			String hoten = rs.getString("hoten");
			String tensach= rs.getString("tensach");
			long gia = rs.getLong("gia");
			long MaChiTietHD = rs.getLong("MaChiTietHD");
			long SoLuongMua = rs.getLong("SoLuongMua");
			long thanhtien = rs.getLong("Thanhtien");
			boolean damua = rs.getBoolean("damua");
			ds.add(new xacnhanbean(makh,hoten,tensach,gia,MaChiTietHD,SoLuongMua,thanhtien,damua));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
