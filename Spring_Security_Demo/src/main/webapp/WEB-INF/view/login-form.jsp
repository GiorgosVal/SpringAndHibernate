<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: val
  Date: 16/4/20
  Time: 11:32 μ.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <style>
        .failed {
            color: red;
        }
    </style>
</head>
<body>

    <form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
        <h2>Please sign in</h2>
        <c:if test="${param.error != null}">
            <i class="failed">Sorry, the credentials you entered are not correct.</i>
        </c:if>
        <p>
            <input name="username" type="text" placeholder="Username"/>
        </p>
        <p>
            <input name="password" type="password" placeholder="Password"/>
        </p>
        <button type="submit">Sign in</button>
    </form:form>

</body>
</html>
