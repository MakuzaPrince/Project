<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.demo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
	<jsp:useBean id="obj" class = "com.demo.Bean"/>
	<jsp:setProperty property="*" name="obj"/>
	<h2>
	<%
		int  status = DAO.insertLogin(obj);
		if (status>0)
			out.print("Data saved successfull!");
		else
			out.print("Data not saved!!!");
	%>
	</h2>
</body>
</html>