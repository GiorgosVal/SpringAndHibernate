<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head></head>
<body>

<h2>Student registration form</h2>

<form:form action="processForm" modelAttribute="student">
    <form:input path="name" placeholder="Name"/>
    <br>
    <form:input path="lastName" placeholder="Last name"/>
    <br>
    <form:select path="country">
        <form:option value="Greece" label="Greece"/>
        <form:option value="France" label="France"/>
        <form:option value="Germany" label="Germany"/>
        <form:option value="Italy" label="Italy"/>
    </form:select>
    <br>
    <form:select path="favoriteLesson">
        <form:options items="${student.lessonOptions}"/>
    </form:select>
    <br>
    <form:select path="favoriteCar">
        <form:options items="${carsOptions}"/>
    </form:select>
    <br>
    <form:radiobutton path="favoriteLanguage" value="Java" label="Java"/>
    <form:radiobutton path="favoriteLanguage" value="C#" label="C#"/>
    <form:radiobutton path="favoriteLanguage" value="Ruby" label="Ruby"/>
    <form:radiobutton path="favoriteLanguage" value="PHP" label="PHP"/>
    <br>
    <form:radiobuttons path="favoriteFood" items="${foodOptions}"/>
    <br>
    <form:checkbox path="operatingSystems" value="Linux" label="Linux"/>
    <form:checkbox path="operatingSystems" value="Mac" label="Mac"/>
    <form:checkbox path="operatingSystems" value="Windows" label="Windows"/>
    <br>
    <input type="submit" value="Login"/>
</form:form>

</body>

</html>