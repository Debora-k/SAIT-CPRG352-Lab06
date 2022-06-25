<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>${message} <a href="ShoppingList?action=logout">Logout</a> </p>
        <br>
        <form method="POST" action="ShoppingList?action=add">
            <h3>List</h3>
            <label>Add item: </label>
            <input type="text" name="item"> <input type="submit" value="Add">
        </form>
    <c:if test="${items != null}">
        <form method="POST" action="ShoppingList?action=delete">
            <c:forEach items="${items}" var="ArrayListItem"> 
                <input type="radio" value="${ArrayListItem}" name="delete"> <label>${ArrayListItem}</label> <br>
            </c:forEach>
            <input type="submit" value="Delete">
        </form>
    </c:if>
    </body>
</html>
