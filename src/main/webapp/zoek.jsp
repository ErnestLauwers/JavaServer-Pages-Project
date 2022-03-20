<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Zoek²</title>
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
      <li><a href="Controller?command=overzicht">Overzicht</a></li>
      <li><a href="voegToe.jsp">Voeg Toe</a></li>
      <li class="hier"><a href="Controller?command=zoek">Zoek</a></li>
    </ul>
  </nav>
</header>
<main class="main1">
  <h1>MoneySplit</h1>
  <hr class="solid">
  <section class="invulFormulier">
    <form action="Controller" method="post">
      <h2>Zoek een persoon</h2>
      <div class="invulVeld">
        <label for="naam"></label>
        <input type="text" name="naam" id="naam">
        <span>Naam</span>
      </div>
      <div class="invulVeld">
        <input type="submit" name="zoek" value="Zoek">
      </div>
    </form>
  </section>
</main>
<footer>
  <p>Created by Lauwers Ernest. © 2022</p>
</footer>
</body>
</html>