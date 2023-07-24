<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Giá trị session tạo từ servelet tạm:
	<%=session.getAttribute("tam") %> <br>
	a = <%=request.getAttribute("a") %> <br>
	b = <%=request.getAttribute("b")%> <br>
	Giá trị của tham số kt: <%=request.getParameter("kt") %> <br>
	Giá trị của biến request: <br>
	<%String[] ds = (String[])request.getAttribute("ds");
	for(String ht: ds)
		out.print(ht + "<hr>");
	%>
</body>
</html>