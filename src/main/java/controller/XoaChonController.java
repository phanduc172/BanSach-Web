package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;

@WebServlet("/XoaChonController")
public class XoaChonController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");

            giohangbo ghbo = (giohangbo) session.getAttribute("gio");

            // Lấy danh sách mã sách cần xóa được chọn từ request
            String[] maSachXoa = request.getParameterValues("msach");
            if (maSachXoa != null) {
                List<String> danhSachMaSachXoa = new ArrayList<>();
                for (String maSach : maSachXoa) {
                    danhSachMaSachXoa.add(maSach);
                }

                // Xóa các sản phẩm được chọn ra khỏi giỏ hàng
                for (String maSach : danhSachMaSachXoa) {
                    ghbo.Xoa(maSach);
                }
            }

            response.sendRedirect("GioHangController"); // Chuyển hướng về trang giỏ hàng sau khi xóa
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            response.sendRedirect("GioHangController"); // Chuyển hướng về trang giỏ hàng nếu có lỗi xảy ra
        }
    }
}
