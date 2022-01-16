package Labo1;

public abstract class Drank implements Comparable<Drank> {

    private double prijs;
    private String naam;

    public Drank(double prijs, String naam) {
        this.prijs = prijs;
        this.naam = naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return "Drank{" +
                "prijs=" + prijs +
                ", naam='" + naam + '\'' +
                '}';
    }
    

    @Override
    public int compareTo(Drank drank) {
        if (Double.compare(this.prijs, drank.getPrijs()) == 0){
            return this.naam.compareTo(drank.getNaam());
        }
        return Double.compare(this.prijs, drank.getPrijs());
    }
}
