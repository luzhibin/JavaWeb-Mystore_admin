<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${pageContext.request.contextPath }/TestServlet2?action=add">添加</a>
	<a href="${pageContext.request.contextPath }/TestServlet2?action=del">删除</a>
	<a href="${pageContext.request.contextPath }/TestServlet2?action=update">更新</a>
</body>
</html>