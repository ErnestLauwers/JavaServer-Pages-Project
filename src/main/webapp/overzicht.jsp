<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Overzicht</title>
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
            <li><a href="voegToe.jsp">Voeg Toe</a></li>
            <li class="hier"><a href="overzicht.jsp">Overzicht</a></li>
        </ul>
    </nav>
</header>
<main>
    <h1>MoneySplit</h1>
    <hr class="solid">
    <table>
        <thead>
        <tr class="woorden">
            <th>ID</th>
            <th>Naam</th>
            <th>Activiteit</th>
            <th>#Geld</th>
            <th>Datum</th>
        </tr>
        <tr>
            <th>1</th>
            <th>Ernest</th>
            <th>Supermarkt</th>
            <th>81.67</th>
            <th>21/04/2021</th>
            <th class="wijzig"><img src="img/wijzig.png" alt="Wijzigen"> </th>
            <th class="verwijder"><img src="img/verwijder.png" alt="Delete"> </th>
        </tr>
        <tr>
            <th>2</th>
            <th>Oscar</th>
            <th>MacDonalds</th>
            <th>32.89</th>
            <th>22/04/2021</th>
            <th class="wijzig"><img src="img/wijzig.png" alt="Wijzigen"> </th>
            <th class="verwijder"><img src="img/verwijder.png" alt="Delete"> </th>
        </tr>
        <tr>
            <th>3</th>
            <th>Jasper</th>
            <th>Café</th>
            <th>23.99</th>
            <th>22/04/2021</th>
            <th class="wijzig"><img src="img/wijzig.png" alt="Wijzigen"> </th>
            <th class="verwijder"><img src="img/verwijder.png" alt="Delete"> </th>
        </tr>
        <tr>
            <th>4</th>
            <th>Lies</th>
            <th>Restaurant</th>
            <th>45.50</th>
            <th>23/04/2021</th>
            <th class="wijzig"><img src="img/wijzig.png" alt="Wijzigen"> </th>
            <th class="verwijder"><img src="img/verwijder.png" alt="Verwijderen"> </th>
        </tr>
        </thead>
    </table>
</main>
<footer>
    <p>Created by Lauwers Ernest. © 2022</p>
</footer>
</body>
</html>