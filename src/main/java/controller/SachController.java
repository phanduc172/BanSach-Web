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
import bean.sachbean;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class SachController
 */
@WebServlet("/SachController")
public class SachController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SachController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// Đặt cấu hình gửi lên và lấy về bằng UTF-8
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");

			// Sai loaibo lấy về dsloai
			loaibo lbo = new loaibo();
			ArrayList<loaibean> dsloai = lbo.getloai();

			// Sai sachbo lấy về dssach
				// Lấy về ml và txttim tu htsach.jsp gửi lên
				String ml = request.getParameter("ml");
				String key = request.getParameter("txttim");
			sachbo sbo = new sachbo();
			ArrayList<sachbean> dssach = sbo.getsach();
			//Nếu ml!=null thì gọi hàm TimMa
			//Nếu key!=null thì gọi hàm Tim
				if(ml!=null) //Chọn tên loại
						dssach=sbo.timMa(ml);
					else
					if(key!=null)
						dssach=sbo.tim(key);

			// Chuyển dsloai và dssach về HienThiSach
			request.setAttribute("dsloai", dsloai);
			request.setAttribute("dssach", dssach);

			RequestDispatcher rd = request.getRequestDispatcher("HienThiSach.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
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
