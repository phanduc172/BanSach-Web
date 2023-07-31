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

import bean.khachhangbean;
import bean.lichsumuabean;
import bo.lichsumuabo;

@WebServlet("/LichSuMuaController")
public class LichSuMuaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LichSuMuaController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");

            // Kiểm tra đăng nhập
            khachhangbean kh = (khachhangbean) session.getAttribute("ktdn");
            if (kh == null) {
                RequestDispatcher rd = request.getRequestDispatcher("SachController");
   				rd.forward(request, response);
//                response.sendRedirect("SachController");
            } else {
                // Lấy mã khách hàng từ session
                long makh = kh.getMakh();

                lichsumuabo lsmBo = new lichsumuabo();
                List<lichsumuabean> listLsm = lsmBo.getLichSuMua(makh);

                session.setAttribute("listLsm", listLsm);

                RequestDispatcher rd = request.getRequestDispatcher("LichSuMua.jsp");
   				rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            response.sendRedirect("TrangLoi.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
