package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hoadondao {
	public int Them(long makh) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "INSERT INTO hoadon(makh,NgayMua,damua) VALUES(?,?,?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1,makh);
		//Lấy ngày hien tại
		Date n = new Date();
		SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		String nn = dd.format(n);
		Date n2 = dd.parse(nn);
		cmd.setDate(2,new java.sql.Date(n2.getTime()));
		cmd.setBoolean(3,false);
		int kq = cmd.executeUpdate();
		cmd.close();
		kn.cn.close();
		return kq;
	}

	public long MaxHD() throws Exception  {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select MAX(MaHoaDon) as HDLN from hoadon";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long max = 0;
		if(rs.next()) {
			max = rs.getLong(1);
		}
		cmd.close();
		kn.cn.close();
		return max;
	}
}
