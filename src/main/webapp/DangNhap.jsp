<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%
		String un = request.getParameter("username");
		String pass = request.getParameter("password");
		if(un!=null && pass!=null)
			if(un.equals("abc") && pass.equals("123")) {
				session.setAttribute("dn", un);
				response.sendRedirect("HienThiSach.jsp");
			} else {
				response.sendRedirect("DangNhap.jsp?tb=DangNhapSai");
			}
	%>


	<form method="post" action="DangNhap.jsp" >
		Tài khoản: <input type="text" name="username" > <br>
		Mật khẩu: <input type="password" name="password"> <br>
		<input type="submit" name="but" value="login">
	</form>

	<%
	String tb = request.getParameter("tb");
	if(tb!=null)
		out.print("<b>Dang nhap sai </b>");
	%>
</body>
</html>

