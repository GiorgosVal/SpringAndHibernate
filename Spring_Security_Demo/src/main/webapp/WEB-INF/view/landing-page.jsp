<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: val
  Date: 15/4/20
  Time: 9:04 μ.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Landing Page</title>
</head>
<body>
    <h2>Landing Page</h2>

    <a href="${pageContext.request.contextPath}/employees">Employees page</a><br>
    <a href="${pageContext.request.contextPath}/leaders">Leaders page</a><br>
    <a href="${pageContext.request.contextPath}/systems">Admin page</a><br>


</body>
</html>
