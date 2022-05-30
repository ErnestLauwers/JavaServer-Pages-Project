package domain.db;

import domain.model.Bedrag;

import java.util.ArrayList;
import java.util.List;

public class BedragenDB {
    private final ArrayList<Bedrag> bedragen = new ArrayList<Bedrag>();
    private int nieuwId = 0;
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
        if (bedrag == null) {
            throw new IllegalArgumentException("Bedrag mag niet leeg zijn.");
        }
        this.nieuwId++;
        bedrag.SetId(nieuwId);
        bedragen.add(bedrag);
    }

    public ArrayList<Bedrag> getBedragen() {
        return bedragen;
    }

    public void veranderBedrag (int id, Bedrag bedragW) {
        bedragen.removeIf(i -> i.getId() == id);
        add(bedragW);
        bedragW.SetId(id);
        nieuwId--;
    }

    public void verwijderBedrag (int id) {
        Bedrag bedragVerwijder = bedragId(id);
        if (bedragVerwijder == null) {
            throw new IllegalArgumentException("Dit bedrag kan niet null zijn.");
        }
        bedragen.remove(bedragVerwijder);
    }

    public Bedrag bedragId (int id) {
        for (int i = 0; i < bedragen.size(); i++) {
            if (bedragen.get(i).getId() == id) {
                return bedragen.get(i);
            }
        }
        return null;
    }

    public List<Bedrag> zoekNaamBedrag (String naamB) {
        List<Bedrag> lijst = new ArrayList<>();
        for (Bedrag i : bedragen) {
            if (i.getNaam().equals(naamB)) {
                lijst.add(i);
            }
        }
        return lijst;
    }
}