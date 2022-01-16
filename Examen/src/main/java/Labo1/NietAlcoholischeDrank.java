package Labo1;

public class NietAlcoholischeDrank extends Drank {

    public boolean isBruis;

    public NietAlcoholischeDrank(double prijs, String naam, boolean isBruis) {
        super(prijs, naam);
        this.isBruis = isBruis;
    }

    public boolean isBruis() {
        return isBruis;
    }

    public void setBruis(boolean bruis) {
        isBruis = bruis;
    }

    @Override
    public String toString() {
        return "NietAlcoholischeDrank{" +
                "isBruis=" + isBruis +
                ", prijs=" + super.getPrijs() +
                ", naam='" + super.getNaam() + '\'' +
                '}';
    }
}
