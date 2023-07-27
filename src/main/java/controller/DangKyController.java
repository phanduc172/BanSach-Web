package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.khachhangbean;
import bo.khachhangbo;

/**
 * Servlet implementation class DangKyController
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
		String hoten = request.getParameter("hoten");
	    String diachi = request.getParameter("diachi");
	    String sodt = request.getParameter("sodt");
	    String email = request.getParameter("email");
	    String tendn = request.getParameter("tendn");
	    String pass = request.getParameter("pass");

	    // Gọi phương thức từ DAO để lưu thông tin vào CSDL
	    khachhangbean khachHang = new khachhangbean(0, hoten, diachi, sodt, email, tendn, pass);
	    khachhangbo khachHangBO = new khachhangbo();
	    boolean result = khachHangBO.DangKyKhachHang(khachHang);

	    // Kiểm tra kết quả và chuyển hướng tới trang thông báo đăng ký thành công hoặc thất bại
	    if (result) {
	        // Đăng ký thành công
	        response.sendRedirect("SachController");
	    } else {
	        // Đăng ký thất bại
	        response.sendRedirect("SachController?tb=DangNhapSai");
	    }
	}

}
