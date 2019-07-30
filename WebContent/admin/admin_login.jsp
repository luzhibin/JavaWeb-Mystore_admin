<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>码蚁商城后台管理系统</title>
		<link href="../favicon.ico" rel="shortcut icon">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" type="text/css" />

	</head>

	<body>
		<div id="container">
			<div>			<!--可以使用EL中的pageContext内置对象  -->
				<form action="${pageContext.request.contextPath }/AdminServlet">
					<div class="login">码蚁商城后台管理系统
					</div>
					<div class="username-text">用户名:</div>
					<div class="password-text">密码:</div>
					<div class="username-field">
						<input type="text" name="username" value="" />
					</div>
					<div class="password-field">       
						<input type="password" name="password" value="" />
					</div>
					<input type="submit" name="submit" value="GO" />
					<div class="errMessage-div">
						<span id="errorSpan"style="font-size: 16px;">${error }</span>
					</div>
				</form>
			</div>
		</div>

	</body>
</html>
