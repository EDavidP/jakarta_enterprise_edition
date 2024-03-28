package beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import book.Publication;


@Stateless
public class EJBPublications implements IEJBPublications{

	@PersistenceContext(unitName="testPersistence")
	private EntityManager em;

	public EJBPublications() {
		
	}

//	Obtain all stored data about publications.
	public List<Publication> getInfotmationAboutPublications() {
		String jpql = "SELECT p FROM Publication p";
		TypedQuery<Publication> typedQuery = em.createQuery(jpql, Publication.class);
		List<Publication> publications = typedQuery.getResultList();
		return publications;
	}
	
//	Given a publication title, obtain all associated data.
	public List<Publication> getInfotmationAboutPublicationsByTitle(String publicationTitle) {
		String jpql = "SELECT p FROM Publication p where lower(p.title) like :xpto";
		TypedQuery<Publication> typedQuery = em.createQuery(jpql, Publication.class);
		typedQuery.setParameter("xpto", "%"+publicationTitle.toLowerCase()+"%");
		List<Publication> publications = typedQuery.getResultList();
		return publications;
	}
	
//	Given a researcher name, obtain all the publications s/he authored.
	public List<Publication> getInfotmationAboutPublicationsByAuthor(String authorName) {
		String jpql = "SELECT p FROM Publication p WHERE :xpto MEMBER OF p.authors";
		TypedQuery<Publication> typedQuery = em.createQuery(jpql, Publication.class);
		typedQuery.setParameter("xpto", authorName);
		List<Publication> publications = typedQuery.getResultList();
		return publications;
	}
	
//	Given a journal or conference name, obtain all associated publications
	public List<Publication> getInfotmationAboutPublicationsByJournal(String NewsletterName) {
		String jpql = "SELECT p FROM Publication p WHERE lower(p.newsletter) like :xpto";
		TypedQuery<Publication> typedQuery = em.createQuery(jpql, Publication.class);
		typedQuery.setParameter("xpto", "%"+NewsletterName.toLowerCase()+"%");
		List<Publication> publications = typedQuery.getResultList();
		return publications;
	}
		
//	Given a journal or conference name and researcher name, obtain all associated publications.
	public List<Publication> getInfotmationAboutPublicationsByJournalAndAuthor(String authorName, String NewsletterName) {
		String jpql = "SELECT p FROM Publication p WHERE lower(p.newsletter) like :xpto1 AND :xpto2 MEMBER OF p.authors";
		TypedQuery<Publication> typedQuery = em.createQuery(jpql, Publication.class);
		typedQuery.setParameter("xpto1", "%"+NewsletterName.toLowerCase()+"%").setParameter("xpto2",authorName);
		List<Publication> publications = typedQuery.getResultList();
		return publications;
	}
}
