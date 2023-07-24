package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class tam
 */
@WebServlet("/tam")
public class tam extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public tam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Tạo đối tượng out
//		PrintWriter out = response.getWriter();
//		out.print("<html><body>Alo</body></html>");

		//Tạo đội tượng session
		HttpSession session = request.getSession();
		session.setAttribute("tam", "Xin chào");
		//Tạo ra biến request để chuyển về jsp
		request.setAttribute("a", (long)15);
		request.setAttribute("b", "Hà Nội");
		String[] dsht = {"Thu","Lan","Diep","Le"};
		request.setAttribute("ds", dsht);

//		Chuyển tiếp đối tượng request và response về trang t1.jsp
		RequestDispatcher rd = request.getRequestDispatcher("t1.jsp?kt=1");
		rd.forward(request, response);
//		response.sendRedirect("t1.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
