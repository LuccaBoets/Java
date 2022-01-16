class PersonAOD {

    // hibernate session factory
    private SessionFactory sessionFactory;

    // constructor
    public PersonAOD() {
        // create session factory
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }


}