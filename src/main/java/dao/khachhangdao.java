package dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import bean.khachhangbean;

public class khachhangdao {
	public khachhangbean ktdn(String tendn,String pass) throws Exception {
		KetNoidao kn = new KetNoidao();
		kn.KetNoi();
		String sql = "select * from khachhang where tendn=? and pass=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, pass);
		ResultSet rs = cmd.executeQuery();
		khachhangbean kh = null;
		if(rs.next()) {
				long makh = Long.parseLong(rs.getString("makh"));
		        String hoten = rs.getString("hoten");
		        String diachi = rs.getString("diachi");
		        String sodt = rs.getString("sodt");
		        String email = rs.getString("email");
		        kh = new khachhangbean(makh, hoten, diachi, sodt, email, tendn, pass);
		}
		return kh;
	}

	public void addKhachHang(khachhangbean kh) throws Exception {
        KetNoidao kn = new KetNoidao();
        kn.KetNoi();
        String sql = "INSERT INTO khachhang(hoten, diachi, sodt, email, tendn, pass) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, kh.getHoten());
        cmd.setString(2, kh.getDiachi());
        cmd.setString(3, kh.getSodt());
        cmd.setString(4, kh.getEmail());
        cmd.setString(5, kh.getTendn());
        cmd.setString(6, kh.getPass());
        cmd.executeUpdate();
        kn.cn.close();
    }

	public boolean LuuThongTinKhachHang(khachhangbean khachHang) throws Exception {
	    KetNoidao kn = new KetNoidao();
	    kn.KetNoi();
	    String sql = "INSERT INTO khachhang (hoten, diachi, sodt, email, tendn, pass) VALUES (?, ?, ?, ?, ?, ?)";
	    PreparedStatement cmd = kn.cn.prepareStatement(sql);
	    cmd.setString(1, khachHang.getHoten());
	    cmd.setString(2, khachHang.getDiachi());
	    cmd.setString(3, khachHang.getSodt());
	    cmd.setString(4, khachHang.getEmail());
	    cmd.setString(5, khachHang.getTendn());
	    cmd.setString(6, khachHang.getPass());

	    // Thực hiện câu lệnh SQL để lưu thông tin vào CSDL
	    int rowCount = cmd.executeUpdate();
	    return rowCount > 0;
	}

}
