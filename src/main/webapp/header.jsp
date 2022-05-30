<nav>
    <p class="logo"><a href="Controller?command=home">M/S</a></p>
    <ul>
        <li ${param.hier eq 'Home'?"class = hier":""}><a href="Controller?command=home">Home</a></li>
        <li ${param.hier eq 'Overzicht'?"class = hier":""}><a href="Controller?command=overzicht">Overzicht</a></li>
        <li ${param.hier eq 'Voeg Toe'?"class = hier":""}><a href="Controller?command=voegToeMain">Voeg Toe</a></li>
        <li ${param.hier eq 'Zoek'?"class = hier":""}><a id="linkZoek" href="Controller?command=zoek">Zoek</a></li>
    </ul>
</nav>