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
    </tr>
    <% if (request.getAttribute("products") != null) %>
    <% for (Product value : (List<Product>) request.getAttribute("products")) {%>
    <tr>
        <td><%=value.getId()%>.</td>
        <td><%=value.getTitle()%>
        </td>
        <td><%=value.getCost()%>
        </td>
    </tr>
    <%}%>
</table>
<c:url var="addUrl" value="/products/add"></c:url>

<a href="${addUrl}">ADD</a>
</body>
</html>
