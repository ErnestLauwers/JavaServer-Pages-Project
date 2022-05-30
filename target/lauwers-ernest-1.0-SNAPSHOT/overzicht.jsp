<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.model.Bedrag" %>
<%@ page import="domain.db.BedragenDB" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Overzicht</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="shortcut icon" type="image/png" href="img/faviconMS.png?v=1.1">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="hier" value="Overzicht"/>
</jsp:include>
<main>
    <h1>MoneySplit</h1>
    <hr class="solid">
    <table>
        <thead>
        <tr class="woorden">
            <th>Naam</th>
            <th>Activiteit</th>
            <th>#Geld</th>
            <th>Datum</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="bedrag" items="${requestScope.bedragen}">
        <tr>
            <td>${bedrag.naam}</td>
            <td>${bedrag.activiteit}</td>
            <td>${bedrag.aantal}</td>
            <td>${bedrag.datum}</td>
            <td class="wijzig"><div class="knopWijzig"><a href="Controller?command=wijzigMain&bedrag=${bedrag.id}"><img src="img/wijzig.png" alt="wijzig"></a></div></td>
            <td class="verwijder"><div class="knopVerwijder"><a href="Controller?command=verwijderBedrag&bedrag=${bedrag.id}"><img src="img/verwijder.png" alt="verwijder"></a></div></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<footer>
    <p>Created by Lauwers Ernest. © 2022</p>
</footer>
</body>
</html>