<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Wijzig</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="shortcut icon" type="image/png" href="img/faviconMS.png?v=1.1">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="hier" value="Overzicht"/>
</jsp:include>
<main class="main2">
    <h1>MoneySplit</h1>
    <hr class="solid">
    <c:if test="${not empty errors}">
        <div class="fout">
            <ul>
                <c:forEach items ="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <div class="hoogte">
    <section class="invulFormulier">
        <form action="Controller?command=wijzigen&bedrag=${requestScope.MoetWijzigen.id}" method="post" novalidate>
            <h2>Wijzigen</h2>
            <div class="invulVeld">
                <label for="naam"></label>
                <input type="text" name="naam" id="naam" value="${MoetWijzigen.naam}">
                <span>Naam</span>
            </div>
            <div class="invulVeld">
                <label for="activiteit"></label>
                <input type="text" name="activiteit" id="activiteit" value="${MoetWijzigen.activiteit}">
                <span>Activiteit</span>
            </div>
            <div class="invulVeld">
                <label for="aantal"></label>
                <input type="number" name="aantal" max="10000" id="aantal" value="${MoetWijzigen.aantal}">
                <span>#Geld</span>
            </div>
            <div class="invulVeld">
                <label for="datum"></label>
                <input type="text" name="datum" id="datum" value="${MoetWijzigen.datum}">
                <span>Datum</span>
            </div>
            <input type="hidden" name="command" value="wijzig">
            <div class="invulVeldGroen">
                <input type="submit" name="wijzig" value="Wijzig">
            </div>
            <form action="Controller?command=overzicht" method="post" novalidate>
                <div class="invulVeldRood">
                    <input type="submit" name="Rood" value="Cancel" id="submit">
                </div>
            </form>
        </form>
    </section>
    </div>
</main>
<footer>
    <p>Created by Lauwers Ernest. © 2022</p>
</footer>
</body>
</html>