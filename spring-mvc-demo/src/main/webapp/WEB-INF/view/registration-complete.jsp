<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
    <title>Registration complete</title>
</head>
<body>
    <h1>Welcome!</h1>
    <p>${customer.firstName} ${customer.lastName}, thanks for registering to our site.</p>
    <br>
    <p>Postal Code: ${customer.postalCode}.</p>
    <br>
    <p>Course Code: ${customer.courseCode}.</p>
    <br>
    <p>Free passes: ${customer.freePasses}.</p>
</body>
</html>