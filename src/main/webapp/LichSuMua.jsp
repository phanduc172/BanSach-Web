<%@page import="bean.khachhangbean"%>
<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.sachbean"%>
<%@page import="bo.sachbo"%>
<%@page import="bo.loaibo"%>
<%@page import="bean.loaibean"%>
<%@ page import="bean.lichsumuabean" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bán sách</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<%
		khachhangbean khachhang = (khachhangbean) session.getAttribute("ktdn");
		giohangbo gh = (giohangbo) session.getAttribute("gio");
		if(gh==null) {
			gh = new giohangbo();
			session.setAttribute("gio",gh);
		}

// 		String un = request.getParameter("username");
// 		String pass = request.getParameter("password");
// 		if(un!=null && pass!=null)
// 			if(un.equals("abc") && pass.equals("123")) {
// 				response.sendRedirect("HienThiSach.jsp");
// 			} else {
// 				response.sendRedirect("DangNhap.jsp?tb=DangNhapSai");
// 			}
	%>

	<%
		giohangbo ghbo = (giohangbo) session.getAttribute("gio");

		// Kiểm tra nếu có thông tin sản phẩm được thêm vào giỏ hàng từ trang HienThiSach.jsp
		String masach = request.getParameter("ms");
		String tensach = request.getParameter("ts");
		String gia = request.getParameter("gia");
	%>

	<nav class="navbar navbar-inverse">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="SachController" class="navbar-brand">Nhà sách</a>
        </div>
        <!-- Collection of nav links, forms, and other content for toggling -->
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="SachController">Trang chủ</a></li>
                <li><a href="GioHangController">Giỏ hàng <span style="color:red;">(<%=gh.TongSLSach()%>)</span></a></li>
                <li><a href="XacNhanController">Xác nhận đặt mua</a></li>
                <li><a href="LichSuMuaController">Lịch sử mua hàng</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
	      <% if (session.getAttribute("dn")==null) { %>
		    <li class="modal-title">
	      	<!-- Trigger the modal with a button -->
			<button style="background: none;border: none;color: #9d9d9d;padding: 15px;" type="button" class="" data-toggle="modal" data-target="#myModalRegister">
			<span class="glyphicon glyphicon-user"></span> Đăng ký</button>
		  <!-- Modal -->
		  <div class="modal fade" id="myModalRegister" role="dialog">
		    <div class="modal-dialog">
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Đăng ký</h4>
		        </div>
		        <div class="modal-body">
               		<form method="post" action="DangKyController">
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder="Họ tên" name="hoten" type="text">
			    		</div>
                        <div class="form-group">
			    		    <input class="form-control" placeholder="Địa chỉ" name="diachi" type="text">
			    		</div>
                        <div class="form-group">
			    		    <input class="form-control" placeholder="Số điện thoại" name="sodt" type="text">
			    		</div>
                        <div class="form-group">
			    		    <input class="form-control" placeholder="Email" name="email" type="email">
			    		</div>
                        <div class="form-group">
			    		    <input class="form-control" placeholder="Tên đăng nhập" name="tendn" type="text">
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="Nhập mật khẩu" name="pass" type="password" value="">
			    		</div>
			    		<input class="btn btn-lg btn-primary btn-block" type="submit" value="Đăng ký">
			    	</fieldset>
			      	</form>
		        </div>
		      </div>
	      </li>
		<% } %>
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
               		<form method="post" action="DangNhapController">
                    <fieldset>
			    	  	<div class="form-group">
			    		    <input class="form-control" placeholder="Nhập tài khoản" name="username" type="text">
			    		</div>
			    		<div class="form-group">
			    			<input class="form-control" placeholder="Nhập mật khẩu" name="password" type="password" value="">
			    		</div>
			    		<div class="checkbox">
			    	    </div>
			    		<input class="btn btn-lg btn-primary btn-block" type="submit" value="Đăng nhập">
			    	</fieldset>
			      	</form>
		        </div>
		      </div>
	      </li>
	      <% } else { %>
	     	 <li><a href=""><span class="glyphicon glyphicon-user"></span> Xin chào: <%=khachhang.getHoten()%> </a></li>
	     	 <li><a href="DangXuat.jsp"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất </a></li>
      	<%}%>
	    </ul>
        </div>
    </nav>

		<table border="1" align="center">
		<tr>
			<td class="danhmuc"width="200" align="center" valign="top">
				<h4 class="mt-3">Hiển thị danh mục</h4>
					<table class="table table-dark table-hover">
						<%
						loaibo lbo = new loaibo();
						ArrayList<loaibean> dsloai = lbo.getloai();
						%>
						<%if (request.getAttribute("dsloai") != null) {
						  dsloai = (ArrayList<loaibean>) request.getAttribute("dsloai");
						}%>
						<%for(loaibean loai: dsloai) {%>
							<tr>
								<td>
									<a href="SachController?ml=<%=loai.getMaloai()%>">
										<%=loai.getTenloai()%>
									</a>
								</td>
							</tr>
						<%}%>
					</table>
				</td>
			<td class="noidung" width="700" align="center" valign="top">
				<h4 class="mt-3">Lịch sử mua hàng</h4>
		        <table class="table table-bordered table-hover">
		            <thead>
		                <tr>
		                    <th>Mã CTHĐ</th>
		                    <th>Họ tên</th>
		                    <th>Tên sách</th>
		                    <th>Giá</th>
		                    <th>Số lượng mua</th>
		                    <th>Ngày mua</th>
		                </tr>
		            </thead>
		            <tbody>
		                <% ArrayList<lichsumuabean> listLsm = (ArrayList<lichsumuabean>) request.getAttribute("listLsm"); %>
		                <% if (listLsm != null && !listLsm.isEmpty()) { %>
		                    <% for (lichsumuabean lsm : listLsm) { %>
		                        <tr>
		                            <td><%= lsm.getMacthd() %></td>
		                            <td><%= lsm.getHoten() %></td>
		                            <td><%= lsm.getTensach() %></td>
		                            <td><%= lsm.getGia() %></td>
		                            <td><%= lsm.getSoluongmua() %></td>
		                            <td><%= lsm.getNgaymua() %></td>
		                        </tr>
		                    <% } %>
		                <% } else { %>
		                    <tr>
		                        <td colspan="6">Không có lịch sử mua hàng</td>
		                    </tr>
		                <% } %>
		            </tbody>
		        </table>
			</td>

			<td class="timkiem" width="200" align="center" valign="top">
					<h4>Tìm kiếm</h4>
					<form method="post" action="SachController">
						<input style="width: 90%;" type="text" name="txttim" class="form-control" placeholder="Nhập sách cần tìm kiếm"> <br>
						<input type="submit" name="but1" value="Gửi">
					</form>
			</td>
		</tr>
	</table>

</body>
</html>