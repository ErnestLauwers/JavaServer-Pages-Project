<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zoek</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="shortcut icon" type="image/png" href="img/faviconMS.png?v=1.1">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="hier" value="Zoek"/>
</jsp:include>
<main>
    <h1>MoneySplit</h1>
    <hr class="solid">
    <section class="">
        <h2>Zoek resultaten voor de naam "${Naam}"</h2>
        <c:choose>
        <c:when test="${not empty bedragenLijst}">
        <table>
            <thead>
            <tr class="woorden">
                <th>Naam</th>
                <th>Activiteit</th>
                <th>#Geld</th>
                <th>Datum</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="i" items="${bedragenLijst}">
                <tr>
                    <td>${i.getNaam()}</td>
                    <td>${i.getActiviteit()}</td>
                    <td>${i.getAantal()}</td>
                    <td>${i.getDatum()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        </c:when>
        <c:otherwise>
            <div>
                <p class="resultaatNiet">Er zijn geen bedragen op deze naam gevonden.</p>
            </div>
        </c:otherwise>
        </c:choose>
    </section>
    <div class="zoekOpnieuw">
        <a href="Controller?command=zoek">Zoek Opnieuw</a>
    </div>
</main>
<footer>
    <p>Created by Lauwers Ernest. © 2022</p>
</footer>
</body>
</html>
