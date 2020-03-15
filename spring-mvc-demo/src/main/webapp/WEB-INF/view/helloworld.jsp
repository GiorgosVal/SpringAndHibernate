<!DOCTYPE html>

<html>

<body>

<h1>Hello World of Spring!</h1>

<h3>Student name: ${param.studentName}</h3>
</br></br>

<h3>The message: ${message}</h3>
</br></br>


<img src="${pageContext.request.contextPath}/static/images/spring-framework.png">
</br></br>

<img src="${pageContext.request.contextPath}/myCustomUrl/images/spring-framework.png">
</br></br>
<a href="${pageContext.request.contextPath}/">Back to main menu</a>

</body>
</html>