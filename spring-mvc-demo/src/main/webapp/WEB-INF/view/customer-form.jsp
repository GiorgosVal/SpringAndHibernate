<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Registration Form</title>
    <style>
        .error {
            color:red;
        }
    </style>
</head>
<body>
    <form:form action="processForm" modelAttribute="customer">
        <form:input path="firstName" placeholder="First name"/><br>
        <form:input path="lastName" placeholder="Last name"/>
        <form:errors path="lastName" cssClass="error"/><br>
        <form:input path="freePasses" placeholder="Free passes"/>
        <form:errors path="freePasses" cssClass="error"/>
        <br><br>
        <input type="submit" value="Register">
    </form:form>
</body>
</html>