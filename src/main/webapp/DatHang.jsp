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
		<form method='post' action ='DatHang.jsp'>
			Tên hàng <input type='text' name='txtth'><br>
			Giá bán <input type='text' name='txtgia'><br>
			Số lượng <input type='text' name='txtsl'><br>
			<input type='submit' name='un1' value='Dat Hang'>		<br>
		</form>
		Giỏ hàng <hr>
		<%
			String th = request.getParameter("txtth");
			String gia = request.getParameter("txtgia");
			String sl =  request.getParameter("txtsl");
			if(th!=null&&gia!=null&&sl!=null) {
				CGioHang g = new CGioHang();
				//Nếu mua hàng lần đầu
					if(session.getAttribute("gh")==null) {
						session.setAttribute("gh", g);//Tạo giỏ
					}
					//Gán biến gh vào session
					g = (CGioHang)session.getAttribute("gh");
					//Thêm biến vào session
					g.Them(th,Integer.parseInt(gia),Integer.parseInt(sl));
					//Lưu biến vào session
					session.setAttribute("gh", g);
			}
			//Hiển thị đồ trong giỏ hàng
			if(session.getAttribute("gh")!=null) {
				CGioHang g = new CGioHang();
				g = (CGioHang)session.getAttribute("gh");
				int sh = g.ds.size(); %>
				<table border='1' width='90%' align="center">
					<tr>
							<td align="center">Tên hàng</td>
							<td align="center">Giá bán</td>
							<td align="center">Số lượng</td>
							<td align="center">Thành tiền</td>
						</tr>
					<%for(int i = 0; i < sh; i++ ) { %>
						<tr>
							<td align="center">
								<%=g.ds.get(i).getTenhang() %>
							</td>
							<td align="center">
								<%=g.ds.get(i).getGia() %>
							</td>
							<td>
								<%=g.ds.get(i).getSoluong()%>
								<form method="post" action="Sua.jsp?th=<%=g.ds.get(i).getTenhang()%>">
									<input type="text" name="txtsua">
									<input type="submit" name="tt" value="Sua">
								</form>
							</td>
							<td align="center">
								<%=g.ds.get(i).getThanhtien() %>
							</td>
						</tr>
					<% }%>
				</table>
				<div class= "mr-5" align="right">Tổng tiền: <%=g.TongTien() %></div>
			<% }%>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</body>
</body>
</html>