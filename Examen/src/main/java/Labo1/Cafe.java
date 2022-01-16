package Labo1;

import java.util.ArrayList;
import java.util.Collections;

public class Cafe {

    public ArrayList<Drank> drankLijst;

    public Cafe(ArrayList<Drank> drankLijst) {
        this.drankLijst = drankLijst;
    }

    public Cafe() {
        drankLijst = new ArrayList<Drank>();
    }

    public void show(){
        Collections.sort(drankLijst);

        for (Drank drank: drankLijst) {
            System.out.println(drank.toString());
        }
    }

    public void addDrankLijst(Drank drank) {
        this.drankLijst.add(drank);
    }

    public ArrayList<Drank> getDrankLijst() {
        return drankLijst;
    }

    public void setDrankLijst(ArrayList<Drank> drankLijst) {
        this.drankLijst = drankLijst;
    }
}
