package Labo1;

public class AlcoholischeDrank extends Drank {

    public double percentage;

    public AlcoholischeDrank(double prijs, String naam, double percentage) {
        super(prijs, naam);
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "AlcoholischeDrank{" +
                "percentage=" + percentage +
                ", prijs=" + super.getPrijs() +
                ", naam='" + super.getNaam() + '\'' +
                '}';
    }
}
