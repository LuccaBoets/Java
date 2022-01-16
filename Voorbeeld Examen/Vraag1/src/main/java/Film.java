import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "TblStudent")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int showId;

    @Column(name = "title")
    private String title;

    @Column(name = "directeur")
    private String directeur;

    @Column(name = "country")
    private String country;

    @Column(name = "releaseYear")
    private int releaseYear;

    @Column(name = "description")
    private String description;

    public Film() {
    }

    public Film(int showId, String title, String directeur, String country, int releaseYear, String description) {
        this.showId = showId;
        this.title = title;
        this.directeur = directeur;
        this.country = country;
        this.releaseYear = releaseYear;
        this.description = description;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public String getDirecteur() {
        return directeur;
    }

    public void setDirecteur(String directeur) {
        this.directeur = directeur;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Film{" +
                "showId=" + showId +
                ", title='" + title + '\'' +
                ", directeur='" + directeur + '\'' +
                ", country='" + country + '\'' +
                ", releaseYear=" + releaseYear +
                ", description='" + description + '\'' +
                '}';
    }
}
