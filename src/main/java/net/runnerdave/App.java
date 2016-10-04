package net.runnerdave;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import net.runnerdave.entity.Geek;
import net.runnerdave.entity.IdCard;
import net.runnerdave.entity.Person;
import net.runnerdave.entity.Phone;


/**
 * Basic jpa setup app
 *
 */
public class App 
{
	private static final Logger LOGGER = Logger.getLogger("JPA");

	public static void main(String[] args) {
		App main = new App();
		main.run();
	}

	public void run() {
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		try {
			factory = Persistence.createEntityManagerFactory("PersistenceUnit");
			entityManager = factory.createEntityManager();
			persistPerson(entityManager);
			persistGeek(entityManager);
			loadPersons(entityManager);
		} catch (Exception e) {
			LOGGER.log(Level.FINEST, e.getMessage(), e);
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
			if (factory != null) {
				factory.close();
			}
		}
	}
	
	private void persistPerson(EntityManager entityManager) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Person person = new Person();
			person.setFirstName("Lisa");
			person.setLastName("Simpson");
			entityManager.persist(person);
//			IdCard idCard = new IdCard();
//			idCard.setIdNumber("4711");
//			idCard.setIssueDate(new Date());
//			person.setIdCard(idCard);
//			entityManager.persist(idCard);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
	private void persistGeek(EntityManager entityManager) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Geek geek = new Geek();
		geek.setFirstName("Gavin");
		geek.setLastName("Coffee");
		geek.setFavouriteProgrammingLanguage("Java");
		entityManager.persist(geek);
		geek = new Geek();
		geek.setFirstName("Thomas");
		geek.setLastName("Micro");
		geek.setFavouriteProgrammingLanguage("C#");
		entityManager.persist(geek);
		geek = new Geek();
		geek.setFirstName("Christian");
		geek.setLastName("Cup");
		geek.setFavouriteProgrammingLanguage("Java");
		entityManager.persist(geek);
		transaction.commit();
	}
	
	private void loadPersons(EntityManager entityManager) {
		entityManager.clear();
		//TypedQuery<Person> query = entityManager.createQuery("from Person p left join fetch p.phones", Person.class);
		TypedQuery<Person> query = entityManager.createQuery("from Person", Person.class);
		List<Person> resultList = query.getResultList();
		for (Person person : resultList) {
			StringBuilder sb = new StringBuilder();
			sb.append(person.getFirstName()).append(" ").append(person.getLastName());
			if (person instanceof Geek) {
				Geek geek = (Geek)person;
				sb.append(" ").append(geek.getFavouriteProgrammingLanguage());
			}
//			IdCard idCard = person.getIdCard();
//			if (idCard != null) {
//				sb.append(" ").append(idCard.getIdNumber()).append(" ").append(idCard.getIssueDate());
//			}
//			List<Phone> phones = person.getPhones();
//			for (Phone phone : phones) {
//				sb.append(" ").append(phone.getNumber());
//			}
			LOGGER.info(sb.toString());
		}
	}
}
