import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilmAOD {

    private static SessionFactory sessionFactory;

    public FilmAOD() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void importCSVFile(String naam){
        List<Film> films = new ArrayList<>();

        try {
            File inputF = new File(naam);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            films = br.lines().skip(1).map(l -> mapToFilm(l)).filter(x -> x != null).collect(Collectors.toList());
            br.close();
            Set<String> ingredients = new HashSet<>();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("length " + films.size());
        for (Film film: films) {
            addFilm(film);
        }
    }

    private Film mapToFilm(String input) throws IndexOutOfBoundsException{
        String[] items = input.split(";");
        System.out.println(input);

        if (items.length >= 12){
            if (!items[1].equals("Movie")){
                return null;
            }
            return new Film(Integer.parseInt(items[0]),items[2],items[3],items[5],Integer.parseInt(items[7]),items[11]);
        }

        return null;
    }

    public void addFilm(Film film){
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(film);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Film> listFilms(){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Query<Film> query = session.createQuery("SELECT e FROM Film e", Film.class);
            return query.getResultList();

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }

    public List<Film> SelectByYear(int year){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Film> query = builder.createQuery(Film.class);
            Root<Film> root = query.from(Film.class);
            query.where(builder.equal(root.get("releaseYear"),year));
            Query<Film> q = session.createQuery(query);
            return q.getResultList();

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }


    public List<Film> SelectByName(String name){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Film> query = builder.createQuery(Film.class);
            Root<Film> root = query.from(Film.class);
            query.where(builder.like(root.get("title"), name));

            Query<Film> q = session.createQuery(query);
            return q.getResultList();

        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return null;
    }
}
