package book;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import beans.IEJBResearchers;

@WebService
public class MyServiceSOAP {
    
    @EJB
    private IEJBResearchers manageResearchers;

    @WebMethod
    public List<Researcher> getInfotmationAboutResearchers() {
        System.out.println("getInfotmationAboutResearchers executing....");

        return manageResearchers.getInfotmationAboutResearchers();
    }

    @WebMethod
    public List<Researcher> getInfotmationAboutResearchersByName(String name) {
        System.out.println("getInfotmationAboutResearchersByName executing....");

        return manageResearchers.getInfotmationAboutResearchersByName(name);
    }
    
    @WebMethod
    public List<Researcher> getInfotmationAboutResearchersByInterest(String interest) {
        System.out.println("getInfotmationAboutResearchersByName executing....");

        return manageResearchers.getInfotmationAboutResearchersByInterest(interest);
    }   
}
