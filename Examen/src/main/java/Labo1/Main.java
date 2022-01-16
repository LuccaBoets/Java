package Labo1;

import Labo1.AlcoholischeDrank;
import Labo1.Cafe;
import Labo1.NietAlcoholischeDrank;

public class Main {

    public static void main(String[] args) {

        Cafe cafe = new Cafe();

        cafe.addDrankLijst(new AlcoholischeDrank(3.5,"Bier",5.3));
        cafe.addDrankLijst(new AlcoholischeDrank(5,"Wijn",14.5));
        cafe.addDrankLijst(new NietAlcoholischeDrank(5,"acoke",true));



        cafe.show();
    }
}
