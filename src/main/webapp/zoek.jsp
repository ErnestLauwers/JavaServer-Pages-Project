<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <c:if test="${not empty naamFout}">
    <div class="fout">
      <p>${naamFout}</p>
    </div>
  </c:if>
  <section class="invulFormulier">
    <form action="Controller?command=zoekOpNaam" method="post" novalidate>
      <h2>Zoek een persoon</h2>
      <div class="invulVeld">
        <label for="naamZ"></label>
        <input type="text" name="naam" id="naamZ">
        <span>Naam</span>
      </div>
      <input type="hidden" name="command" value="Zoek">
      <div class="invulVeld">
        <input type="submit" name="zoek" value="Zoek" id="submit">
      </div>
    </form>
  </section>
</main>
<footer>
  <p>Created by Lauwers Ernest. © 2022</p>
</footer>
</body>
</html>