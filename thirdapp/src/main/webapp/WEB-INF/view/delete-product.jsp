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
<h1>Delete product</h1>
<form action="delete" method="post">
    delete product with id:
    <input type="text" name="id"/>
    <input type="submit" value="Delete"/>
</form>
<c:url var="allProductsUrl" value="/products"></c:url>
<br>
<a href="${allProductsUrl}">ALL-PRODUCTS</a>
</body>
</html>
