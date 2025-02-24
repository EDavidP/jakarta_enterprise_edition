
package artifact;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.1
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "MyServiceSOAPService", targetNamespace = "http://book/", wsdlLocation = "http://localhost:8080/soap/MyServiceSOAP?wsdl")
public class MyServiceSOAPService
    extends Service
{

    private final static URL MYSERVICESOAPSERVICE_WSDL_LOCATION;
    private final static WebServiceException MYSERVICESOAPSERVICE_EXCEPTION;
    private final static QName MYSERVICESOAPSERVICE_QNAME = new QName("http://book/", "MyServiceSOAPService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/soap/MyServiceSOAP?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MYSERVICESOAPSERVICE_WSDL_LOCATION = url;
        MYSERVICESOAPSERVICE_EXCEPTION = e;
    }

    public MyServiceSOAPService() {
        super(__getWsdlLocation(), MYSERVICESOAPSERVICE_QNAME);
    }

    public MyServiceSOAPService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MYSERVICESOAPSERVICE_QNAME, features);
    }

    public MyServiceSOAPService(URL wsdlLocation) {
        super(wsdlLocation, MYSERVICESOAPSERVICE_QNAME);
    }

    public MyServiceSOAPService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MYSERVICESOAPSERVICE_QNAME, features);
    }

    public MyServiceSOAPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MyServiceSOAPService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MyServiceSOAP
     */
    @WebEndpoint(name = "MyServiceSOAPPort")
    public MyServiceSOAP getMyServiceSOAPPort() {
        return super.getPort(new QName("http://book/", "MyServiceSOAPPort"), MyServiceSOAP.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MyServiceSOAP
     */
    @WebEndpoint(name = "MyServiceSOAPPort")
    public MyServiceSOAP getMyServiceSOAPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://book/", "MyServiceSOAPPort"), MyServiceSOAP.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MYSERVICESOAPSERVICE_EXCEPTION!= null) {
            throw MYSERVICESOAPSERVICE_EXCEPTION;
        }
        return MYSERVICESOAPSERVICE_WSDL_LOCATION;
    }

}
