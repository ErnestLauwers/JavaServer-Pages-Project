package domain;

import java.util.ArrayList;
import java.util.List;

public class BedragenDB {
    private int sequence = 0;
    private final List<Bedrag> bedragen = new ArrayList<>();
    private Bedrag bedrag;

    public BedragenDB () {
        this.add(new Bedrag("Ernest", "Supermarkt", 81.67, "21/04/2021"));
        this.add(new Bedrag("Oscar", "MacDonalds", 32.89, "22/04/2021"));
    }

    public void add (Bedrag bedrag) {
        this.sequence++;
        bedrag.setId(sequence);
        bedragen.add(bedrag);
    }

    public List<Bedrag> getBedragen() {
        return bedragen;
    }

    public void veranderBedrag (String naam, String activiteit, int aantal, String datum, Bedrag bedrag) {
        this.bedrag.SetNaam(naam);
        this.bedrag.SetActiviteit(activiteit);
        this.bedrag.SetAantal(aantal);
        this.bedrag.SetDatum(datum);
    }
}