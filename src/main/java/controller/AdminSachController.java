package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.sachbean;
import bo.sachbo;

/**
 * Servlet implementation class AdminSachController
 */
@WebServlet("/AdminSachController")
public class AdminSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");

            sachbo sbo = new sachbo();
            ArrayList<sachbean> ds = sbo.getsach();

            String tab = request.getParameter("tab");
            String ms = request.getParameter("txtmasach");
            String tensach = request.getParameter("txttensach");
            String tacgia = request.getParameter("txttacgia");
            long gia = 0;
            long soluong = 0;
            String anh = request.getParameter("txtanh");
            String maloai = request.getParameter("txtmaloai");

            // Kiểm tra và chuyển đổi các tham số sang kiểu dữ liệu hợp lệ
            if (request.getParameter("txtgia") != null) {
                gia = Long.parseLong(request.getParameter("txtgia"));
            }
            if (request.getParameter("txtsoluong") != null) {
                soluong = Long.parseLong(request.getParameter("txtsoluong"));
            }

            if (request.getParameter("butaddsach") != null) {
                sbo.themSach(ms, tensach, tacgia, gia, soluong, anh, maloai);
            } else if (request.getParameter("butupdatesach") != null) {
                sbo.suaSach(ms, tensach, tacgia, gia, soluong, anh, maloai);
            } else {
                String masach = request.getParameter("ms");
                if (tab != null && tab.equals("xoasach")) {
                    sbo.xoaSach(masach);
                } else if (tab != null && tab.equals("chonsach")) {
                    request.setAttribute("ms", masach);
                    request.setAttribute("tensach", sbo.themSach(masach, tensach, tacgia, gia, soluong, anh, maloai));
                }
            }

            request.setAttribute("dssach", sbo.getsach());
            RequestDispatcher rd = request.getRequestDispatcher("AdminSach.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
