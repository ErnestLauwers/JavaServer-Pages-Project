<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.model.Bedrag" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="shortcut icon" type="image/png" href="img/faviconMS.png?v=1.1">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="hier" value="Home"/>
</jsp:include>
<main class="main1">
    <h1>MoneySplit</h1>
    <hr class="solid">
    <p class="intro">Ga je op vakantie met vrienden, maar hebben jullie geen zin om bij te houden wie wat betaalt?
        MoneySplit doet voor jou, geef gewoon wat informatie in in ons formulier en MoneySplit plaatst deze allemaal
        in een duidelijke tabel, zodat je na de vakantie een duidelijk overzicht hebt van wie er allemaal nog geld
        moet betalen en ontvangen.</p>
    <h2>Wat moet je allemaal ingeven?</h2>
    <p class="info">Geef om te beginnen de naam in van de persoon die heeft betaalt. Als tweede vul je in om welke
        activiteit (Bv. MacDonalds) het gaat zodat je weet voor wat er exact is betaalt. Hierna vul je het bedrag in
        dat betaalt is. Als laatste vul je de datum van de activiteit in.</p>
    <p class="meestBetalende">De persoon die het hoogste bedrag in één keer heeft betaald is:</p>
    <p class="meestBetalendeNaam">${requestScope.meestBetalende}</p>
    <p class="klik">Wil je beginnen met bij te houden wie wat betaalt?<br>Klik dan op de knop hieronder!</p>
    <div class="voegToe">
        <a class="voegGeldToe" href="Controller?command=voegToeMain">Voeg Een Geldsom Toe</a>
    </div>
    <section>
        <h3 class="laatsGewijzigdText">Het laatst gewijzigde bedrag is:</h3>
        <c:choose>
            <c:when test="${not empty oudBedrag}">
                <table>
                    <thead>
                    <tr class="thIndex">
                        <th>Naam</th>
                        <th>Activiteit</th>
                        <th>#Geld</th>
                        <th>Datum</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr class="tdIndex">
                            <td>${oudBedrag.naam}</td>
                            <td>${oudBedrag.activiteit}</td>
                            <td>${oudBedrag.aantal}</td>
                            <td>${oudBedrag.datum}</td>
                        </tr>
                    </tbody>
                </table>
            </c:when>
            <c:when test="${not empty verwijderd}">
                <p class="idVerwijderd">${verwijderd}</p>
            </c:when>
            <c:otherwise>
                <p class="geenWijzig">Er is nog geen bedrag gewijzigd.</p>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${not empty gewijzigdeBedrag}">
                <div class="button">
                    <button class="buttonTwee"><a href="Controller?command=wijzigOpnieuw">Laatste wijziging<br>ongedaan maken</a></button>
                </div>
            </c:when>
            <c:otherwise>
            </c:otherwise>
        </c:choose>
    </section>
</main>
<footer>
    <p>Created by Lauwers Ernest. © 2022</p>
</footer>
</body>
</html>