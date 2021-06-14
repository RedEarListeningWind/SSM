<%--
  Created by IntelliJ IDEA.
  User: crtf
  Date: 21.6.9
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <title><spring:message code="home"/></title>
</head>
<body>
<h1><spring:message code="home"/></h1>

<form method="post" action="${pageContext.request.contextPath}/file/upload" enctype="multipart/form-data">
    <input type="file" name="file" value="<spring:message code="Please_select_the_uploaded_file"/>">
    <input type="submit" value="<spring:message code="submit"/>">
</form>

<form method="post" action="${pageContext.request.contextPath}/user/update">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="<spring:message code="update"/>">
</form>
<form method="get" action="${pageContext.request.contextPath}/user/exit">
    <input type="submit" value="<spring:message code="exit"/>">
</form>
<c:out value="${addAttribute}"/>
<a href="<c:url value="/toMyView"/>">自定义视图</a> | <a href="<c:url value="/export"/>">Excel</a>
<%--
<fmt:message key="zh_CN"/>
<spring:message code="zh_CN"/>
--%>
<div><a href="<c:url value="/user/home?language=zh_CN"/>"><fmt:message key="zh_CN"/><spring:message code="zh_CN"/></a>|<a href="<c:url value="/user/home?language=en_US"/>"><spring:message code="en_US"/></a></div>
</body>
</html>
