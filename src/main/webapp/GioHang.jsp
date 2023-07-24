<%@page import="bo.giohangbo"%>
<%@page import="tam.CGioHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<body>
	<%
// 		String masach = request.getParameter("ms");
// 		String tensach = request.getParameter("ts");
// 		long gia = Long.parseLong(request.getParameter("gia"));
// 		giohangbo gh;
// 		if (session.getAttribute("gio") == null) { //neu mua lan dau
// 			  gh = new giohangbo();
// 			  session.setAttribute("gio", gh);//cap phat gio
// 			}
// 		//b1: gan sesion vao bien
// 		gh = (giohangbo) session.getAttribute("gio");
// 		//b2: thao tac tren bien
// 		gh.Them(masach, tensach, gia, (long) 1);
// 		//b3: luu bien vao sesion

// 		session.setAttribute("gio", gh);
// 		session.setAttribute("slsp", gh.ds.size());

// 		response.sendRedirect("HienThiGio.jsp");
	%>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</body>
</html>