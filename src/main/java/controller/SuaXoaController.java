package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

/**
 * Servlet implementation class SuaXoaController
 */
@WebServlet("/SuaXoaController")
public class SuaXoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaXoaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        giohangbo gh = (giohangbo) session.getAttribute("gio");

        String masach = request.getParameter("ms");
        if (request.getParameter("btnxoa") != null) {
            gh.Xoa(masach);
        } else {
            long soluong = Long.parseLong(request.getParameter("txtsl"));
            gh.Sua(masach, soluong);
        }

        session.setAttribute("gio", gh);

        RequestDispatcher rd = request.getRequestDispatcher("HienThiGio.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
