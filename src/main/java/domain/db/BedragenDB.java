package domain.db;

import domain.model.Bedrag;

import java.util.ArrayList;
import java.util.List;

public class BedragenDB {
    private final ArrayList<Bedrag> bedragen = new ArrayList<Bedrag>();
    private Bedrag bedrag;

    public BedragenDB () {
        this.add(new Bedrag("Ernest", "Supermarkt", 81, "21/04/2021"));
        this.add(new Bedrag("Oscar", "McDonalds", 32, "22/04/2021"));
        this.add(new Bedrag("Judith", "Museum", 43, "23/04/2021"));
    }

    public String meestBetalendePersoon() {
        int meestB = bedragen.get(0).getAantal();
        String meestN = bedragen.get(0).getNaam();
        for (int i = 1; i < bedragen.size(); i++) {
            if (bedragen.get(i).getAantal() > meestB) {
                meestN = bedragen.get(i).getNaam();
            }
        }
        return meestN;
    }

    public void add (Bedrag bedrag) {
        bedragen.add(bedrag);
    }

    public ArrayList<Bedrag> getBedragen() {
        return bedragen;
    }

    public void veranderBedrag (String naam, String activiteit, int aantal, String datum, Bedrag bedrag) {
        this.bedrag.SetNaam(naam);
        this.bedrag.SetActiviteit(activiteit);
        this.bedrag.SetAantal(aantal);
        this.bedrag.SetDatum(datum);
    }
}