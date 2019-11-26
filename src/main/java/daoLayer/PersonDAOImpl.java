package daoLayer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Person;

public class PersonDAOImpl  implements PersonDAO{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public void save(Person p) {
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.persist(p);
		
	}
	public List<Person> list() {
		Session session=this.sessionFactory.openSession();
		List<Person> personList=session.createQuery("from Persion").list();
		return personList;
	}

}
