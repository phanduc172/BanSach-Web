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
        String sql = "select * from VLichSuMua where makh = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setLong(1, makh);
        ResultSet rs = cmd.executeQuery();
        ArrayList<lichsumuabean> listlsm = new ArrayList<>();
        while (rs.next()) {
        	 long macthd = rs.getLong("macthd");
             String hoten = rs.getString("hoten");
             String tensach = rs.getString("tensach");
             long gia = rs.getLong("gia");
             long soluongmua = rs.getLong("soluongmua");
             String ngaymua = rs.getString("ngaymua");

             lichsumuabean lsm = new lichsumuabean(macthd, makh, hoten, tensach, gia, soluongmua, ngaymua);
             listlsm.add(lsm);
        }
        return listlsm;
    }
}



