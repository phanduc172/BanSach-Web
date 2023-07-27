package bo;

import bean.khachhangbean;
import dao.khachhangdao;

public class khachhangbo {
	khachhangdao khdao = new khachhangdao();
	public khachhangbean DangNhapController(String tendn, String pass) throws Exception {
		return khdao.ktdn(tendn, pass);
	}


	public boolean DangKyKhachHang(khachhangbean khachHang) {
	    khachhangdao khdao = new khachhangdao();
	    try {
	        // Gọi phương thức từ DAO để lưu thông tin vào CSDL
	        // Trả về kết quả để xử lý
	        return khdao.LuuThongTinKhachHang(khachHang);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
