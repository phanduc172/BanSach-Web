<%@page import="bean.xacnhanbean"%>
<%@page import="bean.khachhangbean"%>
<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.sachbean"%>
<%@page import="bo.sachbo"%>
<%@page import="bo.loaibo"%>
<%@page import="bean.loaibean"%>
<%@page import="bean.xacnhanbean"%>
<%@ page import="bean.lichsumuabean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xác nhận đơn hàng</title>
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
            <a href="AdminLoaiController" class="navbar-brand">Nhà sách</a>
        </div>
        <!-- Collection of nav links, forms, and other content for toggling -->
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="AdminLoaiController">Quản lý loại</a></li>
                <li><a href="AdminSachController">Quản lý sách <span style="color:red;"></span></a></li>
                <li><a href="AdminXacNhanController">Xác nhận hóa đơn</a></li>
                <li><a href="AdminDanhSachController">Khách hàng đã chuyển tiền</a></li>
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
	     	 <li><a href="DangXuatController"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất </a></li>
      	<%}%>
	    </ul>
        </div>
    </nav>

	<h4 align="center"><b>XÁC NHẬN ĐƠN HÀNG</b></h4>
	<div class="container">
		<table border="1" class="table table-hover">
			<tr style="font-weight: bold;">
				<td>Mã khách hàng</td>
				<td>Họ tên</td>
				<td>Tên sách</td>
				<td>Giá</td>
				<td>Mã CTHD</td>
				<td>Số lượng mua</td>
				<td>Thành tiền</td>
				<td>Đã mua</td>
				<td> Xác nhận đơn hàng</td>
			</tr>

			<c:forEach var="xn" items="${dshoadon}">
			<tr>
				<td>${xn.getMakh()}</td>
				<td>${xn.getHoten()}</td>
				<td>${xn.getTensach()}</td>
				<td>${xn.getGia()}</td>
				<td>${xn.getMaChiTietHD()}</td>
				<td>${xn.getSoLuongMua()}</td>
				<td>${xn.getThanhtien()}</td>
				<td>${xn.isDamua()}</td>
				<td><a href = "AdminXacNhanController?mact=${xn.getMaChiTietHD()}">Xác nhận</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>