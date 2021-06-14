<%--
  Created by IntelliJ IDEA.
  User: crtf
  Date: 21.6.10
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<form method="post" action="${pageContext.request.contextPath}/user/signIn">
    <ul>
        <li>用户名: <input type="text" name="name"></li>
        <li>密码: <input type="text" name="password"></li>
        <li><input type="submit"></li>
    </ul>
</form>
</body>
</html>
