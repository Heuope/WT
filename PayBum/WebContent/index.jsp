<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
<h2>Products List</h2>
<p><a href='<c:url value="/createCard" />'>Create new</a></p>
<table>
<tr><th>Number</th><th>C</th><th>Month</th><th>Year</th><th></th></tr>
<c:forEach var="card" items="${cards}">
 <tr><td>${card.number}</td>
    <td>${card.cvv}</td>
    <td>${card.month}</td>
    <td>${card.year}</td>
    <td>
    <a href='<c:url value="/editCard?id=${card.id}" />'>Edit</a> |
    <form method="post" action='<c:url value="/deleteCard" />' style="display:inline;">
        <input type="hidden" name="id" value="${card.id}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>