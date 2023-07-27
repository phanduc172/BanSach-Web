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

import bean.lichsumuabean;
import dao.lichsumuadao;

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

            // Lấy mã khách hàng từ session (bạn có thể thay thế bằng cách truyền mã khách hàng từ nguồn khác)
            long makh = (long) session.getAttribute("makh");

            // Lấy danh sách lịch sử mua hàng từ database
            lichsumuadao lsmDao = new lichsumuadao();
            List<lichsumuabean> listLsm = lsmDao.getLichSuMua(makh);

            // Đặt danh sách lịch sử mua hàng vào thuộc tính của request
            request.setAttribute("listLsm", listLsm);

            // Chuyển tiếp request và response đến trang JSP để hiển thị thông tin lịch sử mua hàng
            RequestDispatcher rd = request.getRequestDispatcher("LichSuMua.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("TrangLoi.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

