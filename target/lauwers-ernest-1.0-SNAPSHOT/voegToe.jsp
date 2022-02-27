<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voeg Toe</title>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="shortcut icon" type="image/png" href="img/faviconMS.png?v=1.1">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
    <nav>
        <p class="logo"><a href="index.jsp">M/S</a></p>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li class="hier"><a href="voegToe.jsp">Voeg Toe</a></li>
            <li><a href="overzicht.jsp">Overzicht</a></li>
        </ul>
    </nav>
</header>
<main class="main2">
    <h1>MoneySplit</h1>
    <hr class="solid">
    <section class="invulFormulier">
        <form>
            <h2>Voeg Toe</h2>
            <div class="invulVeld">
                <label for="naam"></label>
                <input type="text" name="naam" required="required" id="naam">
                <span>Naam</span>
            </div>
            <div class="invulVeld">
                <label for="activiteit"></label>
                <input type="text" name="activiteit" required="required" id="activiteit">
                <span>Activiteit</span>
            </div>
            <div class="invulVeld">
                <label for="geld"></label>
                <input type="text" name="geld" required="required" id="geld">
                <span>#Geld</span>
            </div>
            <div class="invulVeld">
                <label for="datum"></label>
                <input type="text" name="datum" required="required" id="datum">
                <span>Datum</span>
            </div>
            <div class="invulVeld">
                <input type="submit" name="verstuur" value="Verstuur">
            </div>
        </form>
    </section>
</main>
<footer>
    <p>Created by Lauwers Ernest. © 2022</p>
</footer>
</body>
</html>