<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="ru.geekbrains.domain.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<h1>Add product</h1>
<form:form action="add" modelAttribute="product">
    title:<form:input path="title"/>
    <br>
    cost:<form:input path="cost"/>
    <br>
    <input type="submit" value="Add">
</form:form>
</body>
</html>
