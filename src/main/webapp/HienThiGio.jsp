<%@page import="bean.khachhangbean"%>
<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
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
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<%
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
		khachhangbean khachhang = (khachhangbean) session.getAttribute("ktdn");
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
	      <% if (session.getAttribute("dn") == null) { %>
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
	     	 <li><a href="DangXuatController"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất </a></li>
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
				<table class="table table-dark table-hover row">
				<h4 class="mt-3">Giỏ sách</h4>

				<table class="table table-hover">
					<%
					ArrayList<giohangbean> dsgio = ghbo.ds;
					long tongtien = 0;
					if (dsgio != null) { %>
                    <% for (giohangbean h : dsgio) { %>
                        <tr>
                            <td><input type="checkbox" name="checkdel" value="<%=h.getMasach()%>"> </td>
                            <td><%=h.getMasach()%></td>
                            <td><%=h.getTensach()%></td>
                            <td><%=h.getGia()%></td>
                            <td><%=h.getSoluong()%></td>
                            <td>
                                <form action="SuaXoaController?ms=<%=h.getMasach()%>" method="post">
                                    <input name="txtsl" type="number" min="0" style="width: 50px;">
                                    <input name="btnsua" type="submit" value="Sửa">
                                    <input name="btnxoa" type="submit" value="Xóa">
                                </form>
                            </td>
                            <td><%=h.getThanhtien()%></td>
                        </tr>
                    <% } %>
                <% } %>
					<tr>
						<td align="right" colspan="7"> <b>Tổng tiền: </b><%=gh.TongTien() %></td>
					</tr>
				</table>
				<form style="display: inline-block;" class="btn-form" onsubmit="return xoaChon()" method="post" action="XoaChonController">
				    <input class="btn btn-primary" type="submit" name="btnxc" value="Xóa chọn">
				</form>
				<form style="display: inline-block;" class="btn-form" method="" action="XoaTatCaController">
					<input class="btn btn-primary" type="submit" name="btnxoaall" value="Xóa tất cả">
				</form>
				<form style="display: inline-block;" method="" action="XacNhanController">
					<input class="btn btn-primary" type="submit" name="btnnx" value="Xác nhận đặt mua">
				</form>
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
	<script>
	function xoaChon() {
	    var maSachXoa = [];
	    var checkboxes = document.getElementsByName("checkdel");
	    for (var i = 0; i < checkboxes.length; i++) {
	        if (checkboxes[i].checked) {
	            maSachXoa.push(checkboxes[i].value);
	        }
	    }

	    if (maSachXoa.length === 0) {
	        alert("Vui lòng chọn ít nhất một sản phẩm để xóa!");
	        return false;
	    }

	    var form = document.createElement("form");
	    form.method = "post";
	    form.action = "XoaChonController";

	    for (var i = 0; i < maSachXoa.length; i++) {
	        var input = document.createElement("input");
	        input.type = "hidden";
	        input.name = "msach";
	        input.value = maSachXoa[i];
	        form.appendChild(input);
	    }

	    document.body.appendChild(form);
	    form.submit();

	    return false;
	}
	</script>

</body>
</html>