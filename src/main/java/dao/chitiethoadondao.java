package dao;

import java.sql.PreparedStatement;

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
}
