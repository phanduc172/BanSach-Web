<%@page import="java.util.ArrayList"%>
<%@page import="bean.sachbean"%>
<%@page import="bo.sachbo"%>
<%@page import="bo.loaibo"%>
<%@page import="bean.loaibean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bán sách</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<%
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		if(un!=null && pass!=null)
			if(un.equals("abc") && pass.equals("123")) {
				response.sendRedirect("HienThiSach.jsp");
			} else {
				response.sendRedirect("DangNhap.jsp?tb=DangNhapSai");
			}
	%>

	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="HienThiSach.jsp">Trang chủ</a></li>
	      <li><a href="DatHang.jsp">Giỏ hàng</a></li>
	      <li><a href="ThanhToan.jsp">Thanh toán</a></li>
   	      <li><a href="LichSuMuaHang.jsp">Lịch sử mua hàng</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li class="modal-title"><a href="DangKy.jsp"><span class="glyphicon glyphicon-user"></span> Đăng ký </a></li>
	      <%if(session.getAttribute("dn")==null) { %>
	      	<li class="modal-title">
	      	<!-- Trigger the modal with a button -->
			<button style="background: none;border: none;color: #9d9d9d;padding: 15px;" type="button" class="" data-toggle="modal" data-target="#myModal">
			<span class="glyphicon glyphicon-user"></span> Đăng nhập</button>
		  <!-- Modal -->
		  <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Đăng nhập</h4>
		        </div>
		        <div class="modal-body">
               		<form method="post" action="DangNhap.jsp" >
                        Tài khoản: <input type="text" name="username" > <br>
                        Mật khẩu: <input type="password" name="password"> <br>
                        <input type="submit" name="but" value="Đăng nhập">
                    </form>
		        </div>
		      </div>
	      </li>
	      <% } else { %>
	     	 <li><a href=""><span class="glyphicon glyphicon-user"></span> Xin chào: <%=session.getAttribute("dn")%> </a></li>
	     	 <li><a href="DangXuat.jsp"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất </a></li>
      	<%}%>
	    </ul>
	  </div>
	</nav>

		<table border="1" align="center">
		<tr>
			<td width="200" align="center" valign="top">
			<h4 class="mt-3">Hiển thị sách</h4>
				<table class="table table-dark table-hover">
					<%loaibo lbo = new loaibo();
					for(loaibean loai: lbo.getloai()) {%>
						<tr>
							<td>
								<a href="HienThiSach.jsp?ml=<%=loai.getMaloai()%>">
									<%=loai.getTenloai()%>
								</a>
							</td>
						</tr>
					<%}%>
				</table>
			</td>

			<td width="700" align="center" valign="top">
				<table class="table table-dark table-hover row">
				<h4 class="mt-3">Hiển thị sách</h4>
				<%
					response.setCharacterEncoding("utf-8");
					request.setCharacterEncoding("utf-8");
					sachbo sbo = new sachbo();
					ArrayList<sachbean> ds = sbo.getsach();
					String ml = request.getParameter("ml");
					String key = request.getParameter("txttim");
					if(ml!=null) //Chọn tên loại
						ds=sbo.timMa(ml);
					else
						if(key!=null)
							ds=sbo.tim(key);
					for(sachbean sach: ds) { %>
						<tr class="col-sm-4" align="center">
							<td>
								<img height="180" alt="" src="<%=sach.getAnh()%>"> <br>
								Tên sách: <a href="HienThiSach.jsp?ml=<%=sach.getMasach()%>">
									<%=sach.getTensach()%><br>
								</a>
								<a href="#"><img alt="" src="mua.jpg"></a> <br>
								Tác giả: <%=sach.getTacgia()%> <br>
								Giá bán: <%=sach.getGia()%>
							</td>
						</tr>
					<%}%>
				</table>
			</td>

			<td width="200" align="center" valign="top">
				<h4>Tìm kiếm</h4>
				<form method="post" action="HienThiSach.jsp">
					<input type="text" name="txttim" class="form-control" placeholder="Nhập sách cần tìm kiếm"> <br>
					<input type="submit" name="but1" value="Gửi">
				</form>
			</td>
		</tr>
	</table>

</body>
</html>