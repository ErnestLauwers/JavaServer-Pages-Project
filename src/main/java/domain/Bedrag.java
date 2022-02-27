package domain;

public class Bedrag {
    private int id;
    private String naam;
    private String activiteit;
    private double aantal;
    private String datum;

    public Bedrag (String naamB, String activiteitB, double aantalB, String datumB) {
        this.SetNaam(naamB);
        this.SetActiviteit(activiteitB);
        this.SetAantal(aantalB);
        this.SetDatum(datumB);
    }

    public void setId(int idGetal) {
        this.id = idGetal;
    }

    public void SetNaam (String naamB) {
        if (naamB == null || naamB.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.naam = naamB;
    }

    public void SetActiviteit (String activiteitB) {
        if (activiteitB == null || activiteitB.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.activiteit = activiteitB;
    }

    public void SetAantal (double aantalB) {
        if (aantalB <= 0) {
            throw new IllegalArgumentException();
        }
        this.aantal = aantalB;
    }

    public void SetDatum (String datumB) {
        if (datumB == null || datumB.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.datum = datumB;
    }

    public String getNaam() {
        return this.naam;
    }

    public String getActiviteit() {
        return this.activiteit;
    }

    public double getAantal() {
        return this.aantal;
    }

    public String getDatum() {
        return this.datum;
    }
}