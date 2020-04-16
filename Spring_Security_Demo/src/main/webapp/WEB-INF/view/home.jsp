<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Home Page</title>
</head>
<body>
    <h2>Welcome</h2>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <button type="submit" value="Logout">Logout</button>
    </form:form>

</body>
</html>
