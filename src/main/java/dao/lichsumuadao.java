package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.lichsumuabean;

public class lichsumuadao {
    public List<lichsumuabean> getLichSuMua(long makh) throws Exception {
        KetNoidao kn = new KetNoidao();
        kn.KetNoi();
        String sql = "SELECT dbo.ChiTietHoaDon.MaChiTietHD, dbo.hoadon.makh, dbo.KhachHang.hoten, dbo.sach.tensach, dbo.sach.gia, dbo.ChiTietHoaDon.SoLuongMua, dbo.hoadon.NgayMua, dbo.ChiTietHoaDon.damua FROM   dbo.ChiTietHoaDon INNER JOIN dbo.hoadon ON dbo.ChiTietHoaDon.MaHoaDon = dbo.hoadon.MaHoaDon INNER JOIN dbo.KhachHang ON dbo.hoadon.makh = dbo.KhachHang.makh INNER JOIN dbo.sach ON dbo.ChiTietHoaDon.MaSach = dbo.sach.masach WHERE hoadon.makh = ? ORDER BY NgayMua DESC";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setLong(1, makh);

        ResultSet rs = cmd.executeQuery();
        ArrayList<lichsumuabean> listlsm = new ArrayList<>();
        while (rs.next()) {
        	long macthd = Long.parseLong(rs.getString("macthd"));
        	String hoten = rs.getString("hoten");
        	String tensach = rs.getString("tensach");
        	long soluongmua = rs.getLong("soluongmua");
        	long gia = rs.getLong("gia");
        	String ngaymua = rs.getString("ngaymua");
            lichsumuabean lsmua = new lichsumuabean(makh, macthd, hoten, tensach, soluongmua, gia, ngaymua);
            listlsm.add(lsmua);
        }
        return listlsm;
    }
}



