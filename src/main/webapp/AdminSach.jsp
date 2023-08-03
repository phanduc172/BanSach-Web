<%@page import="bo.loaibo"%>
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý loại</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

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
	     	 <li><a href=""><span class="glyphicon glyphicon-user"></span> Xin chào: <%%> </a></li>
	     	 <li><a href="DangXuatController"><span class="glyphicon glyphicon-log-in"></span> Đăng xuất </a></li>
      	<%}%>
	    </ul>
        </div>
    </nav>

	<div class="container">
	<form action="AdminSachController" method="post" class="form-inline d-flex justify-content-between align-items-center">
	    <div class="form-group">
	        <label for="txtmasach">Mã sách:</label>
	        <input name="txtmasach" type="text" class="form-control">
	    </div>
	    <div class="form-group">
	        <label for="txttensach">Tên sách:</label>
	        <input name="txttensach" type="text" class="form-control">
	    </div>
	    <div class="form-group">
	        <label for="txtgia">Giá:</label>
	        <input name="txtgia" type="text" class="form-control">
	    </div> <br> <br>
	    <div class="form-group">
	        <label for="txtsoluong">Số lượng:</label>
	        <input name="txtsoluong" type="text" class="form-control">
	    </div>
	    <div class="form-group">
	        <label for="txtanh">Ảnh:</label>
	        <input name="txtanh" type="text" class="form-control">
	    </div>
	    <div class="form-group">
	        <label for="txtmaloai">Tên loại:</label>
	        <input name="txtmaloai" type="text" class="form-control">
	    </div> <br> <br>
	    <div class="form-group">
	        <input class="btn btn-primary" name="butaddsach" type="submit" value="Thêm">
	    </div>
	    <div class="form-group">
	        <input class="btn btn-primary" name="butupdatesach" type="submit" value="Cập nhật">
	    </div>
	</form>
	</div>

	<h4 align="center"><b>DANH SÁCH CÁC SÁCH</b></h4>
	<div class="container">
		<table border='1' width="900" align="center" class="p-3 mt-5 table table-hover">
			<tr style="font-weight: bold;">
				<td>Mã sách</td>
				<td>Tên sách</td>
				<td>Giá</td>
				<td>Số lượng</td>
				<td>Ảnh</td>
				<td>Mã loại</td>
				<td>Chọn</td>
				<td>Xóa</td>
			</tr>
		<c:forEach var="sach" items="${dssach}" >
			<tr>
				<td>${sach.getMasach()}</td>
				<td>${sach.getTensach()}</td>
				<td>${sach.getGia()}</td>
				<td>${sach.getSoluong()}</td>
				<td>${sach.getAnh()}</td>
				<td>${sach.getMaloai()}</td>
				<td> <a href="AdminSachController?ms=${sach.getMasach()}&tab=chonsach">Chọn</a> </td>
				<td><a href="AdminSachController?ms=${sach.getMasach()}&tab=xoasach">Xóa</a></td>

			</tr>
		</c:forEach>
		</table>
	</div>

</body>
</html>