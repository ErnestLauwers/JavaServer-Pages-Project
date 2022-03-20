package ui.controller;

import domain.db.BedragenDB;
import domain.model.Bedrag;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private final BedragenDB dataBank = new BedragenDB();

    public Controller() {
        super();
    }

    private String meestBetalende(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("meestBetalende", dataBank.meestBetalendePersoon());
        return "meestBetalende.jsp";
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
            case "zoek":
                destination = zoek(request, response);
                break;
            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String home(HttpServletRequest request, HttpServletResponse response) {
        return "index.jsp";
    }

    private String zoek(HttpServletRequest request, HttpServletResponse response) {
        return "zoek.jsp";
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
}