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
 * Servlet implementation class XoaTatCaController
 */
@WebServlet("/XoaTatCaController")
public class XoaTatCaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaTatCaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        giohangbo gh;
		gh = (giohangbo) session.getAttribute("gio");

		if (gh != null) {
            gh.ds.clear(); // Xóa tất cả sản phẩm trong giỏ hàng
            session.setAttribute("gio", gh); // Cập nhật lại giỏ hàng trong session
            session.setAttribute("slsp", 0); // Cập nhật số lượng sản phẩm trong giỏ hàng thành 0
        }

        // Chuyển hướng đến trang hiển thị giỏ hàng
        response.sendRedirect("SachController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
