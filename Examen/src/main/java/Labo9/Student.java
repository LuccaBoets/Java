package Labo9;

import javax.persistence.*;

@Entity
@Table(name = "TblStudent")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String naam;

    @Column(name = "mail")
    private String mail;

    public Student() {
    }

    public Student(int id, String naam, String mail) {
        this.id = id;
        this.naam = naam;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
