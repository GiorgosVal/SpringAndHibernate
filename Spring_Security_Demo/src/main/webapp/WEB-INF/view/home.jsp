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
    <title>Home Page</title>
</head>
<body>
    <h2>Welcome</h2>
    User: <security:authentication property="principal.username"/>
    Role(s): <security:authentication property="principal.authorities"/>
    <security:authorize access="hasRole('ADMIN')">
        <h3>Admin content</h3>
    </security:authorize>
    <security:authorize access="isAuthenticated()">
        <h3>Content only for authenticated users.</h3>
    </security:authorize>

    <!--
	form:form will automatically include an hidden input field with the generated csrf token like
	<input type="hidden" name="_csrf" value="fa11321d-0aaa-4cf6-a582-733fa9a2a9a4">

	If a simple form element is used instead of form:form then the input field must be added manually:
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	-->
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <button type="submit" value="Logout">Logout</button>
    </form:form>

</body>
</html>
