package ru.korus.tmis.pdm;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ls.DOMImplementationLS;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Collections;
import java.util.Set;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        24.08.13, 22:54 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PdmSOAPHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public Set<QName> getHeaders()
    {
        return Collections.emptySet();
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean outboundProperty = (Boolean)
                context.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);
      /*  SOAPBody body = null;
        try {
            body = context.getMessage().getSOAPBody();
        } catch (SOAPException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (outboundProperty.booleanValue()) {
            System.out.println("\nOutbound message:" +
                    ((DOMImplementationLS)(body.getOwnerDocument().getImplementation())).createLSSerializer().writeToString(body));
        } else {
            System.out.println("\nInbound message:" +
                    ((DOMImplementationLS)(body.getOwnerDocument().getImplementation())).createLSSerializer().writeToString(body));
        }

        System.out.println("** Response: " + context.getMessage().toString());*/
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {
    }

    private Element getChildByName(Element parent, String name)
    {
        for(Node child = parent.getFirstChild(); child != null; child = child.getNextSibling())
        {
            if(child instanceof Element && name.equals(child.getNodeName())) {
                return (Element) child;
            }
        }
        return null;
    }

}
