package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GioHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String masach = request.getParameter("ms");
		String tensach = request.getParameter("ts");
		String giaStr = request.getParameter("gia");
		long gia = 0;

		giohangbo gh;
		if (session.getAttribute("gio") == null) { //neu mua lan dau
			  gh = new giohangbo();
			  session.setAttribute("gio", gh);//cap phat gio
		}

		if(masach!=null && tensach!=null && giaStr!=null) {
			gia = Long.parseLong(giaStr);
			//b1: gan sesion vao bien
			gh = (giohangbo) session.getAttribute("gio");
			//b2: thao tac tren bien
			gh.Them(masach, tensach, gia, (long)1);
			//b3: luu bien vao sesion

			session.setAttribute("gio", gh);
			session.setAttribute("slsp", gh.ds.size());

//			RequestDispatcher rd = request.getRequestDispatcher("HienThiGio.jsp");
//			rd.forward(request, response);
			response.sendRedirect("HienThiGioController");

		} else {
//			RequestDispatcher rd = request.getRequestDispatcher("HienThiGio.jsp");
//			rd.forward(request, response);
			response.sendRedirect("HienThiGioController");
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
