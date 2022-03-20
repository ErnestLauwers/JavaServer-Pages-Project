<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.model.Bedrag" %>
<%@ page import="domain.db.BedragenDB" %>
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
            <li><a href="Controller?command=home">Home</a></li>
            <li class="hier"><a href="Controller?command=overzicht">Overzicht</a></li>
            <li><a href="voegToe.jsp">Voeg Toe</a></li>
            <li><a href="Controller?command=zoek">Zoek</a></li>
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
        </thead>
        <tbody>
        <% ArrayList<Bedrag> bedragen = (ArrayList<Bedrag>) request.getAttribute("bedragen"); %>
        <%
            int id = 0;
            for (Bedrag bedrag : bedragen) {
                id++;
        %>
        <tr>
            <td><%= id %></td>
            <td><%= bedrag.getNaam() %></td>
            <td><%= bedrag.getActiviteit() %></td>
            <td><%= bedrag.getAantal() %></td>
            <td><%= bedrag.getDatum() %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <p class="meestBetalende">De persoon die het hoogste bedrag in één keer heeft betaald is:</p>
    <p class="meestBetalendeNaam"><%= request.getAttribute("meestBetalende")%></p>
</main>
<footer>
    <p>Created by Lauwers Ernest. © 2022</p>
</footer>
</body>
</html>