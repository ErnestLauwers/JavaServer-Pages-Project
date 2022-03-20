package domain.model;

import org.w3c.dom.DOMException;

public class Bedrag {
    private String naam;
    private String activiteit;
    private int aantal;
    private String datum;

    public Bedrag () {}

    public Bedrag (String naamB, String activiteitB, int aantalB, String datumB) {
        this.SetNaam(naamB);
        this.SetActiviteit(activiteitB);
        this.SetAantal(aantalB);
        this.SetDatum(datumB);
    }

    public void SetNaam (String naamB) {
        if (naamB == null || naamB.isEmpty()) {
            throw new IllegalArgumentException("Naam mag niet leeg zijn.");
        }
        this.naam = naamB;
    }

    public void SetActiviteit (String activiteitB) {
        if (activiteitB == null || activiteitB.isEmpty()) {
            throw new IllegalArgumentException("Activiteit mag niet leeg zijn.");
        }
        this.activiteit = activiteitB;
    }

    public void SetAantal (int aantalB) {
        if (aantalB == 0) {
            throw new IllegalArgumentException("Het aantal euro mag niet gelijk zijn aan nul.");
        } else if (aantalB < 0) {
            throw new IllegalArgumentException("Het aantal euro mag niet negatief zijn.");
        }
        this.aantal = aantalB;
    }

    public void SetAantal (String aantalC) {
        if (aantalC.isBlank() || aantalC == null) throw new IllegalArgumentException("Het aantal euro mag niet leeg zijn.");
        int probeer;
        try {
            probeer = Integer.parseInt(aantalC);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Dit veld moet een numerieke waarde hebben.");
        }
        SetAantal(probeer);
    }


    public void SetDatum (String datumB) {
        if (datumB == null || datumB.isEmpty()) {
            throw new IllegalArgumentException("Datum mag niet leeg zijn.");
        }
        this.datum = datumB;
    }

    public String getNaam() {
        return this.naam;
    }

    public String getActiviteit() {
        return this.activiteit;
    }

    public int getAantal() {
        return this.aantal;
    }

    public String getDatum() {
        return this.datum;
    }
}