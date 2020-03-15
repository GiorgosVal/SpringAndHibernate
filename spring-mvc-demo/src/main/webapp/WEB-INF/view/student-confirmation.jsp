<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<body>
<h2>Member page</h2>

<h3>Welcome ${student.name} ${student.lastName}</h3>
<br>
<h3>Your country is: ${student.country}</h3>
<br>
<h3>Your favorite lesson is: ${student.favoriteLesson}</h3>
<br>
<h3>Your favorite car brand is: ${student.favoriteCar}</h3>
<br>
<h3>Your favorite language is: ${student.favoriteLanguage}</h3>
<br>
<h3>Your favorite food is: ${student.favoriteFood}</h3>
<br>
<h3>You can work on:</h3>
<ul>
    <c:forEach var="os" items="${student.operatingSystems}">
        <li>${os}</li>
    </c:forEach>
</ul>
</body>


</html>