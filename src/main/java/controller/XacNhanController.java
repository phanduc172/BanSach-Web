package controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.khachhangbean;
import bean.lichsumuabean;
import bo.chitiethoadonbo;
import bo.giohangbo;
import bo.hoadonbo;
import bo.lichsumuabo;

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

            khachhangbean kh = (khachhangbean) session.getAttribute("ktdn");
            if(kh==null) {
            	response.sendRedirect("SachController");
            } else {
            	giohangbo gh = (giohangbo)session.getAttribute("gio");
            	if(gh!=null) {
            		hoadonbo hdbo = new hoadonbo();
                	chitiethoadonbo ctbo = new chitiethoadonbo();
                	hdbo.Them(kh.getMakh());
                	long maxhd = hdbo.MaxHD();
                	for(giohangbean h: gh.ds) {
                		ctbo.ThemCTHD(h.getMasach(), h.getSoluong(), maxhd);
                	}
                	//Xóa giỏ hàng
                	session.removeAttribute("gio");
                	// Khai báo và khởi tạo biến lsmBo
                    lichsumuabo lsmbo = new lichsumuabo();
                	List<lichsumuabean> listLsm = lsmbo.getLichSuMua(kh.getMakh());
                    session.setAttribute("listLsm", listLsm);
                	RequestDispatcher rd = request.getRequestDispatcher("LichSuMua.jsp");
                    rd.forward(request, response);
            	}
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
			response.sendRedirect("LichSuMuaController");
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
