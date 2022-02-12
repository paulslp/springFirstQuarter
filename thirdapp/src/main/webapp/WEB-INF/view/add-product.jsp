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
    manufacturer date:<form:input path="date" type="date"/>
    <br>
    manufacturer id:<form:input path="manufacturerId"/>
    <br>
    <input type="submit" value="Add">
</form:form>
<c:url var="allProductsUrl" value="/products"></c:url>
<a href="${allProductsUrl}">ALL-PRODUCTS</a>
</body>
</html>
