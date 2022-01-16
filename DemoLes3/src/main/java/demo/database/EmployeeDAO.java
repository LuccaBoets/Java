package demo.database;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import demo.model.Employee;

public class EmployeeDAO {
	private static SessionFactory factory;

	public EmployeeDAO() {
		try {
			//could also be
			// factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

	}

	/* Method to CREATE an employee in the database */
	public Integer addEmployee(String fname, String lname, int salary) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {
			tx = session.beginTransaction();
			Employee employee = new Employee(fname, lname, salary);
			employeeID = (Integer) session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	}

	/* Method to READ all the employees having salary more than 2000 */
	public void listEmployees() {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Count distinct employees
			CriteriaQuery<Long> criteriaQuery4 = builder.createQuery(Long.class);
			Root<Employee> root4 = criteriaQuery4.from(Employee.class);
			criteriaQuery4.select(builder.countDistinct(root4));
			Query<Long> query4 = session.createQuery(criteriaQuery4);
			long distinct = query4.getSingleResult();
			System.out.println("Distinct count = " + distinct);

			CriteriaQuery<Employee> query5 = builder.createQuery(Employee.class);
			Root<Employee> root5 = query5.from(Employee.class);
			query5.where(builder.and(builder.greaterThan(root5.get("salary"), 2000),
					builder.equal(root5.get("firstName"), "Daisy")));
			Query<Employee> q = session.createQuery(query5);
			List<Employee> employees = q.getResultList();

			Query<Employee> query = session.createQuery("SELECT e FROM Employee e", Employee.class);
			List<Employee> results = query.getResultList();

			transaction.commit();

			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.print("First Name: " + employee.getFirstName());
				System.out.print("  Last Name: " + employee.getLastName());
				System.out.println("  Salary: " + employee.getSalary());
			}
		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to print total number of records */
	public void countEmployee() {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Count number of employees
			CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
			Root<Employee> root = criteriaQuery.from(Employee.class);
			criteriaQuery.select(builder.count(root));
			Query<Long> query = session.createQuery(criteriaQuery);
			long count = query.getSingleResult();
			System.out.println("Count = " + count);

			// To get total row count.
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to print sum of salaries */
	public void totalSalary() {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			CriteriaBuilder builder = session.getCriteriaBuilder();
			// Get max salary
			CriteriaQuery<Integer> criteriaQuery2 = builder.createQuery(Integer.class);
			Root<Employee> root2 = criteriaQuery2.from(Employee.class);
			criteriaQuery2.select(builder.max(root2.get("salary")));
			Query<Integer> query2 = session.createQuery(criteriaQuery2);
			int maxSalary = query2.getSingleResult();
			System.out.println("Max Salary = " + maxSalary);

			// Get Average Salary
			CriteriaQuery criteriaQuery3 = builder.createQuery();
			Root<Employee> root3 = criteriaQuery3.from(Employee.class);
			criteriaQuery3.select(builder.avg(root3.get("salary"))).from(Employee.class);

			Query<Double> query3 = session.createQuery(criteriaQuery3);

			double avgSalary = query3.getSingleResult();

			System.out.println("Average Salary = " + avgSalary);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void close() {
		factory.close();
	}
}
