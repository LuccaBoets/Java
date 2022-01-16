import java.util.Date;

public class Main {
    public static void main(String[] args) {

        FilmAOD manager = new FilmAOD();

        Film film1 = new Film(1,"titanic","idk","america", 1978, "boooot");

        manager.importCSVFile("../netflix_titles.csv");

        System.out.println(manager.listFilms().size());

//        System.out.println(manager.SelectByYear(1999));
        System.out.println(manager.SelectByName("%Fr%"));
    }
}
