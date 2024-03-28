package beans;

import java.util.List;

import javax.ejb.Remote;

import book.Publication;

@Remote
public interface IEJBPublications {

	public List<Publication> getInfotmationAboutPublications();

	public List<Publication> getInfotmationAboutPublicationsByTitle(String publicationTitle);

	public List<Publication> getInfotmationAboutPublicationsByAuthor(String authorName);

	public List<Publication> getInfotmationAboutPublicationsByJournal(String newsletterName);

	public List<Publication> getInfotmationAboutPublicationsByJournalAndAuthor(String authorName, String newsletterName);
}
