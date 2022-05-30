package ui.controller;

import domain.db.BedragenDB;
import domain.model.Bedrag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;


@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private final BedragenDB dataBank = new BedragenDB();

    public Controller() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = "home";
        if (request.getParameter("command") != null) {
            command = request.getParameter("command");
        }
        String destination;
        switch (command) {
            case "home":
                destination = home(request, response);
                break;
            case "overzicht":
                destination = overzicht(request, response);
                break;
            case "meestBetalende":
                destination = meestBetalende(request, response);
                break;
            case "voegToe":
                destination = voegToe(request, response);
                break;
            case "voegToeMain":
                destination = voegToeMain(request, response);
                break;
            case "zoek":
                destination = zoek(request, response);
                break;
            case "zoekOpNaam":
                destination = zoekOpNaam(request, response);
                break;
            case "verwijderBedrag":
                destination = verwijderBedrag(request, response);
                break;
            case "wijzigMain":
                destination = wijzigMain(request, response);
                break;
            case "wijzigen":
                destination = wijzigen(request, response);
                break;
            case "wijzigOpnieuw":
                destination = wijzigOpnieuw(request, response);
                break;
            case "verwijderen":
                destination = verwijderen(request, response);
                break;
            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Cookie cookie = getCookieMetKey(request, "idOud");
        if (cookie != null) {
            String id = URLDecoder.decode(cookie.getValue(), "UTF-8");
            Bedrag bedragOud = dataBank.bedragId(Integer.parseInt(id));
            if (bedragOud != null) request.setAttribute("oudBedrag", bedragOud);
            else request.setAttribute("verwijderd", "Het bedrag met id " + id + " is verwijderd.");
        }
        request.setAttribute("meestBetalende", dataBank.meestBetalendePersoon());
        return "index.jsp";
    }

    private String meestBetalende(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("meestBetalende", dataBank.meestBetalendePersoon());
        return "meestBetalende.jsp";
    }

    private String wijzigOpnieuw(HttpServletRequest request, HttpServletResponse response) {
        Bedrag oudeBedrag = (Bedrag) request.getSession().getAttribute("gewijzigdeBedrag");
        int nieuweId = (int) request.getSession().getAttribute("nieuweId");
        dataBank.veranderBedrag(nieuweId, oudeBedrag);
        request.getSession().removeAttribute("gewijzigdeBedrag");
        return overzicht(request, response);
    }

    private String wijzigMain(HttpServletRequest request, HttpServletResponse response) {
        String bedragW = request.getParameter("bedrag");
        int id = Integer.parseInt(bedragW);
        request.setAttribute("MoetWijzigen", dataBank.bedragId(id));
        return "wijzig.jsp";
    }

    private String wijzigen(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();
        String bedragId = request.getParameter("bedrag");
        int id = Integer.parseInt(bedragId);
        Bedrag bedragW = new Bedrag();
        setNaam(bedragW, request, errors);
        setActiviteit(bedragW, request, errors);
        setAantal(bedragW, request, errors);
        setDatum(bedragW, request, errors);
        HttpSession session = request.getSession();
        Bedrag oudOud = dataBank.bedragId(id);
        session.setAttribute("gewijzigdeBedrag", oudOud);
        session.setAttribute("nieuweId", oudOud.getId());
        try {
            Bedrag oudeBedrag = dataBank.bedragId(id);
            if (errors.isEmpty()) {
                dataBank.veranderBedrag(id, bedragW);
                request.setAttribute("MoetWijzigen", dataBank.getBedragen());
                Cookie c = new Cookie("idOud", URLEncoder.encode(bedragId, "UTF-8"));
                c.setMaxAge(-1);
                response.addCookie(c);
                return overzicht(request, response);
            }
            else {
                request.setAttribute("errors", errors);
                request.setAttribute("oudeBedrag", oudeBedrag);
                return "wijzig.jsp";
            }
        } catch (IllegalArgumentException | UnsupportedEncodingException exc) {
            return overzicht(request, response);
        }
    }

    private String zoek(HttpServletRequest request, HttpServletResponse response) {
        return "zoek.jsp";
    }

    private String zoekOpNaam(HttpServletRequest request, HttpServletResponse response) {
        String naam = request.getParameter("naam");
        try {
            Bedrag test = new Bedrag();
            test.SetNaam(naam);
        } catch (IllegalArgumentException exc) {
            request.setAttribute("naamFout", exc.getMessage());
            return "zoek.jsp";
        } request.setAttribute("bedragenLijst", dataBank.zoekNaamBedrag(naam));
        request.setAttribute("Naam", naam);
        return "zoekResultaten.jsp";
    }

    private String verwijderen(HttpServletRequest request, HttpServletResponse response) {
        String idVerwijder = request.getParameter("bedrag");
        dataBank.verwijderBedrag(Integer.parseInt(idVerwijder));
        return overzicht(request, response);
    }

    private String verwijderBedrag (HttpServletRequest request, HttpServletResponse response) {
       String bedragV = request.getParameter("bedrag");
       int id = Integer.parseInt(bedragV);
       request.setAttribute("MoetVerwijderen", dataBank.bedragId(id));
       return "verwijder.jsp";
    }

    private String voegToeMain(HttpServletRequest request, HttpServletResponse response) {
        return "voegToe.jsp";
    }

    private String voegToe(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();
        Bedrag bedrag = new Bedrag();
        setNaam(bedrag, request, errors);
        setActiviteit(bedrag, request, errors);
        setAantal(bedrag, request, errors);
        setDatum(bedrag, request, errors);
        if (errors.isEmpty()) {
            dataBank.add(bedrag);
            return overzicht(request, response);
        } else {
            request.setAttribute("errors", errors);
            return "voegToe.jsp";
        }
    }

    private void setNaam(Bedrag bedrag, HttpServletRequest request, ArrayList<String> errors) {
        String naam = request.getParameter("naam");
        try {
            bedrag.SetNaam(naam);
            request.setAttribute("naamFout", naam);
        }
        catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setActiviteit(Bedrag bedrag, HttpServletRequest request, ArrayList<String> errors) {
        String activiteit= request.getParameter("activiteit");
        try {
            bedrag.SetActiviteit(activiteit);
            request.setAttribute("activiteitFout", activiteit);
        }
        catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setAantal(Bedrag bedrag, HttpServletRequest request, ArrayList<String> errors) {
        String aantal = request.getParameter("aantal");
        try {
            bedrag.SetAantal(aantal);
            request.setAttribute("aantalFout", aantal);
        }
        catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setDatum(Bedrag bedrag, HttpServletRequest request, ArrayList<String> errors) {
        String datum = request.getParameter("datum");
        try {
            bedrag.SetDatum(datum);
            request.setAttribute("datumFout", datum);
        }
        catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private String overzicht(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("bedragen", dataBank.getBedragen());
        request.setAttribute("meestBetalende", dataBank.meestBetalendePersoon());
        return "overzicht.jsp";
    }

    private Cookie getCookieMetKey(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;
        for (Cookie c : cookies) {
            if (c.getName().equals(key)) return c;
        }
        return null;
    }
}