package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.loaibean;
import bo.loaibo;

/**
 * Servlet implementation class AdminLoaiController
 */
@WebServlet("/AdminLoaiController")
public class AdminLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			loaibo lbo = new loaibo();

			String tab= request.getParameter("tab");
			String ml= request.getParameter("txtmaloai");
			String tenloai=request.getParameter("txttenloai");
			ArrayList<loaibean> ds= lbo.getloai();
			if(request.getParameter("butadd")!=null) {
				lbo.themLoai(tenloai, tenloai);
			} else if(request.getParameter("butupdate")!=null) {
				lbo.suaLoai(ml, tenloai);
			} else {
				String maloai=request.getParameter("ml");
				if(tab!=null&&tab.equals("xoa"))
					lbo.xoaLoai(maloai);
				else if (tab!=null&&tab.equals("chon")) {
					request.setAttribute("ml", maloai);
					request.setAttribute("tenloai", lbo.themLoai(maloai, tenloai));
				}
			}
			request.setAttribute("dsloai", lbo.getloai());
			RequestDispatcher rd = request.getRequestDispatcher("AdminLoai.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
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
