package Labo7;

import Labo7.Person;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println(names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        List<Person> lectorenLijst = new ArrayList<>();
        lectorenLijst.add(new Person("Kelly", "Casal", "kelly.casalmosteiro@ap.be"));
        lectorenLijst.add(new Person("Olga", "Coutrin", "olga.coutrin@ap.be"));
        lectorenLijst.add(new Person("Philippe", "Possemiers", "philippe.possemiers@ap.be"));

        System.out.println("\n=== E-Mail ===");
        lectorenLijst.forEach(x -> System.out.println(x.getEmail()));

        System.out.println("\n=== print Name with stream ===");
        lectorenLijst.stream().filter(x -> x.getEmail().equals("philippe.possemiers@ap.be")).forEach(x -> System.out.println(x.getName()));
    }
}
