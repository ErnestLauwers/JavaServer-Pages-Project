<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voeg Toe</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="shortcut icon" type="image/png" href="img/faviconMS.png?v=1.1">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="hier" value="Voeg Toe"/>
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
        <form action="Controller?command=voegToe" method="post" novalidate>
            <h2>Voeg Toe</h2>
            <div class="invulVeld">
                <label for="naam"></label>
                <input type="text" name="naam" id="naam" value="${naamFout}">
                <span>Naam</span>
            </div>
            <div class="invulVeld">
                <label for="activiteit"></label>
                <input type="text" name="activiteit" id="activiteit" value="${activiteitFout}">
                <span>Activiteit</span>
            </div>
            <div class="invulVeld">
                <label for="aantal"></label>
                <input type="number" name="aantal" max="10000" id="aantal" value="${aantalFout}">
                <span>#Geld</span>
            </div>
            <div class="invulVeld">
                <label for="datum"></label>
                <input type="text" name="datum" id="datum" value="${datumFout}">
                <span>Datum</span>
            </div>
            <div class="invulVeld">
                <input type="submit" name="voegToe" id="submit" value="Voeg Toe">
            </div>
        </form>
    </section>
    </div>
</main>
<footer>
    <p>Created by Lauwers Ernest. © 2022</p>
</footer>
</body>
</html>