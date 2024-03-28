package book;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import beans.IEJBPublications;
import book.Publication;

@RequestScoped
@Path("/myservice")
@Produces(MediaType.APPLICATION_JSON)
public class MyServiceREST {
    
    @EJB
    private IEJBPublications managePublications;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Publication> method1() {
        System.out.println("M1 executing....");

        List<Publication> list = managePublications.getInfotmationAboutPublications();

        return list;
    }

    @GET
    @Path("/title")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Publication> method2(@QueryParam("publicationTitle")String value) {
        System.out.println("M2 executing... args= " + value);

        List<Publication> list = managePublications.getInfotmationAboutPublicationsByTitle(value);

        return list;
    }
    
    @GET
    @Path("/author")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Publication> method3(@QueryParam("authorName")String value) {
        System.out.println("M3 executing... args= " + value);

        List<Publication> list = managePublications.getInfotmationAboutPublicationsByAuthor(value);

        return list;
    }   
    
    @GET
    @Path("/journal")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Publication> method4(@QueryParam("newsletterName")String value) {
        System.out.println("M3 executing... args= " + value);

        List<Publication> list = managePublications.getInfotmationAboutPublicationsByJournal(value);

        return list;
    }   

    @GET
    @Path("/authorandjournal")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Publication> method5(@QueryParam("newsletterName")String value1, @QueryParam("authorName")String value2) {
        System.out.println("M3 executing... args= " + value1 + " and args= " + value2);

        List<Publication> list = managePublications.getInfotmationAboutPublicationsByJournalAndAuthor(value2, value1);

        return list;
        }   


}
