<%--
  Created by IntelliJ IDEA.
  User: crtf
  Date: 21.6.10
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title>更新</title>
</head>
<body>
<form:form method="post" action="${pageContext.request.contextPath}/user/update" modelAttribute="user" >
    <input type="hidden" name="_method" value="put">
    用户名: <form:input path="name"/><form:errors path="name"/><br/>
    密码: <form:input path="password"/><form:errors path="password"/><br/>
    <input type="submit" value="确定">
</form:form>
</body>
</html>
