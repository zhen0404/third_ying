<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/toMain" method="post">
	userName:<input type="text" name="name" /><br/>
	password:<input type="text" name="password"><br/>
	<input type="submit" value="login"/><font color="red">${message }</font>
</form>
</body>
</html>