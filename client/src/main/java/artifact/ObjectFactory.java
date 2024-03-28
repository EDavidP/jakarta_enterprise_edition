
package artifact;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the artifact package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetInfotmationAboutResearchers_QNAME = new QName("http://book/", "getInfotmationAboutResearchers");
    private final static QName _GetInfotmationAboutResearchersByInterest_QNAME = new QName("http://book/", "getInfotmationAboutResearchersByInterest");
    private final static QName _GetInfotmationAboutResearchersByInterestResponse_QNAME = new QName("http://book/", "getInfotmationAboutResearchersByInterestResponse");
    private final static QName _GetInfotmationAboutResearchersByName_QNAME = new QName("http://book/", "getInfotmationAboutResearchersByName");
    private final static QName _GetInfotmationAboutResearchersByNameResponse_QNAME = new QName("http://book/", "getInfotmationAboutResearchersByNameResponse");
    private final static QName _GetInfotmationAboutResearchersResponse_QNAME = new QName("http://book/", "getInfotmationAboutResearchersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: artifact
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetInfotmationAboutResearchers }
     * 
     */
    public GetInfotmationAboutResearchers createGetInfotmationAboutResearchers() {
        return new GetInfotmationAboutResearchers();
    }

    /**
     * Create an instance of {@link GetInfotmationAboutResearchersByInterest }
     * 
     */
    public GetInfotmationAboutResearchersByInterest createGetInfotmationAboutResearchersByInterest() {
        return new GetInfotmationAboutResearchersByInterest();
    }

    /**
     * Create an instance of {@link GetInfotmationAboutResearchersByInterestResponse }
     * 
     */
    public GetInfotmationAboutResearchersByInterestResponse createGetInfotmationAboutResearchersByInterestResponse() {
        return new GetInfotmationAboutResearchersByInterestResponse();
    }

    /**
     * Create an instance of {@link GetInfotmationAboutResearchersByName }
     * 
     */
    public GetInfotmationAboutResearchersByName createGetInfotmationAboutResearchersByName() {
        return new GetInfotmationAboutResearchersByName();
    }

    /**
     * Create an instance of {@link GetInfotmationAboutResearchersByNameResponse }
     * 
     */
    public GetInfotmationAboutResearchersByNameResponse createGetInfotmationAboutResearchersByNameResponse() {
        return new GetInfotmationAboutResearchersByNameResponse();
    }

    /**
     * Create an instance of {@link GetInfotmationAboutResearchersResponse }
     * 
     */
    public GetInfotmationAboutResearchersResponse createGetInfotmationAboutResearchersResponse() {
        return new GetInfotmationAboutResearchersResponse();
    }

    /**
     * Create an instance of {@link Researcher }
     * 
     */
    public Researcher createResearcher() {
        return new Researcher();
    }

    /**
     * Create an instance of {@link Publication }
     * 
     */
    public Publication createPublication() {
        return new Publication();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfotmationAboutResearchers }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetInfotmationAboutResearchers }{@code >}
     */
    @XmlElementDecl(namespace = "http://book/", name = "getInfotmationAboutResearchers")
    public JAXBElement<GetInfotmationAboutResearchers> createGetInfotmationAboutResearchers(GetInfotmationAboutResearchers value) {
        return new JAXBElement<GetInfotmationAboutResearchers>(_GetInfotmationAboutResearchers_QNAME, GetInfotmationAboutResearchers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfotmationAboutResearchersByInterest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetInfotmationAboutResearchersByInterest }{@code >}
     */
    @XmlElementDecl(namespace = "http://book/", name = "getInfotmationAboutResearchersByInterest")
    public JAXBElement<GetInfotmationAboutResearchersByInterest> createGetInfotmationAboutResearchersByInterest(GetInfotmationAboutResearchersByInterest value) {
        return new JAXBElement<GetInfotmationAboutResearchersByInterest>(_GetInfotmationAboutResearchersByInterest_QNAME, GetInfotmationAboutResearchersByInterest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfotmationAboutResearchersByInterestResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetInfotmationAboutResearchersByInterestResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://book/", name = "getInfotmationAboutResearchersByInterestResponse")
    public JAXBElement<GetInfotmationAboutResearchersByInterestResponse> createGetInfotmationAboutResearchersByInterestResponse(GetInfotmationAboutResearchersByInterestResponse value) {
        return new JAXBElement<GetInfotmationAboutResearchersByInterestResponse>(_GetInfotmationAboutResearchersByInterestResponse_QNAME, GetInfotmationAboutResearchersByInterestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfotmationAboutResearchersByName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetInfotmationAboutResearchersByName }{@code >}
     */
    @XmlElementDecl(namespace = "http://book/", name = "getInfotmationAboutResearchersByName")
    public JAXBElement<GetInfotmationAboutResearchersByName> createGetInfotmationAboutResearchersByName(GetInfotmationAboutResearchersByName value) {
        return new JAXBElement<GetInfotmationAboutResearchersByName>(_GetInfotmationAboutResearchersByName_QNAME, GetInfotmationAboutResearchersByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfotmationAboutResearchersByNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetInfotmationAboutResearchersByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://book/", name = "getInfotmationAboutResearchersByNameResponse")
    public JAXBElement<GetInfotmationAboutResearchersByNameResponse> createGetInfotmationAboutResearchersByNameResponse(GetInfotmationAboutResearchersByNameResponse value) {
        return new JAXBElement<GetInfotmationAboutResearchersByNameResponse>(_GetInfotmationAboutResearchersByNameResponse_QNAME, GetInfotmationAboutResearchersByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfotmationAboutResearchersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetInfotmationAboutResearchersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://book/", name = "getInfotmationAboutResearchersResponse")
    public JAXBElement<GetInfotmationAboutResearchersResponse> createGetInfotmationAboutResearchersResponse(GetInfotmationAboutResearchersResponse value) {
        return new JAXBElement<GetInfotmationAboutResearchersResponse>(_GetInfotmationAboutResearchersResponse_QNAME, GetInfotmationAboutResearchersResponse.class, null, value);
    }

}
