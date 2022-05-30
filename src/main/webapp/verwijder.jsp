<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Verwijder</title>
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
    <h2>Ben je zeker dat je dit bedrag wilt verwijderen?</h2>
    <div class="inhoudVerwijder">
        <p>${requestScope.MoetVerwijderen.naam}</p>
        <p>${requestScope.MoetVerwijderen.activiteit}</p>
        <p>€${requestScope.MoetVerwijderen.aantal}</p>
        <p>${requestScope.MoetVerwijderen.datum}</p>
    </div>
    <section class="invulFormulierVerwijder">
        <form action="Controller?command=verwijderen&bedrag=${requestScope.MoetVerwijderen.id}" method="post" novalidate>
            <div class="invulVeldGroen">
                <input type="submit" name="Groen" value="Ja" id="submitJa">
            </div>
        </form>
        <form action="Controller?command=overzicht" method="post" novalidate>
            <div class="invulVeldRood">
                <input type="submit" name="Rood" value="Nee" id="submitNee">
            </div>
        </form>
    </section>
</main>
<footer>
    <p>Created by Lauwers Ernest. © 2022</p>
</footer>
</body>
</html>