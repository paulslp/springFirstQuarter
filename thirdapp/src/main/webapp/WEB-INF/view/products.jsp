<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.geekbrains.domain.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h1>Products</h1>
<form action="product" method="get">
    find product by id:
    <input type="text" name="id"/>
    <input type="submit" value="Search"/>
</form>
<br>
<c:url var="productsUrl" value="/products"></c:url>
<a href="${productsUrl}">Show all products</a>
<table border="1">
    <tr>
        <td>id</td>
        <td>title</td>
        <td>cost</td>
        <td>manufacture date</td>
        <td>manufacturer id</td>
    </tr>
    <% if (request.getAttribute("products") != null) %>
    <% for (Product value : (List<Product>) request.getAttribute("products")) {%>
    <tr>
        <td><%=value.getId()%>.</td>
        <td><%=value.getTitle()%>
        </td>
        <td><%=value.getCost()%>
        </td>
        <td><%=value.getDate()%>
        </td>
        <td><%=value.getManufacturerId()%>
        </td>
    </tr>
    <%}%>
</table>
<c:url var="addUrl" value="/products/add"></c:url>
<c:url var="deleteUrl" value="/products/delete"></c:url>
<a href="${addUrl}">ADD</a>
<a href="${deleteUrl}">DELETE</a>
</body>
</html>