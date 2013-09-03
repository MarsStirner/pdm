
package ru.korus.tmis.pdm.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-2b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PDManager_Service", targetNamespace = "http://www.korusconsulting.ru/PDManager/", wsdlLocation = "file:/C:/Project/PDM/war/src/resourses/wsdl/PDManager.wsdl")
public class PDManagerService
    extends Service
{

    private final static URL PDMANAGERSERVICE_WSDL_LOCATION;
    private final static WebServiceException PDMANAGERSERVICE_EXCEPTION;
    private final static QName PDMANAGERSERVICE_QNAME = new QName("http://www.korusconsulting.ru/PDManager/", "PDManager_Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Project/PDM/war/src/resourses/wsdl/PDManager.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PDMANAGERSERVICE_WSDL_LOCATION = url;
        PDMANAGERSERVICE_EXCEPTION = e;
    }

    public PDManagerService() {
        super(__getWsdlLocation(), PDMANAGERSERVICE_QNAME);
    }

    public PDManagerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PDMANAGERSERVICE_QNAME, features);
    }

    public PDManagerService(URL wsdlLocation) {
        super(wsdlLocation, PDMANAGERSERVICE_QNAME);
    }

    public PDManagerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PDMANAGERSERVICE_QNAME, features);
    }

    public PDManagerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PDManagerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PDManager
     */
    @WebEndpoint(name = "PDManagerSOAP")
    public PDManager getPDManagerSOAP() {
        return super.getPort(new QName("http://www.korusconsulting.ru/PDManager/", "PDManagerSOAP"), PDManager.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PDManager
     */
    @WebEndpoint(name = "PDManagerSOAP")
    public PDManager getPDManagerSOAP(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.korusconsulting.ru/PDManager/", "PDManagerSOAP"), PDManager.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PDMANAGERSERVICE_EXCEPTION!= null) {
            throw PDMANAGERSERVICE_EXCEPTION;
        }
        return PDMANAGERSERVICE_WSDL_LOCATION;
    }

}
