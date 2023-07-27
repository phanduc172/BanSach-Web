package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.khachhangbean;
import bo.chitiethoadonbo;
import bo.giohangbo;
import bo.hoadonbo;

/**
 * Servlet implementation class XacNhanController
 */
@WebServlet("/XacNhanController")
public class XacNhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	HttpSession session = request.getSession();
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");

            khachhangbean kh = (khachhangbean)session.getAttribute("dn");
            if(kh==null) {
    			RequestDispatcher rd = request.getRequestDispatcher("SachController");
    			rd.forward(request, response);
            } else {
            	hoadonbo hdbo = new hoadonbo();
            	chitiethoadonbo ctbo = new chitiethoadonbo();
            	hdbo.Them(kh.getMakh());
            	long maxhd = hdbo.MaxHD();
            	giohangbo gh = (giohangbo)session.getAttribute("gh");
            	for(giohangbean h: gh.ds) {
            		ctbo.Them(h.getMasach(), h.getSoluong(), maxhd);
            	}
            	//Xóa giỏ hàng
            	session.removeAttribute("gh");
            	response.sendRedirect("LichSuMuaController");
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect("TrangLoi.jsp");
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
